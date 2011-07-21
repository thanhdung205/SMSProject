package com.BulkSMS;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SchedulerBroadcastReceiver extends BroadcastReceiver {

	Context con1;
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		con1 = arg0;
		try{
		GetID(All_Var.ID_AutoSend);
		}catch(Exception e){
			System.out.print("haha");
		}
		 
	}
	public ArrayList<StructContact> GetCon(int ID)
	{
		ArrayList<StructContact> con =new ArrayList<StructContact>();
		Database_Command com = new Database_Command(con1);
		
		ArrayList<StructAutoSendContact> auto = com.GetListAutoSendContact();
		for(int i = 0 ;i<auto.size();i++ )
		{
			if(auto.get(i).GetIDAuto() == ID){
			StructContact str = new StructContact();
			str.SetName(auto.get(i).GetName());
			str.SetNumberPhone(auto.get(i).GetNumberPhone());
			con.add(str);
			}
		}
		return con;
	}
	public void GetID(int ID){
		Database_Command com = new Database_Command(con1);
		ArrayList<StructAutoSend> list = new ArrayList<StructAutoSend>();
		list = com.GetListAutoSend();
		for(int i =0 ;i < list.size();i++){
			if(list.get(i).GetID() == ID){
				ArrayList<StructContact> contact = GetCon(ID);
				for(int j=0;j<contact.size();j++){
					send(contact.get(j).GetNumberPhone(),list.get(j).GetContent());
				}
				
			}
		}
	}
	public void send(String Number,String Mes)
	{
		SmsManager sms = SmsManager.getDefault();
	     sms.sendTextMessage(Number, null,Mes, null, null);
	}

}
