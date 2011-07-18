package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListviewGroup extends LinearLayout {

	TextView Text_Group;
	CheckBox Img_Checkbox;

	public CustomListviewGroup(Context context) {
		super(context);
		LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customgrouplistview, this, true);
		Text_Group = (TextView) findViewById(R.id.creategroup_List_Group);
	
		Img_Checkbox  = (CheckBox) findViewById(R.id.creategroup_CheckBoxGroup);
	}

}
