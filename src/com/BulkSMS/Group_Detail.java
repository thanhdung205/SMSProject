package com.BulkSMS;

import java.util.ArrayList;

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
		 
		 final ArrayListContact array = GetContact(com,All_Var.Group_ID);
	     AdapterListviewContact ap = new AdapterListviewContact(this,R.layout.customcontactlistview,array.GetListContact());
	     ls.setAdapter(ap);
		 LinearLayout btDelete = (LinearLayout) findViewById(R.id.Group_Deletegroup);
	     LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
	     LinearLayout btSaveChange = (LinearLayout) findViewById(R.id.Group_SaveChange);
	     btDelete.setOnClickListener(new OnClickListener(){
	    	 public void onClick(View arg0) {
				com.Delete_tblContact(All_Var.Group_ID);
				com.Delete_tblGroup(All_Var.Group_ID);
				finish();
			}});
	     btSaveChange.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				com.Delete_tblContact(All_Var.Group_ID);
				AddContact(com,All_Var.Group_ID,array);
				finish();
				
			}});
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}
		 });
		
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
