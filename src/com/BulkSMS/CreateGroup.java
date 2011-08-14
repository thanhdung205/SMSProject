package com.BulkSMS;



import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import android.widget.LinearLayout;

public class CreateGroup extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creategroup);
		final LinearLayout bt = (LinearLayout) findViewById(R.id.bt_CreateGroup1);
		final EditText Text_GName =  (EditText) findViewById(R.id.text_GroupName);
		final Context con = this;
		 bt.setOnClickListener(new OnClickListener(){
			 
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(bt);
				if(Text_GName.length() == 0){
					DialogOK dia = new DialogOK(con,"Thông báo","Ban chua nhap ten nhom");
					dia.ShowMes();
					return;
				}
				
						Database_Command com = new Database_Command(All_Var.Con);
						int row = com.AutoIncreasing(com.GetDatabaseCreate().GetTableGroup());
						com.Insert_tblGroup("" + row + "", Text_GName.getText().toString());
				
				finish();
			}
		 });
	     final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();				
			} 
		 });
}	
}