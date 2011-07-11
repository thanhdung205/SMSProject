package com.BulkSMS;

import java.util.ArrayList;

public class ArrayListContact {
	ArrayList<Struct_ListViewContact> list;
	public ArrayListContact(){
		list = new ArrayList<Struct_ListViewContact>();
	}
	public void  SetListContact()
	{
		for(int i = 0 ; i < 10 ; i++)
		{
			StructContact contact  = new StructContact();
			contact.SetName("Name " + i);
			contact.SetNumberPhone("090000000");
			Struct_ListViewContact item = new Struct_ListViewContact();
			item.Contact = contact;
		
			item.SetIsChecked(false);
			list.add(item);
		}
	}
	public ArrayList<Struct_ListViewContact> GetListContact()
	{
		return list;
	}

}
