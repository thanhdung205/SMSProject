package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterListViewContactSub extends ArrayAdapter<StructContact> {
	ArrayList<StructContact> list;
	public AdapterListViewContactSub(Context context, int textViewResourceId,
			ArrayList<StructContact> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		if (v == null) {
			
				v = new CustomListViewContactSub(getContext());
			}
		final StructContact d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListViewContactSub) v).TextName;
				TextView tv2 = ((CustomListViewContactSub) v).TextNumberPhone;
				
				tv1.setText(d.GetName());
				tv2.setText(d.GetNumberPhone());
		}
		return v;
	}
	@Override
	public StructContact getItem(int position) {

		return list.get(position);
	}

}
