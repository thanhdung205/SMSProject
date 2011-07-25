package com.BulkSMS;

import com.BulkSMS.R;
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

public class MainGroup extends Activity {
	ArrayListGroup listgroup = new ArrayListGroup(this);
	ListView ls;
	@Override
	protected void onResume() {
		super.onResume();
		ls = (ListView) findViewById(R.id.Grouplist);
		 Binding(ls);
	}
	public void Binding(ListView ls){	
		 listgroup.SetListGroup();
		 AdapterListViewGroupMain adapter = new AdapterListViewGroupMain(this,R.layout.customgroupmainlistview,listgroup.GetListGroup());
		 ls.setAdapter(adapter);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.maingroup);	 
		 ls = (ListView) findViewById(R.id.Grouplist);
		 Binding(ls);
		 registerForContextMenu(ls);
		 LinearLayout bt = (LinearLayout) findViewById(R.id.bt_Creategroup);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}
		 });
		 bt.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN2"));
			}
		 });
		 ls.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				All_Var.Group_ID = listgroup.GetListGroup().get(arg2).GetID();
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN3"));
			}});
		 }
	@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
		    ContextMenuInfo menuInfo) {
		  if (v.getId()==R.id.Grouplist) {
		    menu.setHeaderTitle("Lựa chọn");
		    String[] menuItems = {"Xóa nhóm"};
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
		  int IDGroup = listgroup.GetListGroup().get(info.position).GetID();
		  switch(menuItemIndex){
		  	case 0 : 	com.Delete_tblContact(IDGroup);
		  				com.Delete_tblGroup(IDGroup);
						Binding(ls);
		  				break;
		  }
		  return true;
		}

}
