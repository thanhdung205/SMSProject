package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class AdapterListViewGroupMain extends ArrayAdapter<StructGroup>{
	ArrayList<StructGroup> list;
	public AdapterListViewGroupMain(Context context, int textViewResourceId,
			ArrayList<StructGroup> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		View v = convertView;
		if (v == null) {
			
				v = new CustomListViewGroupMain(getContext());
			}
		final StructGroup d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListViewGroupMain) v).Text_Group;
			
				tv1.setText(d.GroupName);
			
		}
		return v;
	}
	@Override
	public StructGroup getItem(int position) {

		return list.get(position);
	}

}
