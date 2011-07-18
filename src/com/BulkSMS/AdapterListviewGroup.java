package com.BulkSMS;

import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
public class AdapterListviewGroup extends ArrayAdapter<StructListview_Group>{
	ArrayList<StructListview_Group> list;
	public AdapterListviewGroup(Context context, int textViewResourceId,
			ArrayList<StructListview_Group> objects) {
		super(context, textViewResourceId, objects);
		list = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		View v = convertView;
		if (v == null) {
			
				v = new CustomListviewGroup(getContext());
			}
		final StructListview_Group d = list.get(position);
		if(d != null )
		{
				TextView tv1 =  ((CustomListviewGroup) v).Text_Group;
				final CheckBox img = ((CustomListviewGroup) v).Img_Checkbox;
				img.setOnCheckedChangeListener(new OnCheckedChangeListener(){
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						d.SetIsChecked(arg1);
					}
					
				});
				tv1.setText(d.GetGroup().GetGroupName());
				img.setChecked(d.GetIsChecked());
		}
		return v;
	}
	@Override
	public StructListview_Group getItem(int position) {

		return list.get(position);
	}

}
