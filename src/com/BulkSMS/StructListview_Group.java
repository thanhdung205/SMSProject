package com.BulkSMS;

public class StructListview_Group {
	 StructGroup Group;
	 boolean IsChecked;
	public StructGroup GetGroup(){
		return Group;
	}
	public boolean GetIsChecked(){
		return IsChecked;
	}
	public void SetGroup(StructGroup PGroup)
	{
		Group = PGroup;
	}
	public void SetIsChecked(boolean PIsChecked){
		IsChecked = PIsChecked;
	}
}
