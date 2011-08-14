package com.BulkSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Instruction extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instruction);
		TextView txtInstr =  (TextView) findViewById(R.id.txtInstruction);
		LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		txtInstr.setText("hahAHa");
		btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}});
	}

}
