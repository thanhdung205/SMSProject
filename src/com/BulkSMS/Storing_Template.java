package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Storing_Template extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storingtemplate);
		
		 ArrayList<String> ds = new ArrayList<String>();
		 ds.add("Template 1");
		 ds.add("Template 2");
		 ds.add("Template 3");
		 ds.add("Template 4");
		 ds.add("Template 6");
		 ds.add("Template 7");
		 ds.add("Template 8");
		 ds.add("Template 9");
	
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ds);
		 ListView ls = (ListView) findViewById(R.id.Storing_TemplateList); 
		ls.setAdapter(adapter);
		ls.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN15"));
				
			}});
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				
			
				finish();
			}
			 
		 });
	}
	
}
