package com.BulkSMS;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Setting_Replace extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingreplacecharacter);
		final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		final LinearLayout btReplace = (LinearLayout) findViewById(R.id.Setting_btReplace);
		final EditText txtReplace = (EditText) findViewById(R.id.Setting_TxtRepalce);
		final Database_Command com = new Database_Command(this);
		final String Rep = com.GetReplace();
		txtReplace.setText(Rep);
		final Context con =this;
		btReplace.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaion(btReplace);
				if(txtReplace.getText().toString().length() == 0)
				{
					DialogOK dia = new DialogOK(con,"Thong bao","Ban phai nhap vao 1 ki tu tro len");
					dia.ShowMes();   
					return;
				}
						com.Delete_tblReplace(Rep);
						com.Insert_tblReplace(txtReplace.getText().toString());
				
				finish();
			}});
	    btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();
				
			}});
	}
	

}
