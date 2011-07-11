package com.BulkSMS;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
				tv1.setText(d.GetContact().GetName());
				TextView tv2 =  ((CustomListviewContact) v).Text_NumberPhone;
				tv2.setText(d.GetContact().GetNumberPhone());
				final ImageView img = ((CustomListviewContact) v).Img_Checkbox;
			
				img.setOnClickListener(new OnClickListener(){

					public void onClick(View arg0) {
						if(d.GetIsChecked() == false){
							d.SetIsChecked(true);
							Drawable image = getContext().getResources().getDrawable(getContext().getResources().getIdentifier("checkedbox", "drawable","com.BulkSMS"));
							img.setImageDrawable(image);
						}
						else
						{
							d.SetIsChecked(false);
							Drawable image = getContext().getResources().getDrawable(getContext().getResources().getIdentifier("checkbox", "drawable","com.BulkSMS"));
							img.setImageDrawable(image);
						}
					}});
		}
		return v;
	}
	@Override
	public Struct_ListViewContact getItem(int position) {
		// TODO Auto-generated method stub
		
		return list.get(position);
	}

	


}
