package com.BulkSMS;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.ListView;

public class CreateGroup extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creategroup);
		
		 ListView ls = (ListView) findViewById(R.id.ContactList);
		 ImageView bt = (ImageView) findViewById(R.id.bt_CreateGroup1);
		 final EditText Text_GName =  (EditText) findViewById(R.id.text_GroupName);
		 final ArrayListContact array = new ArrayListContact();
		 array.SetListContact();
	     AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListContact());
	     ls.setAdapter(ap);
	     ls.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//Struct_ListViewContact listselect= (Struct_ListViewContact) arg0.getItemAtPosition(arg2);
				if(array.GetListContact().get(arg2).GetIsChecked())
				{
					Text_GName.setText("True");
				}
				else
				{
					Text_GName.setText("False");
				}
				
			}});
	

}
}
