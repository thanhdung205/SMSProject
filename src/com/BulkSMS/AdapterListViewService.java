package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterListViewService extends ArrayAdapter<StructTemplate> {
	ArrayList<StructTemplate> list;
	public AdapterListViewService(Context context, int textViewResourceId,
			ArrayList<StructTemplate> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		View v = convertView;
		if (v == null) {
			
				v = new CustomListViewService(getContext());
			}
		final StructTemplate d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListViewService) v).Text_Subject;
			
				tv1.setText(d.GetContent());
			
		}
		return v;
	}
	@Override
	public StructTemplate getItem(int position) {

		return list.get(position);
	}
}
