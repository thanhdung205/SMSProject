package com.BulkSMS;

import java.util.ArrayList;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;


public class SchedulerBroadcastReceiver extends BroadcastReceiver {

	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Database_Command  com = new Database_Command(arg0);
		
		StructAutoSend send = com.GetSaveID();
		if(send != null){
        	ArrayList<StructAutoSendContact> auto = new ArrayList<StructAutoSendContact>();
			auto = com.GetListAutoSendContact(send.GetID());
			String strReplace = com.GetReplace();
			
			com.Update_tblAutoSendStatus(send.GetID(), "Da thuc hien");
			SmsManager sms = SmsManager.getDefault();
			for(int i = 0;i<auto.size();i++)
			{
			
				String Content = send.GetContent();
				if(Content.contains(strReplace)){
					Toast.makeText(arg0, Content , Toast.LENGTH_SHORT).show();
					Content = Content.replace(strReplace,auto.get(0).GetName());
					Toast.makeText(arg0,Content , Toast.LENGTH_SHORT).show();
				}
				sms.sendTextMessage(auto.get(0).GetNumberPhone(), null, Content, null, null);
			}
		}
		Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
		sche.Send(arg0);
	}
}