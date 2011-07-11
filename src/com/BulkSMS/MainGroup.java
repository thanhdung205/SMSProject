package com.BulkSMS;
import java.util.ArrayList;

import com.BulkSMS.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class MainGroup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.maingroup);
		 ArrayList<String> ds = new ArrayList<String>();
		 ds.add("Group 1");
		 ds.add("Group 2");
		 ds.add("Group 3");
		 ds.add("Group 4");
		 ds.add("Group 6");
		 ds.add("Group 7");
		 ds.add("Group 8");
		 ds.add("Group 9");
		 ds.add("Group 10");
		 
		
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ds);
		 
		 ListView ls = (ListView) findViewById(R.id.Grouplist);
		 ImageView bt = (ImageView) findViewById(R.id.bt_Creategroup);
		 ls.setAdapter(adapter);
		 bt.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN2"));
				
			}
			 
			 
		 });
		 ls.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN3"));
				
			}});
		 }

}
