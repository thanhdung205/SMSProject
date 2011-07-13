package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class History_Detail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historydetail);
		
		ArrayList<String> ds = new ArrayList<String>();
		 ds.add("Contact 1");
		 ds.add("Contact 2");
		 ds.add("Contact 3");
		 ds.add("Contact 4");
		 ds.add("Contact 6");
		 ds.add("Contact 7");
		 ds.add("Contact 8");
		 ds.add("Contact 9");
		 ds.add("Contact 10");
		 
		TextView tv =(TextView) findViewById(R.id.History_Content);
		tv.setText("Nội dung");
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ds);
		 ListView ls = (ListView) findViewById(R.id.History_ListContact);
		 ls.setAdapter(adapter);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				
			
				finish();
			}
			 
		 });
	}
	
}
