package com.BulkSMS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Setting_Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingmenu);
		ArrayListMenuSetting array = new ArrayListMenuSetting();
        
        MenuItemAdapter ap = new MenuItemAdapter(this,R.layout.mainlist,array.GetMenuSetting());
	    ListView list = (ListView) findViewById(R.id.menusettinglist);
	    list.setAdapter(ap);
		final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		
	    list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				MenuItemList menu =(MenuItemList) arg0.getItemAtPosition(arg2);
				if(menu.titleItem.contains("thay thế")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN17"));
				}
				
			}});
	    btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();
				
			}});

	}
	

}

