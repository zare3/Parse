package com.example.sms_handler;

import com.example.classes.Message;
import com.example.database.MySQLiteHelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class IncomingSms extends BroadcastReceiver {
	
	// Get the object of SmsManager
	final SmsManager sms = SmsManager.getDefault();
	
	public void onReceive(Context context, Intent intent) {
	
		// Retrieves a map of extended data from the intent.
		final Bundle bundle = intent.getExtras();
		//String masterCardNum = new String ("+201148220222");
		String uniqueStringId = new String ("ماستركارد");

		try {
			
			if (bundle != null) {
				
				final Object[] pdusObj = (Object[]) bundle.get("pdus");
				String message = new String ();
				String senderNum = new String ();
				for (int i = 0; i < pdusObj.length; i++) {
					
					SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
					String phoneNumber = currentMessage.getDisplayOriginatingAddress();
					
			         senderNum= phoneNumber;
			         message += currentMessage.getDisplayMessageBody();
			       
				} // end for loop
				 if ( (message.substring(0, 9)).equals(uniqueStringId)) 
				 {
			       
					MySQLiteHelper db = new MySQLiteHelper(context);
			        Message newMsg = new Message (senderNum,message);
			        db.addMsg(newMsg);
			        
				 }
			        
			       
			      
					
				
              } // bundle is null

		} catch (Exception e) {
			Log.e("SmsReceiver", "Exception smsReceiver" +e);
			
		}
	}
		
	
}