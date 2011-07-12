package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Template_Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintemplate);
		
		LinearLayout btCreate = (LinearLayout) findViewById(R.id.Template_btCreate);
		 ArrayList<String> ds = new ArrayList<String>();
		 ds.add("Template 1");
		 ds.add("Template 2");
		 ds.add("Template 3");
		 ds.add("Template 4");
		 ds.add("Template 6");
		 ds.add("Template 7");
		 ds.add("Template 8");
		 ds.add("Template 9");
		 ds.add("Template 10");
		 
		
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ds);
		 
		 ListView ls = (ListView) findViewById(R.id.Template_ListTemplate);

		 ls.setAdapter(adapter);
		 btCreate.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN7"));
			}	 
		 });

	}
	

}
