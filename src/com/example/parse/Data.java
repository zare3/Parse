package com.example.parse;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.adapters.DataListAdapter;
import com.example.classes.DataEntry;
import com.example.classes.Message;
import com.example.database.MySQLiteHelper;


public class Data extends ActionBarActivity {

	List<Message> msgs;
	ListView dataList;
	ArrayList<DataEntry> dataArrayList = new ArrayList<DataEntry>();
	DataListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		
		initializeView();
		
	}

	private void initializeView ()
	{
		matchComponentsWithIDs();
		getMessages();
		setComponents();
		
	}
	
	private void matchComponentsWithIDs()
	{
		dataList = (ListView) findViewById(R.id.dataListView);
	}
	
	private void setComponents ()
	{
		setList();
	}
	
	private void setList ()
	{
		adapter = new DataListAdapter(this, dataArrayList);
		dataList.setAdapter(adapter);
	}
	
	private void getMessages()
	{
		 MySQLiteHelper db = new MySQLiteHelper(this);
		 msgs=db.getAllMessages();
		
		
		 for (int i=0; i<msgs.size(); i++)
		 {
			 String content = msgs.get(i).getContent();
			 String sender = msgs.get(i).getSender();
			  Log.d("sender from data", sender);
			 
			  String timing;
			  int offset;
			  int ind = 76;
			  while (content.charAt(ind)!='ن')
			  {
				  ind++;
			  }
			  //ind = 8 at single char 
			  offset = (ind-76)-8;
			  int scndOff = 0;
			  if (content.charAt(37)=='ص')
			  {
				  timing = "AM";
			  }
			  else
			  {
				  timing = "PM";
			  }
			  if (offset==3)
				  scndOff++;
			 DataEntry tempDataEntry = new DataEntry(content.substring(17, 36)+" "+timing, content.substring(78,83+offset), content.substring(116+offset,119+offset)+"-"+content.substring(119+offset,123+offset)+"-"+content.substring(123+offset,127+offset), content.substring(179+offset-scndOff,185+offset-scndOff));
			 dataArrayList.add(tempDataEntry);
		 }
//public DataEntry (String date, String amount, String phoneNumber, String approvalNumbe
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
