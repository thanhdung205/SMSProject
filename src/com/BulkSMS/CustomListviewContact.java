package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListviewContact extends LinearLayout {
	TextView Text_Name;
	TextView Text_NumberPhone;
	ImageView Img_Checkbox;
	public CustomListviewContact(Context context) {
		super(context);
		LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customcontactlistview, this, true);
		Text_Name = (TextView) findViewById(R.id.creategroup_List_Name);
		Text_NumberPhone = (TextView) findViewById(R.id.creategroup_List_NumberPhone);
		Img_Checkbox  = (ImageView) findViewById(R.id.creategroup_CheckBox);
	}
}
