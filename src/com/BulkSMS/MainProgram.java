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
        Intent intent = new Intent(MainProgram.this, Scheduler_Service.class);
		startService(intent);
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
				else if(listselect.titleItem.contains("Gửi"))
				{
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN4"));
				}
				else if(listselect.titleItem.contains("SMS")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN6"));
				}
				else if(listselect.titleItem.contains("sử")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN8"));
				}
				
				else if(listselect.titleItem.contains("Sắp")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN10"));
				}
				else if(listselect.titleItem.contains("tuyến")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN13"));
				}
				else if(listselect.titleItem.contains("Cấu hình")){
					startActivity(new Intent("com.BulkSMS.CLEARSCREEN16"));
				}
				
				else{}
				
			}});
    }

}