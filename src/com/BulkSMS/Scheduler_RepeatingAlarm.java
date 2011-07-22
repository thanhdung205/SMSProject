package com.BulkSMS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

public class Scheduler_RepeatingAlarm {
	Date pdate =new Date();
	StructAutoSend au;
	public void Send(Context con)
	{
		
		
		AlarmManager alarm;
		Intent intent1 = new Intent(con,SchedulerBroadcastReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(con, 0,
				    intent1, PendingIntent.FLAG_ONE_SHOT);
		Calendar cal = Calendar.getInstance();
		GetAutoSend(con);
		cal.set(Calendar.YEAR, pdate.getYear());
		cal.set(Calendar.MONTH, pdate.getMonth());
		cal.set(Calendar.DAY_OF_MONTH, pdate.getDate());
		cal.set(Calendar.HOUR_OF_DAY, pdate.getHours());
		cal.set(Calendar.MINUTE, pdate.getMinutes());
		//cal.add(cal.SECOND,100);
		//SmsManager sms = SmsManager.getDefault();
		
		//sms.sendTextMessage("01649551170", null, "uh" , null, null);
        alarm = (AlarmManager) con.getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
        
	}
	public void GetAutoSend(Context con)
	{
		
		Database_Command data = new Database_Command(con);
		ArrayList<StructAutoSend> auto = new  ArrayList<StructAutoSend>();
		auto = data.GetListAutoSend(); 
		long curdate = System.currentTimeMillis();
		StructAutoSend autosend = auto.get(0); 
		for(int i =0;i< auto.size();i++){
			if(Long.parseLong(auto.get(i).GetDateTime()) > curdate
					&& Long.parseLong(auto.get(i).GetDateTime())
							< Long.parseLong(autosend.GetDateTime())){
				autosend = auto.get(i);
			}
		}
		
	
		DialogOK a = new DialogOK(con,"haha", autosend.GetID() + " " +  curdate);
		a.ShowMes();
		
		
		
	}
	
	
}
