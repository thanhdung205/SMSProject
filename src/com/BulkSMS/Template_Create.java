package com.BulkSMS;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Template_Create extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createtemplate);
		
		final Context con = this;
		final LinearLayout btCreate = (LinearLayout) findViewById(R.id.Template_btCreateContent);;
		final EditText txtContent = (EditText) findViewById(R.id.Template_TextContent);
		 final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btCreate.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btCreate);
				if(txtContent.getText().toString().length() == 0){
					DialogOK dia = new DialogOK(con,"Thong bao","Ban chua nhap vao noi dung");
					dia.ShowMes();
					return;
				}
				Thread thread = new Thread(){
					public void run(){
						final Database_Command com = new Database_Command(All_Var.Con);
						int row = com.AutoIncreasing(com.GetDatabaseCreate().GetTableTemplate());
						com.Insert_tblTemplate(row, txtContent.getText().toString());
					}
				};
				thread.start();
				
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();
			}
		 });
		
	}
	

}
