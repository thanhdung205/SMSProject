package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Send_Main extends Activity {
	int flag = 0;
	ArrayList<String> listnum = new ArrayList<String>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainsms);
		
		 EditText txtNumber = (EditText) findViewById(R.id.Send_TextNumberphone);
		 final EditText txtContent = (EditText) findViewById(R.id.Send_TextContent);
		 ImageView btSend = (ImageView) findViewById(R.id.Send_btSend);
		 LinearLayout btSelectTemplate = (LinearLayout) findViewById(R.id.SMS_SelectAvailableTemplate);
		 SetTextContent(txtContent);
		 btSelectTemplate.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN6"));
				finish();
			}});
		 btSend.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
				SendSMS(txtContent.getText().toString());
				finish();
			}});
		 
		 ImageView btAdd = (ImageView) findViewById(R.id.Send_btAdd);
		 
		 btAdd.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN5"));
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
		EditText txtNumber = (EditText) findViewById(R.id.Send_TextNumberphone);
		String content="";
		if(All_Var.listnumber != null)
		{
			flag = 1;
			listnum = All_Var.listnumber;
			for(int i = 0;i<All_Var.listnumber.size();i++)
			{
				if(i+1<All_Var.listnumber.size())
				content += All_Var.listnumber + " , ";
				else
					content +=All_Var.listnumber ;
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
	public void SendSMS(String Content)
	{
		SmsManager sms = SmsManager.getDefault();
		for(int i =0;i<listnum.size();i++)
		{
			sms.sendTextMessage(listnum.get(i), null, Content, null, null);
		}
		
	}
}
