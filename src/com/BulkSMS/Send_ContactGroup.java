package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Send_ContactGroup extends Activity {
	int flag = 0 ;
	ArrayList<StructListview_Group> listgroup;
	ArrayList<Struct_ListViewContact> listcontact;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smscontactgroup);
		
		LinearLayout btContact = (LinearLayout) findViewById(R.id.Send_tabContact);
		LinearLayout btGroup = (LinearLayout) findViewById(R.id.Send_tabC);
		LinearLayout btCancel = (LinearLayout) findViewById(R.id.Send_btCancel);
		LinearLayout btOK = (LinearLayout) findViewById(R.id.Send_btOK);
		
		final ListView list = (ListView) findViewById(R.id.Send_GroupContact);
		
		listcontact = GetContact().GetListContact();
		listgroup = GetStructListGroup();
		final AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview, listcontact);
		list.setAdapter(ap);
		
		
	    final AdapterListviewGroup ap1 = new AdapterListviewGroup(this,R.layout.customgrouplistview,listgroup);
		btContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				list.setAdapter(ap);
			    flag = 0;
			}
			
		});
		btOK.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				All_Var.listnumber = new ArrayList<StructContact>();
				GetNumber();
				finish();
		}});
		btGroup.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				list.setAdapter(ap1);
				flag = 1;
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
	public void GetNumber()
	{
		if(flag == 0)
		{
			for(int i = 0 ; i < listcontact.size(); i++){
				if(listcontact.get(i).GetIsChecked())
				{
					StructContact con = new StructContact();
					con.SetName(listcontact.get(i).GetContact().GetName());
					con.SetNumberPhone(listcontact.get(i).GetContact().GetNumberPhone());
					All_Var.listnumber.add(con);
				}
			}
		}
		else
		{
			for(int i = 0 ; i < listgroup.size(); i++){
				if(listgroup.get(i).GetIsChecked()){
					Database_Command com = new Database_Command(this);
					GetContactNumber(com,listgroup.get(i).GetGroup().GetID());
				}
			}
		}
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
	public ArrayList<StructListview_Group> GetStructListGroup()
	{
		ArrayList<StructListview_Group> structlistgroup = new ArrayList<StructListview_Group>();
		ArrayListGroup list = new ArrayListGroup(this);
		list.SetListGroup();
		for(int i = 0 ; i < list.GetListGroup().size();i++)
		{
			StructListview_Group slist = new StructListview_Group();
			slist.SetGroup(list.GetListGroup().get(i));
			slist.SetIsChecked(false);
			structlistgroup.add(slist);
		}
		return structlistgroup;
	}
	public void GetContactNumber(Database_Command com,int ID_Group)
	{
		ArrayList<StructContact_Group> cg = com.GetListContact();
		for(int i = 0 ; i < cg.size(); i++){
			if(cg.get(i).ID_Group == ID_Group){
				StructContact con = new StructContact();
				con.SetName(cg.get(i).GetConcact().GetName());
				con.SetNumberPhone(cg.get(i).GetConcact().GetNumberPhone());
				 All_Var.listnumber.add(con);
			}
		}
	}

}
