package com.BulkSMS;
import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
public class MenuItemAdapter extends ArrayAdapter<MenuItemList> {
	ArrayList<MenuItemList> listmenu;
	public MenuItemAdapter(Context context, int textViewResourceId,
			ArrayList<MenuItemList> objects) {
		super(context, textViewResourceId, objects);
		listmenu = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		View v = convertView;
		if (v == null) {
			
				v = new CustomListview(getContext());
			}
		MenuItemList d = listmenu.get(position);
		if(d != null )
		{
				TextView tv =  ((CustomListview) v).tv;
				tv.setText(d.GetTitle());
				ImageView img = ((CustomListview) v).img;
			
			Drawable image = getContext().getResources().getDrawable(getContext().getResources().getIdentifier(d.GetImage(), "drawable","com.BulkSMS"));
			img.setImageDrawable(image);
		}
		return v;
	}
	@Override
	public MenuItemList getItem(int position) {
		// TODO Auto-generated method stub
		
		return listmenu.get(position);
	}

	

}
