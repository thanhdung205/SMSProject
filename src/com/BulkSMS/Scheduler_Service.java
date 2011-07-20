package com.BulkSMS;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
public class Scheduler_Service extends Service {
	SQLiteDatabase DB;
	String DatabaseName ="DatabaseBulkSMS4";
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();	
		DB = this.openOrCreateDatabase(DatabaseName, Context.MODE_PRIVATE, null);
		//DB.execSQL("create table tbl_Contact ( ID integer primary key AUTOINCREMENT,ID_Group integer references tbl_Group(ID), Name text, NumberPhone text);");
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
	    return null;
	}
}
