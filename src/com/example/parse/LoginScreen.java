package com.example.parse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginScreen extends ActionBarActivity {
	
	Button button;
	EditText usrNameTxtEdt;
	EditText passwordTxtEdt; 
	String correctUserName;
	String correctPassword;
	String enteredUserName;
	String enteredPassword;
	Animation shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        
        InitializeView ();
       
    }

    
    private void InitializeView()
    {
    	matchComponentsWithIDs();
    	fetchUserNameAndPassword();
    	addListenerOnButton();
    	
    	
    }
    
    private void fetchUserNameAndPassword()
    {
    	correctUserName= new String ("Paymob");
    	correctPassword = new String ("12349876");
    }
    private void matchComponentsWithIDs()
    {
    	button = (Button) findViewById(R.id.login_btn);
    	passwordTxtEdt = (EditText) findViewById (R.id.password_edit_text_field);
    	usrNameTxtEdt = (EditText) findViewById (R.id.user_name_text_field);
    	shake = AnimationUtils.loadAnimation(this, R.anim.shake);
    	
    }
    private void setComponents ()
    {
    	enteredUserName = usrNameTxtEdt.getText().toString();
    	enteredPassword = passwordTxtEdt.getText().toString();
    	
    }
    private void addListenerOnButton() {
    	 
		
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
				setComponents();
				if (enteredUserName.equals(correctUserName) && enteredPassword.equals(correctPassword))
					{
						Intent loginToTable = new Intent(LoginScreen.this,Data.class);
						startActivity(loginToTable);
					}
				else
				{
					passwordTxtEdt.startAnimation(shake);
					usrNameTxtEdt.startAnimation(shake);
					Toast.makeText(getApplicationContext(),"Incorrect Authentication Data. Please Try Again",
							   Toast.LENGTH_LONG).show();
				}
 
			}
 
		});
 
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_screen, menu);
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
