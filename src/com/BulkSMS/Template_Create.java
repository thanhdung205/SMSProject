package com.BulkSMS;

import android.app.Activity;
import android.content.Intent;
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
		final Database_Command com = new Database_Command(this);
		//LinearLayout btCancel = (LinearLayout) findViewById(R.id.Template_btCancel);
		LinearLayout btCreate = (LinearLayout) findViewById(R.id.Template_btCreateContent);;
		final EditText txtContent = (EditText) findViewById(R.id.Template_TextContent);
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btCreate.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				int row = com.AutoIncreasing(com.GetDatabaseCreate().GetTableTemplate());
				com.Insert_tblTemplate(row, txtContent.getText().toString());
				finish();
			}});
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				finish();
			}
		 });
		
	}
	

}
