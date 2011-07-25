package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewScheduler extends LinearLayout{
	TextView TextContent;
	TextView TextDateTime;
	TextView TextStatus;
	public CustomListViewScheduler(Context context) {
		super(context);
		 LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customschedulerlistview, this, true);
		TextContent = (TextView) findViewById(R.id.Scheduler_TxtContent);
		TextDateTime = (TextView) findViewById(R.id.Scheduler_txtDateTime);
		TextStatus = (TextView) findViewById(R.id.Scheduler_txtStatus);
	}
}
