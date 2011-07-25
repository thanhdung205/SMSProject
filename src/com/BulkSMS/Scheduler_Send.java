package com.BulkSMS;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlarmManager;
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
	Context con;
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
		con = this;
		btAddContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN5"));
			}});
			btSend1.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
			
				        SaveData(com,txtContent.getText().toString());
						Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
						sche.Send(con);
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
		com.Insert_tblAutoSend(DateTime, Content,"Chưa gửi");		
		ID = com.GetRowNumberAutoSend();
		for(int i = 0 ; i < listnum.size();i++){
			com.Insert_tblAutoSend_Contact(ID, listnum.get(i).GetName(),listnum.get(i).GetNumberPhone());
		}
	
	}
}
