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
	 ArrayListContact contact;
	 ListView list;
	 TextView text1;
	 public void SetDataListView()
	 {
		 	contact = GetContact();
		    AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,contact.GetListContact());
		    list.setAdapter(ap);
		    text1.setVisibility(View.INVISIBLE);
	 }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creategroup);
		final Handler handle =new  Handler(); 
		final ListView ls = (ListView) findViewById(R.id.ContactList);
		ImageView bt = (ImageView) findViewById(R.id.bt_CreateGroup1);
		list = ls;
		TextView text = (TextView) findViewById(R.id.Group_Loading);
		text1=text;
		text1.setVisibility(View.VISIBLE);
		final EditText Text_GName =  (EditText) findViewById(R.id.text_GroupName);
		
		
		final Runnable posts = new Runnable(){
				public void run() {
					SetDataListView();
				}
		     };
		Thread the = new  Thread(new Runnable() {
			public void run() {
				handle.post(posts);
			}});
		the.start();
	   	     ls.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
			}});
		 final Database_Command com = new Database_Command(this);
		 
		 bt.setOnClickListener(new OnClickListener(){
			 
			public void onClick(View arg0) {
				int row = com.AutoIncreasing(com.GetDatabaseCreate().GetTableGroup());
				com.Insert_tblGroup("" + row + "", Text_GName.getText().toString());
				GetSelectItem(contact,com,row);
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
	
	public ArrayListContact GetContact()
	{
		ContentResolver cr = getContentResolver();
		Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
		ArrayListContact contact = new ArrayListContact();
		if (cur.getCount() > 0) {
			          while (cur.moveToNext()) {
			        	  StructContact con = new StructContact();
			              String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
			               
			              if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
			                   			
			                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
			                                           ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
			                                           new String[]{id}, null);
			                    while (pCur.moveToNext()) {
			                    	con.Name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			                    	con.NumberPhone = pCur.getString(
			                                 pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			                    	contact.SetListContact(con);
			                    }
			                    pCur.close();
			                }
			          }
	}
	    return contact;
	}
	public void GetSelectItem(ArrayListContact contact,Database_Command com, int ID_Group)
	{
		for(int i = 0; i < contact.GetListContact().size(); i++ )
		{
			if(contact.GetListContact().get(i).GetIsChecked())
			{
				StructContact con = new StructContact();
				con.Name= contact.GetListContact().get(i).GetContact().GetName();
				con.NumberPhone = contact.GetListContact().get(i).GetContact().GetNumberPhone();
				com.Insert_tblContact(ID_Group, con.GetName(),con.GetNumberPhone());
				
			}
		}
		
	}
}


