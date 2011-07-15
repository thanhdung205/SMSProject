package com.BulkSMS;

public class StructContact_Group {
	StructContact Contact;
	int ID_Group;
	public void SetConcact(StructContact con){
		Contact = con;
	}
	public void SetIDGroup(int ID){
		ID_Group = ID;
	}
	public StructContact GetConcact(){
		return Contact;
	}
	public int GetIDGroup(){
		return ID_Group;
	}
	

}
