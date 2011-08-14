package com.BulkSMS;


import java.util.ArrayList;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.LinearLayout;
import android.widget.ListView;

public class Scheduler extends Activity{
	Database_Command com;
	ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedulermain);
		list = (ListView) findViewById(R.id.Scheduler_ListSMSAuto);
		com = new Database_Command(this);
		registerForContextMenu(list);
		list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				StructAutoSend auto = (StructAutoSend) arg0.getItemAtPosition(arg2);
				All_Var.ID_AutoSend = auto.GetID();
				All_Var.Content_AutoSend = auto.GetContent();
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN18"));
			}});
		final LinearLayout btAdd = (LinearLayout) findViewById(R.id.Scheduler_btAddMain);
				btAdd.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btAdd);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN11"));
			}});
		 final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
			
				finish();
			}
			 
		 });
	}
	public void BindingListView()
	{
		AdapterListViewAuto adapter = new AdapterListViewAuto(this,R.layout.customautosendlistview,com.GetListAutoSend());
		list.setAdapter(adapter);
	}
	public void onCreateContextMenu(ContextMenu menu, View v,
		    ContextMenuInfo menuInfo) {
		  if (v.getId()==R.id.Scheduler_ListSMSAuto) {
		    menu.setHeaderTitle("Lựa chọn");
		    String[] menuItems = {"Xóa","Xóa toàn bộ"};
		    for (int i = 0; i<menuItems.length; i++) {
		      menu.add(Menu.NONE, i, i, menuItems[i]);
		    }
		  }
		}
		@Override
		public boolean onContextItemSelected(MenuItem item) {
			Database_Command com = new Database_Command(this);
		  AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		  int menuItemIndex = item.getItemId();
		  int IDAuto = com.GetListAutoSend().get(info.position).GetID();
		  switch(menuItemIndex){
		  	case 0 : 	com.Delete_tblAutoSendContact(IDAuto);
						com.Delete_tblAutoSend(IDAuto);
						BindingListView();
		  				break;
		  	case 1 : 	com.DeleteAll_AutoSend();
		  				BindingListView();
		  				break;
		  }
		  return true;
		}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ListView list = (ListView) findViewById(R.id.Scheduler_ListSMSAuto);
		Database_Command com = new Database_Command(this);
		AdapterListViewAuto adapter = new AdapterListViewAuto(this,R.layout.customautosendlistview,com.GetListAutoSend());
		list.setAdapter(adapter);
	}

	public ArrayList<StructAutoSend> GetStructAutoSend(){
		ArrayList<StructAutoSend> list = new ArrayList<StructAutoSend>();
		return list;
	}
	
}
