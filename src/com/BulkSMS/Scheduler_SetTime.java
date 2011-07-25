package com.BulkSMS;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

public class Scheduler_SetTime extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedulersettime);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 final DatePicker date = (DatePicker) findViewById(R.id.Scheduler_datePicker);
		 final TimePicker time = (TimePicker) findViewById(R.id.Scheduler_timePicker);
		 if(!time.is24HourView()){
				time.setIs24HourView(true);
			}
		 LinearLayout btSet = (LinearLayout) findViewById(R.id.Scheduler_Settime);
		 btSet.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
				
				//Calendar cal =Calendar.getInstance();
				String str = time.getCurrentHour() + ":" + time.getCurrentMinute() + " " + date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear();
			//	cal.set(date.getYear(),date.getMonth(), date.getDayOfMonth(), time.getCurrentHour(), time.getCurrentMinute());
			//	System.out.println("You are here " + cal.getTimeInMillis());
				All_Var.Date =  str;
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}		 
		 });
	}
}

