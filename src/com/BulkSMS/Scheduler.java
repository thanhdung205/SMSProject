package com.BulkSMS;


import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Scheduler extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedulermain);
		ListView list = (ListView) findViewById(R.id.Scheduler_ListSMSAuto);
		Database_Command com = new Database_Command(this);
		AdapterListViewAuto adapter = new AdapterListViewAuto(this,R.layout.customautosendlistview,com.GetListAutoSend());
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				StructAutoSend auto = (StructAutoSend) arg0.getItemAtPosition(arg2);
				All_Var.ID_AutoSend = auto.GetID();
				All_Var.Content_AutoSend = auto.GetContent();
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN18"));
			}});
		LinearLayout btAdd = (LinearLayout) findViewById(R.id.Scheduler_btAddMain);
				btAdd.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN11"));
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
		ListView list = (ListView) findViewById(R.id.Scheduler_ListSMSAuto);
		Database_Command com = new Database_Command(this);
		AdapterListViewAuto adapter = new AdapterListViewAuto(this,R.layout.customautosendlistview,com.GetListAutoSend());
		list.setAdapter(adapter);
	}

	public ArrayList<StructAutoSend> GetStructAutoSend(){
		ArrayList<StructAutoSend> list = new ArrayList<StructAutoSend>();
		return list;
	}
	
}
