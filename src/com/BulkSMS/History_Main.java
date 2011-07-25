package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class History_Main extends Activity{
	ArrayListHistory list = new ArrayListHistory(this);
	ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historymain);
	//	
		
		
		listview = (ListView) findViewById(R.id.History_List);
		BindingListView();
		registerForContextMenu(listview);

		listview.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				StructHistory his = list.GetListGroup().get(arg2);
				All_Var.ID_History = his.GetID();
				All_Var.Content_History=his.GetContent();
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN9"));
			}
		  });
		  LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
			 btExit.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					finish();
				}
			 });
	}
	public void BindingListView(){
		AdapterListViewHistory  ap = new AdapterListViewHistory(this,R.layout.customhistorylistview,GetHistory());
		listview.setAdapter(ap);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	    ContextMenuInfo menuInfo) {
	  if (v.getId()==R.id.History_List) {
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
	  int IDHis = list.GetListGroup().get(info.position).GetID();
	  switch(menuItemIndex){
	  	case 0 : 	com.Delete_tblHistoryContact(IDHis);
					com.Delete_tblHistory(IDHis);
					BindingListView();
	  				break;
	  	case 1 : 	com.DeleteAll_History();
	  				BindingListView();
	  				break;
	  }
	  return true;
	}
	public ArrayList<StructHistory> GetHistory(){
		list.SetListHistory();
		ArrayList<StructHistory> listhis = new ArrayList<StructHistory>();
		ArrayList<StructHistory> listh =list.GetListGroup();
		for(int i = 0 ; i < listh.size(); i++ ){
			StructHistory his = new StructHistory();
			his.SetID(listh.get(i).GetID());
			his.SetContent(listh.get(i).GetContent());
			if(list.GetListGroup().get(i).GetContent().length() <= 15)
			{
				his.SetContent(listh.get(i).GetContent());
			}
			else{
				his.SetContent(listh.get(i).GetContent().substring(0, 15) + "...");
			}
			his.SetDateTime(listh.get(i).GetDateTime());
			listhis.add(his);
		}
		return listhis;
	}
	

}
