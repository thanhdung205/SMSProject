package com.BulkSMS;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Scheduler_Send extends Activity{
	int flag = 0;
	String DateTime;
	AlarmManager alarm;
	int ID;
	ArrayList<StructContact> listnum = new ArrayList<StructContact>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.scheduler);
		EditText txtNumber = (EditText) findViewById(R.id.Scheduler_TextNumberphone);
		final EditText txtContent = (EditText) findViewById(R.id.Scheduler_TextContent);
		final Database_Command com = new Database_Command(this);
		LinearLayout btAddTime =(LinearLayout) findViewById(R.id.Scheduler_btSubSettime);
		ImageView btSend1 =(ImageView) findViewById(R.id.Scheduler_btSend12);
		ImageView btAddContact =(ImageView) findViewById(R.id.Scheduler_btAdd);
		final Intent intent1 = new Intent(this,SchedulerBroadcastReceiver.class);
		  final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
				    intent1, PendingIntent.FLAG_ONE_SHOT);
		btAddContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN5"));
			}});
			btSend1.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
						Calendar cal = Calendar.getInstance();
						cal.set(Calendar.DAY_OF_MONTH, All_Var.Day); 
				        cal.set(Calendar.HOUR_OF_DAY, All_Var.Hour); 
				        cal.set(Calendar.MINUTE, All_Var.Minute); 
				        cal.set(Calendar.MONTH, All_Var.Month);
				        cal.set(Calendar.YEAR, All_Var.Year);
				        cal.set(Calendar.SECOND, 0);
				        SaveData(com,txtContent.getText().toString());
				        All_Var.ID_AutoSend = ID;
				        
				        alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
				        alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
				
				        finish();
			}});
		btAddTime.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN12"));
				
			}});
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				finish();
			}
		 });
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		EditText txtNumber = (EditText) findViewById(R.id.Scheduler_TextNumberphone);
		String content="";
		if(All_Var.listnumber != null)
		{
			flag = 1;
			listnum = All_Var.listnumber;
			for(int i = 0;i<All_Var.listnumber.size();i++)
			{
				if(i+1<All_Var.listnumber.size())
				content += All_Var.listnumber.get(i).GetNumberPhone() + " , ";
				else
					content +=All_Var.listnumber.get(i).GetNumberPhone() ;
			}
			txtNumber.setText(content);
			All_Var.listnumber = null;
		}
		if(All_Var.Date != null){
			DateTime = All_Var.Date;
			All_Var.Date = null;
		}
	}
	public void SaveData(Database_Command com,String Content){
		
		com.Insert_tblAutoSend(DateTime, Content);		
		ID = com.GetRowNumberAutoSend();
		
		for(int i = 0 ; i < listnum.size();i++){
			com.Insert_tblAutoSend_Contact(ID, listnum.get(i).GetName(),listnum.get(i).GetNumberPhone());
		}
	//	DialogOK c = new DialogOK(this,"haha",com.GetListAutoSendContact().size() + "");
	//	c.ShowMes();
	}
}
