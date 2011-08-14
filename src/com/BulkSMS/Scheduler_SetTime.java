package com.BulkSMS;


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
		 final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 final DatePicker date = (DatePicker) findViewById(R.id.Scheduler_datePicker);
		 final TimePicker time = (TimePicker) findViewById(R.id.Scheduler_timePicker);
		 if(!time.is24HourView()){
				time.setIs24HourView(true);
			}
		 final LinearLayout btSet = (LinearLayout) findViewById(R.id.Scheduler_Settime);
		 btSet.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
				
				ButtonAnimation.ChangingAnimaionBack(btSet);
				String str = time.getCurrentHour() + ":" + time.getCurrentMinute() + " " + date.getDayOfMonth() + "/" + ((int)date.getMonth() + 1) + "/" + date.getYear();
				All_Var.Date =  str;
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();
			}		 
		 });
	}
}

