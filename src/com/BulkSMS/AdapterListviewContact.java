package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterListviewContact extends ArrayAdapter<Struct_ListViewContact> {
	ArrayList<Struct_ListViewContact> list;
	public AdapterListviewContact(Context context, int textViewResourceId,
			ArrayList<Struct_ListViewContact> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		View v = convertView;
		if (v == null) {
			
				v = new CustomListviewContact(getContext());
			}
		final Struct_ListViewContact d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListviewContact) v).Text_Name;
				
				TextView tv2 =  ((CustomListviewContact) v).Text_NumberPhone;
				
				final CheckBox img = ((CustomListviewContact) v).Img_Checkbox;
				img.setOnCheckedChangeListener(new OnCheckedChangeListener(){

					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						d.SetIsChecked(arg1);
					}
					
				});
				tv1.setText(d.GetContact().GetName());
				tv2.setText(d.GetContact().GetNumberPhone());
				img.setChecked(d.GetIsChecked());
		}
		return v;
	}
	@Override
	public Struct_ListViewContact getItem(int position) {

		return list.get(position);
	}

	


}
