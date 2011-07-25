package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterListViewAuto extends ArrayAdapter<StructAutoSend> {
	ArrayList<StructAutoSend> list;
	public AdapterListViewAuto(Context context, int textViewResourceId,
			ArrayList<StructAutoSend> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		if (v == null) {
			
				v = new CustomListViewAuto(getContext());
			}
		final StructAutoSend d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListViewAuto) v).TextContent;
				TextView tv2 = ((CustomListViewAuto) v).TextDateTime;
				TextView tv3 = ((CustomListViewAuto) v).TextStatus;
				
				tv1.setText(d.GetContent());
				tv2.setText(d.GetDateTime());
				tv3.setText(d.GetStatus());
		}
		return v;
	}
	@Override
	public StructAutoSend getItem(int position) {

		return list.get(position);
	}

}
