package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewHistory extends LinearLayout {
	TextView TextContent;
	TextView TextDateTime;
	TextView TextStatus;
	public CustomListViewHistory(Context context) {
		super(context);
		 LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customhistorylistview, this, true);
		TextContent = (TextView) findViewById(R.id.History_TxtContent);
		TextDateTime = (TextView) findViewById(R.id.History_TxtDateTime);
		TextStatus = (TextView) findViewById(R.id.History_TxtStatus);
	}
	
}
