package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;


public class MainProgram extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayListMenu array = new ArrayListMenu();
        array.GetMenu();
        MenuItemAdapter ap = new MenuItemAdapter(this,R.layout.mainlist,array.arraylist);
        ListView list = (ListView) findViewById(R.id.menulist);
        list.setAdapter(ap);
        
        list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				MenuItemList listselect= (MenuItemList) arg0.getItemAtPosition(arg2);
				if(listselect.titleItem.contains("Nhóm")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN1"));

				}
				else if(listselect.titleItem.contains("Thoát")){
					System.exit(0);
				}
				
				
			}});
    }
}