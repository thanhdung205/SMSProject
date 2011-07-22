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
		Toast.makeText(arg0, "haha", Toast.LENGTH_SHORT).show();
		
			Scheduler_RepeatingAlarm sche = new Scheduler_RepeatingAlarm();
			sche.Send(arg0);
		
		 
	}
}
