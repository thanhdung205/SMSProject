package com.BulkSMS;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SchedulerBroadcastReceiver extends BroadcastReceiver {

	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "Đã gửi tin", Toast.LENGTH_SHORT).show();
		
			Database_Command  com = new Database_Command(arg0);
			StructAutoSend send = com.GetSaveID();
			ArrayList<StructAutoSendContact> auto = new ArrayList<StructAutoSendContact>();
			auto = com.GetListAutoSendContact(send.GetID());
			String strReplace = com.GetReplace();
			com.Update_tblAutoSendStatus(send.GetID(), "Đã gửi");
			for(int i = 0;i<auto.size();i++)
			{
				String Content = send.GetContent();
				if(Content.contains(strReplace)){
					Content.replace(strReplace,auto.get(i).GetName());
					SmsManager sms = SmsManager.getDefault();
					sms.sendTextMessage(auto.get(i).GetNumberPhone(), null, Content, null, null);
				}
			}
			Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
			sche.Send(arg0);
	}
}
