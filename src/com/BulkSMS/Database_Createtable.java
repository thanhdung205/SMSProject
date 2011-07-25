package com.BulkSMS;



import android.content.Context;

public class Database_Createtable {
	String TableGroup="tbl_Group";
	String TableContact ="tbl_Contact";
	String TableTemplate="tbl_Template";
	String TableAuto="tbl_Auto";
	String TableSaveID = "tbl_SaveID";
	String TableHistory="tbl_History";
	String TableHistory_Contact="tbl_History_Contact";
	String TableAutoSend="tbl_AutoSend";
	String TableAutoSend_Contact="tbl_AutoSend_Contact";
	String TableReplace="tbl_Replace";
	Database data;
	public Database_Createtable(Context con){
		data = new Database(con);
		data.CreateDatabase();
		CreateTable_tblSaveID();
		CreateTable_tblReplace();
		CreateTable_tbl_History();
		CreateTable_tblHistory_Contact();
		CreateTable_tblAutoSend();
		CreateTable_tblAutoSend_Contact();
		CreateTable_tblAutoIncrease();
		CreateTable_tblGroup();
		CreateTable_tbl_Contact();
		CreateTable_tbl_Template();
		
	}
	public Database GetDatabase()
	{
		return data;
	}
	public String GetTableReplace(){
		return TableReplace;
	}
	public String GetTableSaveID(){
		return TableSaveID;
	}
	public String GetHistory(){
		return TableHistory;
	}

	public String GetHistory_Contact(){
		return TableHistory_Contact;
	}
	public String GetAutoSend(){
		return TableAutoSend;
	}
	public String GetAutoSend_Contact(){
		return TableAutoSend_Contact;
	}
	public String GetTableGroup()
	{
		return TableGroup;
	}
	public String GetTableAuto()
	{
		return TableAuto;
	}
	public String GetTableContact()
	{
		return TableContact;
	}
	public String GetTableTemplate()
	{
		return TableTemplate;
	}
	public void CreateTable_tblGroup()
	{		
		data.GetDatabase().execSQL("create table if not exists " + TableGroup + " ( ID integer primary key, Name text);");
	}
	public void CreateTable_tbl_Contact()
	{
		data.GetDatabase().execSQL("create table if not exists " + TableContact + " ( ID integer primary key AUTOINCREMENT,ID_Group integer references tbl_Group(ID), Name text, NumberPhone text);");
	}
	public void CreateTable_tbl_Template()
	{
		data.GetDatabase().execSQL("create table if not exists " + TableTemplate + " ( ID integer primary key, Content text);");
	}
	public void CreateTable_tblAutoIncrease()
	{
		data.GetDatabase().execSQL("create table if not exists " + TableAuto + " ( TableName text, Row integer);");
	}
	public void CreateTable_tbl_History()
	{
		data.GetDatabase().execSQL("create table if not exists " + TableHistory + " ( ID integer primary key AUTOINCREMENT,DateTime text, Content Text);");
	}
	public void CreateTable_tblHistory_Contact()
	{		
		data.GetDatabase().execSQL("create table if not exists " + TableHistory_Contact + " ( ID integer primary key AUTOINCREMENT,ID_History integer references tbl_History(ID),Name text,NumberPhone text);");
	}
	public void CreateTable_tblReplace()
	{		
		data.GetDatabase().execSQL("create table if not exists " + TableReplace + " ( RepChar text);");
	}
	public void CreateTable_tblSaveID()
	{		
		data.GetDatabase().execSQL("create table if not exists " + TableSaveID + " (ID int,Content text);");
	}
	public void CreateTable_tblAutoSend()
	{		
		data.GetDatabase().execSQL("create table if not exists " + TableAutoSend + " ( ID integer primary key AUTOINCREMENT,DatetimeSend text,Content text,Status text);");
	}
	public void CreateTable_tblAutoSend_Contact()
	{		
		data.GetDatabase().execSQL("create table if not exists " + TableAutoSend_Contact + " ( ID integer primary key AUTOINCREMENT,ID_Send integer references tbl_AutoSend(ID),Name text,NumberPhone text);");
	}
}
