package com.BulkSMS;

public class StructHistory {
	int ID;
	String DateTime;
	String Content;
	String Status;
	public int GetID()
	{
		return ID;
	}
	public String GetDateTime(){
		return DateTime;
	}

	public String GetStatus(){
		return Status;
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
	public void SetStatus(String status)
	{
		Status = status;
	}
	public void SetContent(String content)
	{
		Content = content;
	}
}
