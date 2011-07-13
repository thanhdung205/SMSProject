package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Storing_Main extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storingonlinemain);
		 ArrayList<String> ds = new ArrayList<String>();
		 ds.add("Title 1");
		 ds.add("Title 2");
		 ds.add("Title 3");
		 ds.add("Title 4");
		 ds.add("Title 6");
		 ds.add("Title 7");
		 ds.add("Title 8");
		 ds.add("Title 9");
		 ds.add("Title 10");
		 
		
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ds);
		 ListView ls = (ListView) findViewById(R.id.Storing_TitleList); 
		ls.setAdapter(adapter);
		ls.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN14"));
				
			}});
		
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				
			
				finish();
			}
			 
		 });
	}
	

}
