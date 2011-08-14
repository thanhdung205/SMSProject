package com.BulkSMS;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class History_Detail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historydetail);
		TextView TextContent = (TextView) findViewById(R.id.History_Content);
		ListView ls = (ListView) findViewById(R.id.History_ListContact);
		int ID = All_Var.ID_History;
		TextContent.setText(All_Var.Content_History);
		ArrayListHistoryDetail list = new ArrayListHistoryDetail(this);
		AdapterListViewContactSub ap = new AdapterListViewContactSub(this,R.layout.customcontactlistviewsub,list.GetListFromID(ID));
		ls.setAdapter(ap);
		final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
			
				finish();
			}
			 
		 });
	}
	
	
}
