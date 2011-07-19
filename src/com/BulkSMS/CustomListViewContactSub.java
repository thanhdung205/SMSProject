package com.BulkSMS;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewContactSub extends LinearLayout{
	TextView TextName;
	TextView TextNumberPhone;
	public CustomListViewContactSub(Context context) {
		super(context);
		 LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.customcontactlistviewsub, this, true);
		TextName = (TextView) findViewById(R.id.History_ContactName);
		TextNumberPhone = (TextView) findViewById(R.id.History_ContactNumberPhone);
	}
	

}
