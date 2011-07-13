package com.BulkSMS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Send_ContactGroup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smscontactgroup);
		
		LinearLayout btContact = (LinearLayout) findViewById(R.id.Send_tabContact);
		LinearLayout btGroup = (LinearLayout) findViewById(R.id.Send_tabGroup);
		LinearLayout btCancel = (LinearLayout) findViewById(R.id.Send_btCancel);
		
		final ListView list = (ListView) findViewById(R.id.Send_GroupContact);
		
		ArrayListContact array = new ArrayListContact();
		array.SetListContact();
	    final AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListContact());
		list.setAdapter(ap);
		
	   // array.SetListGroup();
	    //final AdapterListviewContact ap1 = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListGroup());
		
		btContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				list.setAdapter(ap);
			    
			}
			
		});
		btGroup.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				//list.setAdapter(ap1);
				
			}
			
		});
		
		btCancel.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
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
