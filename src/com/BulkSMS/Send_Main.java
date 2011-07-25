package com.BulkSMS;

import java.util.ArrayList;
import java.util.Calendar;

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
	String DateTime ;
	ArrayList<StructContact> listnum = new ArrayList<StructContact>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainsms);
		
		 EditText txtNumber = (EditText) findViewById(R.id.Send_TextNumberphone);
		 final EditText txtContent = (EditText) findViewById(R.id.Send_TextContent);
		 final Database_Command com = new Database_Command(this);
	
			
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
				SendSMS(txtContent.getText().toString(),com.GetReplace());
				com.Insert_tblHistory(GetDateTime(), txtContent.getText().toString());
				int count = com.GetRowNumberHistoryContact();
				for(int i = 0 ; i < listnum.size(); i++)
				{
					com.Insert_tblHistory_Contact(count, listnum.get(i).GetName(), listnum.get(i).GetNumberPhone());
				}
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
	public void SendSMS(String Content,String RepChar)
	{
		
		SmsManager sms = SmsManager.getDefault();
		
		for(int i =0;i<listnum.size();i++)
		{
			String Con = Content;
		
			if(Con.contains(RepChar)){
				
				if(listnum.get(i).GetName()==null)
					Con.replace(RepChar, listnum.get(i).GetNumberPhone());
				Con = Con.replace(RepChar, listnum.get(i).GetName());
			}
			sms.sendTextMessage(listnum.get(i).GetNumberPhone(), null, Con, null, null);
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
