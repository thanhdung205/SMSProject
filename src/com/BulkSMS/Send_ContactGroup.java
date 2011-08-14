package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Send_ContactGroup extends Activity {
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		SetContactCheckedNull thread = new SetContactCheckedNull();
		thread.start();
	}
	int flag = 0 ;
	ArrayList<StructListview_Group> listgroup;
	AdapterListviewContact ap=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smscontactgroup);
		
		final LinearLayout btContact = (LinearLayout) findViewById(R.id.Send_tabContact);
		final LinearLayout btGroup = (LinearLayout) findViewById(R.id.Send_tabC);		
		final LinearLayout btOK = (LinearLayout) findViewById(R.id.Send_btOK);
		final EditText txtFind = (EditText) findViewById(R.id.Contact_txtFind);

		final ListView list = (ListView) findViewById(R.id.Send_GroupContact);
		
		try{
		listgroup = GetStructListGroup();
		ap = new AdapterListviewContact(this,R.layout.customcontactlistview,All_Var.listcontact.GetListContact());
		list.setAdapter(ap);
		}catch(Exception e){
			
		}
		final Context con =this;
		txtFind.addTextChangedListener(new TextWatcher(){

			public void afterTextChanged(Editable arg0) {
				
			}
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				
			}
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				if(txtFind.getText().toString() == null)
				{
					
					list.setAdapter(ap);
				}
				else
				{
					final AdapterListviewContact ap2 = new AdapterListviewContact(con,R.layout.customcontactlistview, FindContact(txtFind.getText().toString()));
					list.setAdapter(ap2);
				}
			}
		});
	    final AdapterListviewGroup ap1 = new AdapterListviewGroup(this,R.layout.customgrouplistview,listgroup);
		btContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btContact);
				list.setAdapter(ap);
				txtFind.setVisibility(View.VISIBLE);
			    flag = 0;
			}
			
		});
		btOK.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btOK);
				All_Var.listnumber = new ArrayList<StructContact>();
				GetNumber();
				finish();
		}});
		btGroup.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btGroup);
				list.setAdapter(ap1);
				txtFind.setVisibility(View.GONE);
				flag = 1;
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
			for(int i = 0 ; i < All_Var.listcontact.GetListContact().size(); i++){
				if(All_Var.listcontact.GetListContact().get(i).GetIsChecked())
				{
					StructContact con = new StructContact();
					con.SetName(All_Var.listcontact.GetListContact().get(i).GetContact().GetName());
					con.SetNumberPhone(All_Var.listcontact.GetListContact().get(i).GetContact().GetNumberPhone());
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
	public ArrayList<Struct_ListViewContact> FindContact(String Name)
	{
		ArrayList<Struct_ListViewContact> contact = new ArrayList<Struct_ListViewContact>();
		for(int i=0; i < All_Var.listcontact.GetListContact().size();i++)
		{
			if(All_Var.listcontact.GetListContact().get(i).GetContact().GetName().toUpperCase().contains(Name.toUpperCase())){
				contact.add(All_Var.listcontact.GetListContact().get(i));
			}
		}
		return contact;
	}

}
