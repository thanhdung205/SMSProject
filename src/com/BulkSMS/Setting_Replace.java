package com.BulkSMS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Setting_Replace extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingreplacecharacter);
		
		LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		LinearLayout btReplace = (LinearLayout) findViewById(R.id.Setting_btReplace);
		final EditText txtReplace = (EditText) findViewById(R.id.Setting_TxtRepalce);
		final Database_Command com = new Database_Command(this);
		final String Rep = com.GetReplace();
		txtReplace.setText(Rep);
		btReplace.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				com.Delete_tblReplace(Rep);
				com.Insert_tblReplace(txtReplace.getText().toString());
				finish();
				
			}});
	    btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				finish();
				
			}});
	}
	

}
