package com.BulkSMS;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.IBinder;
public class Scheduler_Service extends Service {
	SQLiteDatabase DB;
	String DatabaseName ="DatabaseBulkSMS4";
    MediaPlayer mMediaPlayer;
	@Override
	public void onCreate() {		
		super.onCreate();
		final Notification n = new Notification();
		n.flags |= Notification.FLAG_ONGOING_EVENT;
		Intent intent = new Intent(this, MainProgram.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		n.contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		startForeground(1, n);
		DB = this.openOrCreateDatabase(DatabaseName, Context.MODE_PRIVATE, null);
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	@Override
	public IBinder onBind(Intent arg0) {
	    return null;
	}
}
