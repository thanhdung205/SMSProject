package com.BulkSMS;

public class StructAutoSendContact {
	int ID;
	int ID_Auto;
	String Name;
	String NumberPhone;
	public int GetID(){
		return ID;
	}
	public int GetIDAuto()
	{
		return ID_Auto;
	}
	public String GetName(){
		return Name;
	}
	public String GetNumberPhone(){
		return NumberPhone;
	}
	public void SetID(int id){
		ID = id;
	}
	public void SetIDAuto(int id)
	{
		ID_Auto = id;
	}
	public void SetName(String name)
	{
		Name =name;
	}
	public void SetNumberPhone(String Number)
	{
		NumberPhone = Number;
	}

}
