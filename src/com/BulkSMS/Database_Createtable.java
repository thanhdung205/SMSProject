package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteException;
public class Database_Createtable {
	String TableGroup="tbl_Group1";
	String TableContact ="tbl_Contact1";
	String TableTemplate="tbl_Template1";
	String TableAuto="tbl_Auto1";
	String TableHistory="tbl_History1";
	Database data;
	public Database_Createtable(Context con){
		data = new Database(con);
		
			data.CreateDatabase();
			try{
			CreateTable_tblAutoIncrease();
			CreateTable_tblGroup();
			CreateTable_tbl_Contact();
			CreateTable_tbl_Template();
			}
			catch(SQLiteException e)
			{
				
			}
		
	}
	public Database GetDatabase()
	{
		return data;
	}
	public String GetHistory(){
		return TableHistory;
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
		data.GetDatabase().execSQL("create table " + TableGroup + " ( ID integer primary key, Name text);");
	}
	public void CreateTable_tbl_Contact()
	{
		data.GetDatabase().execSQL("create table " + TableContact + " ( ID integer primary key AUTOINCREMENT,ID_Group integer REFERENCES tbl_Group(ID) , Name text, NumberPhone text);");
	}
	public void CreateTable_tbl_Template()
	{
		data.GetDatabase().execSQL("create table " + TableTemplate + " ( ID integer primary key, Content text);");
	}
	public void CreateTable_tblAutoIncrease()
	{
		
		data.GetDatabase().execSQL("create table " + TableAuto + " ( TableName text, Row integer);");
		
	}
	public void CreateTable_tblHistory()
	{		
		data.GetDatabase().execSQL("create table " + TableHistory + " ( ID integer primary key,ID_Contact text,DateTime text,Content text, Name text);");
	}
}
