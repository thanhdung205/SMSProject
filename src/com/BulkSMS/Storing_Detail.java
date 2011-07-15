package com.BulkSMS;

import android.app.Activity;
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
		 txtContent.setText(All_Var.Text_Content);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				
			
				finish();
			}
			 
		 });
	}
	
	

}
