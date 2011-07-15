package com.BulkSMS;

import java.util.ArrayList;

public class ArrayListContact {
	ArrayList<Struct_ListViewContact> list;
	
	public ArrayListContact(){
		list = new ArrayList<Struct_ListViewContact>();
	}
	public void  SetListContact(StructContact contact)
	{
			Struct_ListViewContact item = new Struct_ListViewContact();
			item.Contact = contact;
			item.SetIsChecked(false);
			list.add(item);
	}
	public void  SetListContact1(StructContact contact,boolean ischeck)
	{
			Struct_ListViewContact item = new Struct_ListViewContact();
			item.Contact = contact;
			item.SetIsChecked(ischeck);
			list.add(item);
	}
	public ArrayList<Struct_ListViewContact> GetListContact()
	{
		return list;
	}
	

}
