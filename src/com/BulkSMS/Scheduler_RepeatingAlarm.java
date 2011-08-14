package com.BulkSMS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


public class Scheduler_RepeatingAlarm {
	Date pdate =new Date();
	StructAutoSend au;
	public void Send(Context con)
	{
		Database_Command com = new Database_Command(con);
		com.DeleteAllSaveID();
		AlarmManager alarm;
		Intent intent1 = new Intent(con,SchedulerBroadcastReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(con, 0,
				    intent1, PendingIntent.FLAG_UPDATE_CURRENT);
		StructAutoSend autosend = GetAutoSend(con);
		
		if(autosend != null){
			
			com.Insert_tblSaveID(autosend.GetID(),autosend.GetContent());
			Calendar cal = Calendar.getInstance();
			cal = ConvertDateTime(autosend.GetDateTime());
	        alarm = (AlarmManager) con.getSystemService(Context.ALARM_SERVICE);
	        alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
		}
	}
	public StructAutoSend GetAutoSend(Context con)
	{
		Database_Command data = new Database_Command(con);
		ArrayList<StructAutoSend> auto = new  ArrayList<StructAutoSend>();
		auto = data.GetListAutoSend();
		if(auto.size() >0){
			Calendar g = Calendar.getInstance();
			long curdate = g.getTimeInMillis();
			ArrayList<StructAutoSend> listnewdate = new ArrayList<StructAutoSend>(); 
			for(int i =0;i< auto.size();i++){
				
				if(ConvertDateTime(auto.get(i).GetDateTime()).getTimeInMillis() > curdate){
					listnewdate.add(auto.get(i));
				}
			}
			if(listnewdate.size() > 0){
					StructAutoSend autosend = listnewdate.get(0); 
					for(int i =0; i < listnewdate.size();i++){
						if(ConvertDateTime(autosend.GetDateTime()).getTimeInMillis() > ConvertDateTime(listnewdate.get(i).GetDateTime()).getTimeInMillis()){
							autosend = listnewdate.get(i);
						}
					}
					return autosend;
			}
		}
		return null;
	} 
	public Calendar ConvertDateTime(String str){
		Calendar cal = Calendar.getInstance();
		String time = str.split(" ")[0];
		String date = str.split(" ")[1];
		int hour = Integer.parseInt(time.split(":")[0]);
		int minute = Integer.parseInt(time.split(":")[1]);
		int day = Integer.parseInt(date.split("/")[0]);
		int month = Integer.parseInt(date.split("/")[1]);
		int year = Integer.parseInt(date.split("/")[2]);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.DAY_OF_MONTH,day);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.SECOND, 0);
		return cal;
	}
}

