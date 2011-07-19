package com.BulkSMS;

public class StructHistoryContact {
	int ID;
	int ID_History;
	String Name;
	String NumberPhone;
	public int GetID(){
		return ID;
	}
	public int GetIDHistory()
	{
		return ID_History;
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
	public void SetIDHistory(int id)
	{
		ID_History = id;
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
