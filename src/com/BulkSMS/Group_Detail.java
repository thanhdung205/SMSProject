package com.BulkSMS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Group_Detail extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.groupdetail);
		final Database_Command com = new Database_Command(this);
		
		 ListView ls = (ListView) findViewById(R.id.Group_ListDetail);
		 
		 final ArrayListContact array = new ArrayListContact();
	     //AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListContact());
	    // ls.setAdapter(ap);
		 LinearLayout btDelete = (LinearLayout) findViewById(R.id.Group_Deletegroup);
	     LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
	     btDelete.setOnClickListener(new OnClickListener(){
	    	 public void onClick(View arg0) {
				com.Delete_tblContact(All_Var.Group_ID);
				com.Delete_tblGroup(All_Var.Group_ID);
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}
		 });
		
	}
}
