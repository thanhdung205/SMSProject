package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;


public class Template_Main extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintemplate);
		
		LinearLayout btCreate = (LinearLayout) findViewById(R.id.Template_btCreate);
		final Database_Command db = new Database_Command(this);
		 ListView ls = (ListView) findViewById(R.id.Template_ListTemplate);
		 Binding(ls,db);
		 ls.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				All_Var.Text_Content =  GetAllTemplate(db).get(arg2);
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN15"));
				
			}});
		 btCreate.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				startActivity(new Intent("com.BulkSMS.CLEARSCREEN7"));
			}	 
		 });
		 LinearLayout btExit = (LinearLayout) findViewById(R.id.btExit);
		 btExit.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				finish();
			} 
		 });
	}
	@Override
	protected void onResume() {
		
		super.onResume();
		Database_Command db = new Database_Command(this);
		ListView ls = (ListView) findViewById(R.id.Template_ListTemplate);
		Binding(ls,db);
	}
	public ArrayList<String> GetAllTemplate(Database_Command com){
		ArrayList<StructTemplate> tem = com.GetListTemplate();
		ArrayList<String> str= new ArrayList<String> ();
		for (int i = 0;i < tem.size(); i++)
		{
				str.add(tem.get(i).GetContent());
		}
		return str;
		}
	public ArrayList<String> GetTemplate(Database_Command com){
		ArrayList<StructTemplate> tem = com.GetListTemplate();
		ArrayList<String> str= new ArrayList<String> ();
		for (int i = 0;i < tem.size(); i++)
		{
			if(tem.get(i).GetContent().length() <= 15)
			{
				str.add(tem.get(i).GetContent());
			}
			else
			{
			str.add(tem.get(i).GetContent().substring(0,15) + "...");
			}
		}
		return str;
		
	}
	public void Binding(ListView ls,Database_Command db)
	{
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,GetTemplate(db));
		 ls.setAdapter(adapter);
	}

}
