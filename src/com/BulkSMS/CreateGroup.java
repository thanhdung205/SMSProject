package com.BulkSMS;



import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class CreateGroup extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creategroup);
		
		
		LinearLayout bt = (LinearLayout) findViewById(R.id.bt_CreateGroup1);
		final EditText Text_GName =  (EditText) findViewById(R.id.text_GroupName);
		final Database_Command com = new Database_Command(this);
		 bt.setOnClickListener(new OnClickListener(){
			 
			public void onClick(View arg0) {
				int row = com.AutoIncreasing(com.GetDatabaseCreate().GetTableGroup());
				com.Insert_tblGroup("" + row + "", Text_GName.getText().toString());
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


