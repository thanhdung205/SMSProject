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
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainGroup extends Activity {
	ArrayListGroup listgroup = new ArrayListGroup(this);
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ListView ls = (ListView) findViewById(R.id.Grouplist);
		 Binding(ls);
	}
	public void Binding(ListView ls){
		
		 listgroup.SetListGroup();
		 ArrayList<String> listname = listgroup.GetListGroupName();
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listname);
		 ls.setAdapter(adapter);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.maingroup);	 
		 ListView ls = (ListView) findViewById(R.id.Grouplist);
		 Binding(ls);
		 ImageView bt = (ImageView) findViewById(R.id.bt_Creategroup);
		 
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){
			 
			public void onClick(View arg0) {
				finish();
			}
			 
		 });
		 bt.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN2"));
				
			}
			 
			 
		 });
		 ls.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				All_Var.Group_ID = listgroup.GetListGroup().get(arg2).GetID();
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN3"));
			}});
		 }

	private OnClickListener OnClickListener() {
		// TODO Auto-generated method stub
		return null;
	}

}
