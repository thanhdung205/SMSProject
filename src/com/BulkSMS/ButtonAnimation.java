package com.BulkSMS;

import android.graphics.drawable.AnimationDrawable;
import android.widget.LinearLayout;

public class ButtonAnimation {
	public static void  ChangingAnimaion(LinearLayout bt){
		AnimationDrawable animation =new AnimationDrawable();
		animation.addFrame(All_Var.Con.getResources().getDrawable(R.drawable.buttonclicked), 0);
		animation.addFrame(All_Var.Con.getResources().getDrawable(R.drawable.tap), 200);
		bt.setBackgroundDrawable(animation);
		animation.start();
	}
	public static void  ChangingAnimaionBack(LinearLayout bt){
		AnimationDrawable animation =new AnimationDrawable();
		animation.addFrame(All_Var.Con.getResources().getDrawable(R.drawable.backgroundclicked), 0);
		bt.setBackgroundDrawable(animation);
		animation.start();
	}
}
