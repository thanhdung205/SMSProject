package com.BulkSMS;

import java.util.ArrayList;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class AdapterListViewHistory extends ArrayAdapter<StructHistory>{

	ArrayList<StructHistory> list;
	public AdapterListViewHistory(Context context, int textViewResourceId,
			ArrayList<StructHistory> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		if (v == null) {
			
				v = new CustomListViewHistory(getContext());
			}
		final StructHistory d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListViewHistory) v).TextContent;
				TextView tv2 = ((CustomListViewHistory) v).TextDateTime;
				TextView tv3 = ((CustomListViewHistory) v).TextStatus;
				
				tv1.setText(d.GetContent());
				tv2.setText(d.GetDateTime());
				tv3.setText(d.GetStatus());
		}
		return v;
	}
	@Override
	public StructHistory getItem(int position) {

		return list.get(position);
	}
	
}
