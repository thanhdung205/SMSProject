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
import android.widget.LinearLayout;


public class Scheduler_Send extends Activity{
	int flag = 0;
	String DateTime;
	AlarmManager alarm;
	int ID;
	Context con;
	ArrayList<StructContact> listnum ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.scheduler);
		final EditText txtNumber = (EditText) findViewById(R.id.Scheduler_TextNumberphone);
		final EditText txtContent = (EditText) findViewById(R.id.Scheduler_TextContent);
		final Database_Command com = new Database_Command(this);
		final LinearLayout btSelectTemplate =(LinearLayout) findViewById(R.id.Scheduler_btSelectTemplate);
		final LinearLayout btSelectOnlineTemplate =(LinearLayout) findViewById(R.id.Scheduler_btSelectOnlineTemplate);
		final LinearLayout btAddTime =(LinearLayout) findViewById(R.id.Scheduler_btSubSettime);
		final LinearLayout btSend1 =(LinearLayout) findViewById(R.id.Scheduler_btSend12);
		final LinearLayout btAddContact =(LinearLayout) findViewById(R.id.Scheduler_btAdd);
		con = this;
		btSelectTemplate.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btSelectTemplate);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN6"));
			}});
		btSelectOnlineTemplate.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btSelectOnlineTemplate);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN13"));
			}});
		btAddContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btAddContact);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN5"));
			}});
			btSend1.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					ButtonAnimation.ChangingAnimaion(btSend1);
					if(DateTime == null){
						DialogOK dia1 = new DialogOK(con,"Thong bao","Ban chua thiet lap thoi gian");
						dia1.ShowMes();
						return;
					}
					if(txtNumber.getText().toString().length() == 0){
						DialogOK dia1 = new DialogOK(con,"Thong bao","Ban chua nhap vao so dien thoai");
						dia1.ShowMes();
						return;
					}
					if(txtContent.getText().toString().length() == 0){
						DialogOK dia1 = new DialogOK(con,"Thong bao","Ban chua nhap vao noi dung");
						dia1.ShowMes();
						return;
					}
					if(listnum != null){
					
								 SaveData(com,txtContent.getText().toString());
									Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
									sche.Send(con);
							}
									       
					
					else
					{
						
								SaveData1(com,txtContent.getText().toString(),txtNumber.getText().toString());
								Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
								sche.Send(con);
							
					}
				    finish();
			
					
			}});
		btAddTime.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btAddTime);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN12"));
				
			}});
		 final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
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
				if(All_Var.Detail_Content!= null){
					EditText txtContent = (EditText) findViewById(R.id.Scheduler_TextContent);
					txtContent.setText(All_Var.Detail_Content);
					All_Var.Detail_Content= null;
				}
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
		com.Insert_tblAutoSend(DateTime, Content,"Chua thuc hien");		
		ID = com.GetRowNumberAutoSend();
		for(int i = 0 ; i < listnum.size();i++){
			com.Insert_tblAutoSend_Contact(ID, listnum.get(i).GetName(),listnum.get(i).GetNumberPhone());
		}
	
	}
	public void SaveData1(Database_Command com,String Content,String number){
		com.Insert_tblAutoSend(DateTime, Content,"Chua thuc hien");		
		ID = com.GetRowNumberAutoSend();
		com.Insert_tblAutoSend_Contact(ID, "",number);
		
	
	}
}
