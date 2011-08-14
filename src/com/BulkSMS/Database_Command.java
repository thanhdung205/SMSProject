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
	public void Insert_tblSaveID(int Str,String Content){
		 ContentValues args = new ContentValues();
		 args.put("ID", Str);
		 args.put("Content", Content);
		 vari.GetDatabase().GetDatabase().insert(vari.GetTableSaveID(), null, args);
	}
	public void Insert_tblSaveIDSend(int Str){
		 ContentValues args = new ContentValues();
		 args.put("ID", Str);
		 vari.GetDatabase().GetDatabase().insert(vari.GetSaveID_Send(), null, args);
	}
	public void Insert_tblAuto(String Name,int  Row){
		vari.GetDatabase().GetDatabase().execSQL("insert into " + vari.TableAuto + " values('" + Name +"','" + Row +"');");
	}
	public void Insert_tblAutoSend(String dateTime,String Content,String Status){
		ContentValues args = new ContentValues();
		args.put("DatetimeSend", dateTime);
		args.put("Content", Content);
		args.put("Status", Status);
		vari.GetDatabase().GetDatabase().insert(vari.GetAutoSend(), null, args);
	}
	public void Insert_tblAutoSend_Contact(int IDAuto,String Name,String NumberPhone){
		ContentValues args = new ContentValues();
		 args.put("ID_Send", IDAuto);
		 args.put("Name", Name);
		 args.put("NumberPhone", NumberPhone);
		vari.GetDatabase().GetDatabase().insert(vari.GetAutoSend_Contact(), null, args);
	}
	public void Insert_tblHistory(String DateTime,String Content,String Status){
		ContentValues args = new ContentValues();
		args.put("DateTime", DateTime);
		args.put("Content", Content);
		args.put("Status", Status);
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
	public void Delete_tblHistory(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetHistory(),"ID=?" ,args);
	}
	public void Delete_tblAutoSend(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetAutoSend(),"ID=?" ,args);
	}
	
	public void Delete_tblContact(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.TableContact,"ID_Group=?" ,args);
	}
	public void Delete_tblContact(String NumPhone){
		String[] args = {"" + NumPhone + ""};
		vari.GetDatabase().GetDatabase().delete(vari.TableContact,"NumberPhone=?" ,args);
	}
	public void Delete_tblHistoryContact(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetHistory_Contact(),"ID_History=?" ,args);
	}
	public void Delete_tblAutoSendContact(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetAutoSend_Contact(),"ID_Send=?" ,args);
	}
	public void Delete_tblReplace(String Str){
		String[] args = {"" + Str + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetTableReplace(),"RepChar=?" ,args);
	}
	public void Delete_tblSaveID(String Str){
		String[] args = {"" + Str + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetTableSaveID(),"ID=?" ,args);
	}
	public void Delete_tblSaveIDSend(int ID){
		String[] args = {"" + ID + ""};
		vari.GetDatabase().GetDatabase().delete(vari.GetSaveID_Send(),"ID=?" ,args);
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
	public void Update_tblAutoSendStatus(int ID,String Str){
		ContentValues args = new ContentValues();
		 args.put("Status", Str);
		 String[] args1 = {"" + ID + ""};
		 vari.GetDatabase().GetDatabase().update(vari.GetAutoSend(), args, "ID=?",args1);
	}
	public void Update_tblHistoryStatus(int ID,String Str){
		ContentValues args = new ContentValues();
		 args.put("Status", Str);
		 String[] args1 = {"" + ID + ""};
		 vari.GetDatabase().GetDatabase().update(vari.GetHistory(), args, "ID=?",args1);
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
		return vari.GetDatabase().GetDatabase().query(vari.GetHistory(), new String[] {"ID", "DateTime","Content","Status"}, 
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
	public Cursor GetEntrySaveID()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetTableSaveID(), new String[] {"ID","Content"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntrySaveIDSend()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetSaveID_Send(), new String[] {"ID"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryAutoSend()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetAutoSend(), new String[] {"ID","DatetimeSend","Content","Status"}, 
                null, null, null, null, null);
	}
	public Cursor GetEntryAutoSendContact()
	{
		return vari.GetDatabase().GetDatabase().query(vari.GetAutoSend_Contact(), new String[] {"ID","ID_Send","Name","NumberPhone"}, 
                null, null, null, null, null);
	}
	public ArrayList<StructAutoSend> GetListAutoSend()
	{
		Cursor cs = GetEntryAutoSend();
		ArrayList<StructAutoSend> list =new ArrayList<StructAutoSend>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructAutoSend gr = new StructAutoSend();
			gr.SetID(cs.getInt(0));
			gr.SetDateTime(cs.getString(1));
			gr.SetContent(cs.getString(2));
			gr.SetStatus(cs.getString(3));
			list.add(gr);
			cs.moveToNext();
		}
		return list;
	}
	public void DeleteAll_AutoSend()
	{
		Cursor cs = GetEntryAutoSend();
		
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			Delete_tblAutoSendContact(cs.getInt(0));
			Delete_tblAutoSend(cs.getInt(0));
			cs.moveToNext();
		}
	}
	public ArrayList<StructAutoSendContact> GetListAutoSendContact()
	{
		Cursor cs = GetEntryAutoSendContact();
		ArrayList<StructAutoSendContact> list =new ArrayList<StructAutoSendContact>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructAutoSendContact gr = new StructAutoSendContact();
			gr.SetID(cs.getInt(0));
			gr.SetIDAuto(cs.getInt(1));
			gr.SetName(cs.getString(2));
			gr.SetNumberPhone(cs.getString(3));
			list.add(gr);
			cs.moveToNext();
		}
		return list;
	}
	public ArrayList<StructAutoSendContact> GetListAutoSendContact(int ID)
	{
		Cursor cs = GetEntryAutoSendContact();
		ArrayList<StructAutoSendContact> list =new ArrayList<StructAutoSendContact>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructAutoSendContact gr = new StructAutoSendContact();
			gr.SetID(cs.getInt(0));
			gr.SetIDAuto(cs.getInt(1));
			gr.SetName(cs.getString(2));
			gr.SetNumberPhone(cs.getString(3));
			if(gr.GetIDAuto() == ID)
				list.add(gr);
			cs.moveToNext();
		}
		return list;
	}
	public ArrayList<StructGroup> GetListGroup()
	{
		
		Cursor cs = GetEntryGroup();
		ArrayList<StructGroup> list =new ArrayList<StructGroup>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructGroup gr = new StructGroup();
			gr.SetID(cs.getInt(0));
			gr.SetGroupName(cs.getString(1) + "(" +  GetListContact(cs.getInt(0)).size()  +")");
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
	public ArrayList<StructContact_Group> GetListContact(int ID)
	{
		
		Cursor cs = GetEntryContact();
		ArrayList<StructContact_Group> list =new ArrayList<StructContact_Group>();
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			StructContact_Group tp = new StructContact_Group();
			StructContact con = new StructContact();
			if(Integer.parseInt(cs.getString(1)) == ID){
				tp.SetIDGroup(Integer.parseInt(cs.getString(1)));
				con.SetName(cs.getString(2));
				con.SetNumberPhone(cs.getString(3));
				tp.SetConcact(con); 
				list.add(tp);
			}
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
			tp.SetStatus(cs.getString(3));
			list.add(tp);
			cs.moveToNext();
		}
		return list;
	}
	public void DeleteAll_History()
	{
		
		Cursor cs = GetEntryHistory();
		
		cs.moveToFirst();
		while (cs.isAfterLast() == false) {
			Delete_tblHistoryContact(cs.getInt(0));
			Delete_tblHistory(cs.getInt(0));
			cs.moveToNext();
		}
		
		
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
		
		
		cs.moveToFirst();
		if(cs.isAfterLast())
		{
			Insert_tblReplace("##");
			cha = "##";
		}
		else
			cha = cs.getString(0);
		return cha;
	}
	public StructAutoSend GetSaveID(){
		Cursor cs = GetEntrySaveID();
		try{
		cs.moveToFirst();
		StructAutoSend auto = new StructAutoSend();
		auto.SetID(cs.getInt(0));
		auto.SetContent(cs.getString(1));
		return auto;
		}catch(Exception e)
		{
			
		}
		return null;
		
	}
	public int GetSaveIDSend(){
		Cursor cs = GetEntrySaveIDSend();
		cs.moveToFirst();
		return cs.getInt(0);
	}
	public void DeleteAllSaveID()
	{
		Cursor cs = GetEntrySaveID();
		cs.moveToFirst();
		while(!cs.isAfterLast())
		{
			Delete_tblSaveID(cs.getString(0));
			cs.moveToNext();
		}	
	}
	public int GetRowNumberHistoryContact(){
		Cursor cs = GetEntryHistory();
		cs.moveToLast();
		return cs.getInt(0);
	}
public int GetRowNumberAutoSend(){
		Cursor cs = GetEntryAutoSend();
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



