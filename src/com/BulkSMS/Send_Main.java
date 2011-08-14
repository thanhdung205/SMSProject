package com.BulkSMS;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.telephony.SmsManager;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.LinearLayout;

public class Send_Main extends Activity {
	int flag = 0;
	String DateTime ;
	String number;
	
	Database_Command com;
	ArrayList<StructContact> listnum ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainsms);
		
		 final EditText txtNumber = (EditText) findViewById(R.id.Send_TextNumberphone);
		 final EditText txtContent = (EditText) findViewById(R.id.Send_TextContent);
		 com = new Database_Command(this);
		 final Context con =this;
		 final LinearLayout btSend = (LinearLayout) findViewById(R.id.Send_btSend);
		 final LinearLayout btSelectTemplate = (LinearLayout) findViewById(R.id.SMS_SelectAvailableTemplate);
		 final LinearLayout btSelectOnlineTemplate = (LinearLayout) findViewById(R.id.SMS_SelectOnlineTemplate);
		 SetTextContent(txtContent);
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
		 
		 btSend.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btSend);
				number = txtNumber.getText().toString();
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
				if(listnum == null)
				{
							com.Insert_tblHistory(GetDateTime(), txtContent.getText().toString(),"Da thuc hien");
							int count = com.GetRowNumberHistoryContact();
							com.Insert_tblSaveIDSend(count);
							SendSMS(0,txtContent.getText().toString(),com.GetReplace());
							com.Insert_tblHistory_Contact(count,"",number);
				}
				else{
					
							number = txtContent.getText().toString();
							com.Insert_tblHistory(GetDateTime(), txtContent.getText().toString(),"Da thuc hien");
							int count = com.GetRowNumberHistoryContact();
							com.Insert_tblSaveIDSend(count);
							SendSMS(1,txtContent.getText().toString(),com.GetReplace());
							for(int i = 0 ; i < listnum.size(); i++)
							{
								com.Insert_tblHistory_Contact(count, listnum.get(i).GetName(), listnum.get(i).GetNumberPhone());
							}
						}
					
					
				finish();
				
			}
				
			
		 });
		 final LinearLayout btAdd = (LinearLayout) findViewById(R.id.Send_btAdd);
		 btAdd.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btAdd);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN5"));
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
		super.onResume();
		EditText txtNumber = (EditText) findViewById(R.id.Send_TextNumberphone);
		String content="";
		if(All_Var.Detail_Content != null){
			EditText txtContent = (EditText) findViewById(R.id.Send_TextContent);
			txtContent.setText(All_Var.Detail_Content);
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
		
		
	}
	public void SetTextContent(EditText content)
	{
		if(All_Var.Text_Content!= null)
		{
			content.setText(All_Var.Text_Content);
			All_Var.Text_Content=null;
			
		}
	}
	public void SendSMS(int flag,String Content,String RepChar)
	{
	
	             	
		SmsManager sms = SmsManager.getDefault();
		if(flag == 1){
			for(int i =0;i<listnum.size();i++)
			{
				String Con = Content;
			
				if(!Con.contains(RepChar)){
					sms.sendTextMessage(listnum.get(i).GetNumberPhone(), null, Content, null, null);}
					else{
					if(listnum.get(i).GetName()==null)
						Con.replace(RepChar, listnum.get(i).GetNumberPhone());
					Con = Con.replace(RepChar, listnum.get(i).GetName());
					sms.sendTextMessage(listnum.get(i).GetNumberPhone(), null, Con, null, null);}
				
				
				
			}
		}
		else{
			if(Content.contains(RepChar))
			{
				Content = Content.replace(RepChar, number);
			}
			
			sms.sendTextMessage(number,null, Content, null, null);
		}
			
	}
	public String GetDateTime()
	{
		Calendar cel = Calendar.getInstance();
		int Year = cel.get(Calendar.YEAR);
		int Month = cel.get(Calendar.MONTH);
		int Day = cel.get(Calendar.DAY_OF_MONTH);
		int Hour = cel.get(Calendar.HOUR_OF_DAY);
		int Minute = cel.get(Calendar.MINUTE);
		return Hour+":" + Minute + "  " + Day + "/" + Month + "/" +  Year;
	}
}
