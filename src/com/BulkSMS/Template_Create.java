package com.BulkSMS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class Template_Create extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createtemplate);
		
		LinearLayout btCancel = (LinearLayout) findViewById(R.id.Template_btCancel);
		btCancel.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				//startActivity(new Intent("com.BulkSMS.CLEARSCREEN6"));
				finish();
				
			}
			
		});
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				
			
				finish();
			}
			 
		 });
		
	}
	

}
