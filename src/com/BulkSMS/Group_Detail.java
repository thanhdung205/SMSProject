package com.BulkSMS;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class Group_Detail extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.groupdetail);
		
		 ListView ls = (ListView) findViewById(R.id.Group_ListDetail);
		 
		 
		 final ArrayListContact array = new ArrayListContact();
		 array.SetListContact();
	     AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListContact());
	     ls.setAdapter(ap);
		
	}
}
