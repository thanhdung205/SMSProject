package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewGroupMain extends LinearLayout{
	TextView Text_Group;
	
	public CustomListViewGroupMain(Context context) {
		super(context);
		LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customgroupmainlistview, this, true);
		Text_Group = (TextView) findViewById(R.id.Group_List_Group);
	}
}
