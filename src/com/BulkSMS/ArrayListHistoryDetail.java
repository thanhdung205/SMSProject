package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;

public class ArrayListHistoryDetail {
	ArrayList<StructHistoryContact> list = new ArrayList<StructHistoryContact>();
	Context Con;
	public ArrayListHistoryDetail(Context con){
		Con = con;
	}
	public void SetList()
	{
		Database_Command com = new Database_Command(Con);
		list = com.GetListHistoryContact();
	}
	public ArrayList<StructHistoryContact> GetList()
	{
		return list;
	}
	public ArrayList<StructContact> GetListFromID(int ID_History)
	{
		 SetList();
		ArrayList<StructContact> listhis = new ArrayList<StructContact>(); 
		for(int i = 0 ; i < list.size(); i++){
			
			if(list.get(i).GetIDHistory() == ID_History){
				StructContact con = new StructContact();
				con.SetName(list.get(i).GetName());
				con.SetNumberPhone(list.get(i).GetNumberPhone());
				listhis.add(con);
			}
		}
		return listhis;
	}
	
}
