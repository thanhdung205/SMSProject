package com.BulkSMS;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class CustomListview extends LinearLayout{
	TextView tv;
	ImageView img;
	public CustomListview(Context context) {
		super(context);
		LayoutInflater li = (LayoutInflater) this.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.mainlist, this, true);
		tv = (TextView) findViewById(R.id.itemtitle);
		img =(ImageView) findViewById(R.id.itemimage);
		
	}

}
