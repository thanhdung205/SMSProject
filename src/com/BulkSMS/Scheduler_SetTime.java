package com.BulkSMS;

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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedulersettime);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 final DatePicker date = (DatePicker) findViewById(R.id.Scheduler_datePicker);
		 final TimePicker time = (TimePicker) findViewById(R.id.Scheduler_timePicker);
		 LinearLayout btSet = (LinearLayout) findViewById(R.id.Scheduler_Settime);
		 btSet.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				if(!time.is24HourView()){
					time.setIs24HourView(true);
				}
				Date datetime = new Date();
				datetime.setDate(date.getDayOfMonth());
				datetime.setMonth(date.getMonth());
				datetime.setYear(date.getYear());
				datetime.setHours(time.getCurrentHour());
				datetime.setMinutes(time.getCurrentMinute());
				long time = datetime.getTime();
				All_Var.Date =time;
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}		 
		 });
	}
}

