package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SchedulerBroadcastReceiver extends BroadcastReceiver {

	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "Đã gửi tin", Toast.LENGTH_SHORT).show();
		final Database_Command  com = new Database_Command(arg0);
		final StructAutoSend send = com.GetSaveID();
		
		String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";
 
        PendingIntent sentPI = PendingIntent.getBroadcast(arg0, 0,
            new Intent(SENT), 0);
 
        PendingIntent deliveredPI = PendingIntent.getBroadcast(arg0, 0,
            new Intent(DELIVERED), 0);
 
        
        arg0.registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
            	if(getResultCode() == Activity.RESULT_OK )
            	{
            		com.Update_tblAutoSendStatus(send.GetID(), "Đã gửi");
            	}
            	else{
            		com.Update_tblAutoSendStatus(send.GetID(), "Khong gui duoc");
            	}       
            }
        }, new IntentFilter(SENT));
        arg0.registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
            	if(getResultCode() == Activity.RESULT_OK )
            	{
            		com.Update_tblAutoSendStatus(send.GetID(), "Gui thanh cong");
            	}
            }
        }, new IntentFilter(DELIVERED));        

		
		
		
			
			ArrayList<StructAutoSendContact> auto = new ArrayList<StructAutoSendContact>();
			auto = com.GetListAutoSendContact(send.GetID());
			String strReplace = com.GetReplace();
			
			for(int i = 0;i<auto.size();i++)
			{
				String Content = send.GetContent();
				if(Content.contains(strReplace)){
					Content.replace(strReplace,auto.get(i).GetName());
					SmsManager sms = SmsManager.getDefault();
					sms.sendTextMessage(auto.get(i).GetNumberPhone(), null, Content, sentPI, deliveredPI);
				}
			}
			Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
			sche.Send(arg0);
	}
}
