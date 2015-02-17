package com.example.database;

import java.util.LinkedList;
import java.util.List;

import com.example.classes.Message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class MySQLiteHelper extends SQLiteOpenHelper {
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MessagesDB";
 
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create msgs table
        String CREATE_MESSAGE_TABLE = "CREATE TABLE messages ( " +
                "sender TEXT, "+
                "content TEXT )";
 
        // create msgs table
        db.execSQL(CREATE_MESSAGE_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older msgs table if existed
        db.execSQL("DROP TABLE IF EXISTS messages");
 
        // create fresh msgs table
        this.onCreate(db);
    }
    
    // Messages table name
    private static final String TABLE_MESSAGES= "messages";

    // Messages Table Columns names
    private static final String KEY_CONTENT = "content";
    private static final String KEY_SENDER = "sender";

    private static final String[] COLUMNS = {KEY_CONTENT,KEY_SENDER};
    
	public void addMsg(Message msg)
	
	{
        //for logging
	Log.d("addMsg", msg.toString()); 

	// 1. get reference to writable DB
	SQLiteDatabase db = this.getWritableDatabase();

	// 2. create ContentValues to add key "column"/value
	ContentValues values = new ContentValues();
	values.put(KEY_CONTENT, msg.getContent()); // get content 
	values.put(KEY_SENDER, msg.getSender()); // get sender

	// 3. insert
	db.insert(TABLE_MESSAGES, // table
        null, //nullColumnHack
        values); // key/value -> keys = column names/ values = column values

	// 4. close
	db.close(); 
}
	
	public List<Message> getAllMessages() {
        List<Message> msgs = new LinkedList<Message>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_MESSAGES;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build msg and add it to list
        Message msg = null;
        if (cursor.moveToFirst()) {
            do {
                msg = new Message();
                msg.setSender(cursor.getString(0));
                msg.setContent(cursor.getString(1));
 
                // Add msg to msgs
                msgs.add(msg);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllMessage()", msgs.toString());
 
        // return books
        return msgs;
    }
	
    
				    
 
}