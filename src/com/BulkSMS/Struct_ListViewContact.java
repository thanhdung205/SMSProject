package com.BulkSMS;

public class Struct_ListViewContact {
	 StructContact Contact;
	 boolean IsChecked;
	public StructContact GetContact(){
		return Contact;
	}
	public boolean GetIsChecked(){
		return IsChecked;
	}
	public void SetContact(StructContact PContact)
	{
		Contact = PContact;
	}
	public void SetIsChecked(boolean PIsChecked){
		IsChecked = PIsChecked;
	}
}
