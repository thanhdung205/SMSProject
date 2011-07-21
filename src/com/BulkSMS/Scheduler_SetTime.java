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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedulersettime);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 final DatePicker date = (DatePicker) findViewById(R.id.Scheduler_datePicker);
		 final TimePicker time = (TimePicker) findViewById(R.id.Scheduler_timePicker);
		 LinearLayout btSet = (LinearLayout) findViewById(R.id.Scheduler_Settime);
		 btSet.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				All_Var.Day = date.getDayOfMonth();
				All_Var.Month = date.getMonth();
				All_Var.Year = date.getYear();
				All_Var.Hour = time.getCurrentHour();
				All_Var.Minute = time.getCurrentMinute();
				All_Var.Date = All_Var.Hour + ":"+ All_Var.Minute + " " + All_Var.Day +"/" + All_Var.Month + "/" +  All_Var.Year;
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}		 
		 });
	}
}

