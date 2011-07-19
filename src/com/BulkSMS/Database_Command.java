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
	public Database_Createtable GetDatabaseCreate(){
		return vari;
	}
	public void Insert_tblContact(int ID_Group,String Name,String Numberphone){
		 ContentValues args = new ContentValues();
		 args.put("ID_Group", ID_Group);
		 args.put("Name", Name);
		 args.put("NumberPhone", Numberphone);
		vari.GetDatabase().GetDatabase().insert(vari.GetTableContact(),null, args);
	}
	public void Insert_tblTemplate(int ID,String Content){
		 ContentValues args = new ContentValues();
		 args.put("ID", ID);
		 args.put("Content", Content);
		vari.GetDatabase().GetDatabase().insert(vari.GetTableTemplate(), null, args);
	}
	public void Insert_tblReplace(String Str){
		 ContentValues args = new ContentValues();
		 args.put("RepChar", Str);
		 vari.GetDatabase().GetDatabase().insert(vari.GetTableReplace(), null, args);
	}
	public void Insert_tblAuto(String Name,int  Row){
		vari.GetDatabase().GetDatabase().execSQL("insert into " + vari.TableAuto + " values('" + Name +"','" + Row +"');");
	}
	public void Insert_tblAutoSend(String DateTime,String Content){
		ContentValues args = new ContentValues();
	
		args.put("DatetimeSend", DateTime);
		args.put("Content", Content);
		vari.GetDatabase().GetDatabase().insert(vari.GetAutoSend(), null, args);
	}
	public void Insert_tblAutoSend_Contact(int IDAuto,String Name,String NumberPhone){
		ContentValues args = new ContentValues();
		 args.put("ID_AutoSend", IDAuto);
		 args.put("Name", Name);
		 args.put("NumberPhone", NumberPhone);
		vari.GetDatabase().GetDatabase().insert(vari.GetAutoSend_Contact(), null, args);
	}
	public void Insert_tblHistory(String DateTime,String Content){
		ContentValues args = new ContentValues();
		//args.put("ID", 2);
		args.put("DateTime", DateTime);
		args.put("Content", Content);
		vari.GetDatabase().GetDatabase().insert(vari.GetHistory(), null, args);
	}
	public void Insert_tblHistory_Contact(int IDAuto,String Name,String NumberPhone){
		ContentValues args = new ContentValues();
		 args.put("ID_History", IDAuto);
		 args.put("Name", Name);
		 args.put("NumberPhone", NumberPhone);
		vari.GetDatabase().GetDatabase().insert(vari.GetHistory_Contact(), null, args);
	}

	public void Delete_tblGroup(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetTableGroup(),"ID=?" ,args);
	}
	public void Delete_tblContact(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.TableContact,"ID_Group=?" ,args);
	}
	public void Delete_tblReplace(String Str){
		String[] args = {"" + Str + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetTableReplace(),"RepChar=?" ,args);
	}
	public void Update_tblAuto(String Name,int Row){
		ContentValues args = new ContentValues();
		 args.put("TableName", Name);
		 args.put("Row", Row);
		vari.GetDatabase().GetDatabase().insert(vari.TableAuto,null ,args);
	}
	public void Update_tblReplace(String Str){
		ContentValues args = new ContentValues();
		 args.put("RepChar", Str);
		 String[] args1 = {"" + Str + ""};
		 vari.GetDatabase().GetDatabase().update(vari.GetTableReplace(), args, "RepChar=?",args1);
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
	public Cursor GetEntryHistory()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetHistory(), new String[] {"ID", "DateTime","Content"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryHistoryContact()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetHistory_Contact(), new String[] {"ID", "ID_History","Name","NumberPhone"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryReplace()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetTableReplace(), new String[] {"RepChar"}, 
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
	public ArrayList<StructTemplate> GetListTemplate()
	{
		
		Cursor cs = GetEntryTemplate();
		
		ArrayList<StructTemplate> list =new ArrayList<StructTemplate>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			 StructTemplate tem = new StructTemplate();
			 tem.SetID(cs.getInt(0));
			 tem.SetContent(cs.getString(1));
			 list.add(tem);
			 cs.moveToNext();
		}
		return list;
	}
	public ArrayList<StructContact_Group> GetListContact()
	{
		
		Cursor cs = GetEntryContact();
		ArrayList<StructContact_Group> list =new ArrayList<StructContact_Group>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructContact_Group tp = new StructContact_Group();
			StructContact con = new StructContact();
			
			tp.SetIDGroup(Integer.parseInt(cs.getString(1)));
			con.SetName(cs.getString(2));
			con.SetNumberPhone(cs.getString(3));
			tp.SetConcact(con); 
			list.add(tp);
			 cs.moveToNext();
		}
		
		return list;
	}
	public ArrayList<StructHistory> GetListHistory()
	{
		
		Cursor cs = GetEntryHistory();
		ArrayList<StructHistory> list =new ArrayList<StructHistory>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructHistory tp = new StructHistory();
			tp.SetID(cs.getInt(0));
			tp.SetDateTime(cs.getString(1));
			tp.SetContent(cs.getString(2));
			
			list.add(tp);
			cs.moveToNext();
		}
		
		return list;
	}
	
	
	public ArrayList<StructHistoryContact> GetListHistoryContact()
	{
		
		Cursor cs = GetEntryHistoryContact();
		ArrayList<StructHistoryContact> list =new ArrayList<StructHistoryContact>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructHistoryContact tp = new StructHistoryContact();
			tp.SetID(Integer.parseInt(cs.getString(0)));
			tp.SetIDHistory(Integer.parseInt(cs.getString(1)));
			tp.SetName(cs.getString(2));
			tp.SetNumberPhone(cs.getString(3));
			list.add(tp);
			cs.moveToNext();
		}
		return list;
	}
	public String GetReplace()
	{
		String cha ="";
		Cursor cs = GetEntryReplace();
		try{
		cs.moveToFirst();
		cha = cs.getString(0);
		}catch(Exception e){
			Insert_tblReplace("##");
			cs.moveToFirst();
			cha = cs.getString(0);
		}
		return cha;
	}
	public int GetRowNumberHistoryContact(){
		
		Cursor cs = GetEntryHistory();
		cs.moveToLast();
		return cs.getInt(0);
		
		
		
	}
	
	
	public int AutoIncreasing(String TableName)
	{
		Cursor cs = GetEntryAuto();
		int count = 0;
		boolean flag = false;
		cs.moveToFirst();
		while (cs.isAfterLast() == false){
			
			if(cs.getString(0).contains(TableName)){

				flag =true;
				 count = cs.getInt(1);
				 
				 count++;
				 ContentValues args = new ContentValues();
				 args.put("Row", count);
				 vari.GetDatabase().GetDatabase().update(vari.TableAuto,args, "TableName='" + TableName + "'",null);
				 break;
			 }
			cs.moveToNext();
		}
		if(flag == false)
		{
			count++;
			Insert_tblAuto(TableName,count);
		}
		return count;
	}

}



