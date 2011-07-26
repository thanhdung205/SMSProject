package com.BulkSMS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Storing_Detail extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storingdetail);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 TextView txtContent = (TextView) findViewById(R.id.Storing_Content);
		 if(All_Var.Text_Content!= null){
		 txtContent.setText(All_Var.Text_Content);
		 }
		 if(All_Var.ContentDetail!= null){
			 txtContent.setText(All_Var.ContentDetail.GetContent());
		 }
		 All_Var.Text_Content = null;
		 All_Var.ContentDetail = null;
		 LinearLayout btSend = (LinearLayout) findViewById(R.id.Storing_btSend);
		 btSend.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN4"));
				finish();
			}
		 });
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}
		 });
	}
	@Override
	protected void onStop() {
		super.onStop();	
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
	

}
