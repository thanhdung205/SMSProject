package com.BulkSMS;

import java.util.ArrayList;
import org.ksoap2.SoapFault;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Storing_Main extends Activity{

	ConnectService con;
	ArrayList<StructTemplate> listtem;
	ListView ls;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storingonlinemain);
		ls = (ListView) findViewById(R.id.Storing_TitleList); 
		con = new ConnectService(this);
		listtem = new ArrayList<StructTemplate>();
		final Context a = this;
		
		final ProgressDialog progressDialog = ProgressDialog.show(this, "", "Đang tải...");
		new Thread() {

		public void run() {
		try{
			 try {
					listtem = con.GetTemplate1();
					
				} catch (SoapFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (Exception e) {
		}
		progressDialog.dismiss();
		}
		}.start();
		progressDialog.setOnDismissListener( new OnDismissListener(){
			public void onDismiss(DialogInterface arg0) {
				AdapterListViewService adapter = new AdapterListViewService(a,R.layout.customnetworklistview,listtem);
				ls.setAdapter(adapter);
			}});
		ls.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				All_Var.ID_Subject = (StructTemplate) arg0.getItemAtPosition(arg2);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN14"));
			}});
		 final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();
			} 
		 });
	}
	

}
