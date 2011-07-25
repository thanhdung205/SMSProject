package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Group_Detail extends Activity {
	ArrayList<StructContact> listcontact = new ArrayList<StructContact>();
	ArrayListContact array;
	ListView ls;
	 Database_Command com;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.groupdetail);
		com = new Database_Command(this);
		ls = (ListView) findViewById(R.id.Group_ListDetail);
	
		BindingListView(com);
		LinearLayout btAddContact = (LinearLayout) findViewById(R.id.Group_AddContact);
	    LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				SaveChange(com);
				finish();
			}
		 });
		 btAddContact.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN5"));
			}
		 });
		
	}
	public void BindingListView(Database_Command com){
		array = GetContact(com,All_Var.Group_ID);
	     AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListContact());
	     ls.setAdapter(ap);
	     
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		SaveChange(com);
	}
	@Override
	protected void onResume() {
		super.onResume();
		Database_Command com = new Database_Command(this);
		if(All_Var.listnumber !=null)
		{
			for(int i = 0 ; i < All_Var.listnumber.size();i++){
				if(!Checking(All_Var.listnumber.get(i).GetNumberPhone())){
					com.Insert_tblContact(All_Var.Group_ID, All_Var.listnumber.get(i).GetName(), All_Var.listnumber.get(i).GetNumberPhone());
				}
			}
	
			All_Var.listnumber =null;
		}
		BindingListView(com);
	}
	public boolean Checking(String NumberPhone)
	{
		for(int i =0;i<array.GetListContact().size();i++){
			if(array.GetListContact().get(i).GetContact().GetNumberPhone().contains(NumberPhone)){
				return true;
			}
		}
		return false;
	}
	public void SaveChange(Database_Command com){
		for(int i = 0 ; i < array.GetListContact().size();i++){
			if(!array.GetListContact().get(i).GetIsChecked()){
				com.Delete_tblContact(array.GetListContact().get(i).GetContact().GetNumberPhone());
			}
		}
		
	}
	public ArrayListContact GetContact(Database_Command com,int ID_Group)
	{
		ArrayList<StructContact_Group> cg = com.GetListContact();
		ArrayListContact listcontact = new ArrayListContact();
		StructContact con;
		for(int i = 0 ; i < cg.size(); i++){
			if(cg.get(i).ID_Group == ID_Group){
				 con = cg.get(i).GetConcact();
				 listcontact.SetListContact1(con, true);
			}
		}
		return listcontact;
		
	}
	public void AddContact(Database_Command com,int ID_Group,ArrayListContact con){
		for (int i = 0 ; i < con.GetListContact().size();i++)
		{
			if(con.GetListContact().get(i).GetIsChecked())
			{
				com.Insert_tblContact(ID_Group, 
						con.GetListContact().get(i).GetContact().GetName(),
						con.GetListContact().get(i).GetContact().GetNumberPhone());
			}
			
		}
	}
}
