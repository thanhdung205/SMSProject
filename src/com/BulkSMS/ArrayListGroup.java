package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;

public class ArrayListGroup {
	ArrayList<StructGroup> listgroup;
	Context con;
	public ArrayListGroup(Context co)
	{
		listgroup = new ArrayList<StructGroup>();
		con = co;
	}
	public void SetListGroup()
	{
		Database_Command data = new Database_Command(con);
		listgroup = data.GetListGroup();
	}
	public ArrayList<StructGroup> GetListGroup()
	{
		return listgroup;
	}
	
	public ArrayList<String> GetListGroupName(){
		ArrayList<String> listname = new ArrayList<String>();
		for(int i = 0;i<listgroup.size();i++)
		{
			listname.add(listgroup.get(i).GroupName);
		}
		return listname;
	}
	
}
