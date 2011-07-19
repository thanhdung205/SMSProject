package com.BulkSMS;

public class StructHistory {
	int ID;
	String DateTime;
	String Content;
	public int GetID()
	{
		return ID;
	}
	public String GetDateTime(){
		return DateTime;
	}
	public String GetContent(){
		return Content;
	}
	public void SetID(int Id)
	{
		ID = Id;
	}
	public void SetDateTime(String datetime)
	{
		DateTime = datetime;
	}
	public void SetContent(String content)
	{
		Content = content;
	}
}
