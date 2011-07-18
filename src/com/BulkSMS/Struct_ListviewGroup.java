package com.BulkSMS;

import com.BulkSMS.StructGroup;


public class Struct_ListviewGroup {
	 StructGroup Group;
	 boolean IsChecked;
	public StructGroup GetGroup(){
		return Group;
	}
	public boolean GetIsChecked(){
		return IsChecked;
	}
	public void SetGroup(StructGroup PContact)
	{
		Group = PContact;
	}
	public void SetIsChecked(boolean PIsChecked){
		IsChecked = PIsChecked;
	}
}
