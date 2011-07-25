package com.BulkSMS;

public class StructAutoSend {
	int ID;
	String DateTimeSend;
	String Content;
	String Status;
	public  int GetID(){
		return ID;
	}
	public String GetDateTime(){
		return DateTimeSend;
	}
	public String GetContent(){
		return Content;
	}
	public String GetStatus(){
		return Status;
	}
	public void SetStatus(String pStatus){
		Status = pStatus;
	}
	public void SetID(int id)
	{
		ID =id;
	}
	public void SetDateTime(String datetime){
		DateTimeSend = datetime;
	}
	public void SetContent(String content){
		Content = content;
	}
}
