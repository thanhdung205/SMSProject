package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewService extends LinearLayout {
TextView Text_Subject;
	
	public CustomListViewService(Context context) {
		super(context);
		LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customnetworklistview, this, true);
		Text_Subject = (TextView) findViewById(R.id.Service_List);
	}
}
