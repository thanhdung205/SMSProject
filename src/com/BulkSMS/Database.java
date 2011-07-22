package com.BulkSMS;



import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Database {
	SQLiteDatabase DB;
	Context conte;
	String DatabaseName ="DatabaseBulkSMS11";
	public SQLiteDatabase GetDatabase(){
		return DB;
	}
	public Database(Context ctx)
	{
		conte = ctx;
	}
	public void CreateDatabase()
	{
		DB = conte.openOrCreateDatabase(DatabaseName, Context.MODE_PRIVATE, null);	
	}
	public boolean CheckDatabase(){
    	try{    		
    		DB = SQLiteDatabase.openDatabase(DatabaseName, null, SQLiteDatabase.OPEN_READONLY);	
    	}catch(SQLiteException e){
    		return false;
    	}
    	return true;
    }
}
