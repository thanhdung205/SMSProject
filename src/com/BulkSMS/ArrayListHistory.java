package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;

public class ArrayListHistory {
	ArrayList<StructHistory> listhis ;
	Context Con;
	public ArrayListHistory(Context con){
		listhis = new ArrayList<StructHistory>();
		Con = con;
	}
	public void SetListHistory(){
		Database_Command com = new Database_Command(Con);
		listhis = com.GetListHistory();
	}
	public ArrayList<StructHistory> GetListGroup()
	{
		return listhis;
	}
	
	
}
