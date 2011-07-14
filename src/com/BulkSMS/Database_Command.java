package com.BulkSMS;

import java.util.ArrayList;

import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;

public class Database_Command {
	Database_Createtable vari;
	public Database_Command(Context con)
	{
		vari = new Database_Createtable(con); 
	}
	public void Insert_tblGroup(String ID,String Name){
		vari.GetDatabase().GetDatabase().execSQL("insert into " + vari.GetTableGroup() + " values('" + ID +"','" + Name +"');");
	}
	public void Insert_tblContact(String ID,String ID_Group,String Name,String Numberphone){
		vari.GetDatabase().GetDatabase().execSQL("insert into " + vari.GetTableContact() + " values('" + ID +"','" + ID_Group + "','" + Name + "','" + Numberphone +"');");
	}
	public void Insert_tblTemplate(String ID,String Content){
		vari.GetDatabase().GetDatabase().execSQL("insert into " + vari.GetTableTemplate() + " values('" + ID +"','" + Content +"');");
	}
	public void Insert_tblAuto(String Name,int  Row){
		vari.GetDatabase().GetDatabase().execSQL("insert into " + vari.TableAuto + " values('" + Name +"','" + Row +"');");
	}
	public void Delete_tblGroup(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetTableGroup(),"ID=?" ,args);
	}
	public void Delete_tblContact(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.TableContact,"ID_Group=?" ,args);
	}
	public void Update_tblAuto(String Name,int Row){
		vari.GetDatabase().GetDatabase().execSQL("update " + vari.GetTableAuto() + " set Row=" + Row + " where TableName='" + Name +"';");
	}
	public Cursor GetEntryGroup()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetTableGroup(), new String[] {"ID", "Name"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryContact()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetTableContact(), new String[] {"ID", "ID_Group","Name","NumberPhone"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryTemplate()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetTableTemplate(), new String[] {"ID", "Content"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryAuto()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetTableAuto(), new String[] {"TableName", "Row"}, 
                null, null, null, null, null);
	}
	public ArrayList<StructGroup> GetListGroup()
	{
		
		Cursor cs = GetEntryGroup();
		ArrayList<StructGroup> list =new ArrayList<StructGroup>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructGroup gr = new StructGroup();
			gr.SetID(cs.getInt(0));
			gr.SetGroupName(cs.getString(1));
			list.add(gr);
			cs.moveToNext();
		}
		
		return list;
	}
	public ArrayList<StructTemplate> GetListContact(String Tan)
	{
		
		Cursor cs = GetEntryContact();
		ArrayList<StructTemplate> list =new ArrayList<StructTemplate>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructTemplate tp = new StructTemplate();
			tp.SetID(cs.getString(0));
			tp.SetContent(cs.getString(1));
			 list.add(tp);
			 cs.moveToNext();
		}
		
		return list;
	}
	public ArrayList<String> GetListTemplate()
	{
		
		Cursor cs = GetEntryTemplate();
		ArrayList<String> list =new ArrayList<String>();
		cs.moveToFirst();
		do{
			 list.add(cs.getString(1));
		
				}while(cs.moveToNext());
		
		return list;
	}
	public int GetListAuto(String TableName)
	{
		Cursor cs = GetEntryAuto();
		int count = 0;
		if(cs.getCount() == 0)
		{
			Insert_tblAuto(vari.GetTableGroup(),0);
		}
		cs.moveToFirst();
		while (cs.isAfterLast() == false){
			 
			if(cs.getString(0).contains(TableName)){

					 
				 count = cs.getInt(1);
				 
				 count++;
				 ContentValues args = new ContentValues();
				 args.put("Row", count);
				 vari.GetDatabase().GetDatabase().update(vari.TableAuto,args, "TableName='" + vari.GetTableGroup() + "'",null);
				 cs.moveToNext();
			 }
		}
		return count;
	}

}
