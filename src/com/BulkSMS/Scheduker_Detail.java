package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Scheduker_Detail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historydetail);
		TextView TextContent = (TextView) findViewById(R.id.History_Content);
		ListView ls = (ListView) findViewById(R.id.History_ListContact);
		TextContent.setText(All_Var.Content_AutoSend);
		AdapterListViewContactSub ap = new AdapterListViewContactSub(this,R.layout.customcontactlistviewsub,GetCon(All_Var.ID_AutoSend));
		ls.setAdapter(ap);
		final LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		btExit.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ButtonAnimation.ChangingAnimaionBack(btExit);
				finish();
			}
		 });

	}
	public ArrayList<StructContact> GetCon(int ID)
	{
		ArrayList<StructContact> con =new ArrayList<StructContact>();
		Database_Command com = new Database_Command(this);
		ArrayList<StructAutoSendContact> auto = com.GetListAutoSendContact();
		for(int i = 0 ;i<auto.size();i++ )
		{
			if(auto.get(i).GetIDAuto() == ID){
			StructContact str = new StructContact();
			str.SetName(auto.get(i).GetName());
			str.SetNumberPhone(auto.get(i).GetNumberPhone());
			con.add(str);
			}
		}
		return con;
	}

}
