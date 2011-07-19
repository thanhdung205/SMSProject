package com.BulkSMS;

import java.util.ArrayList;

public class ArrayListMenuSetting {
	public ArrayList<MenuItemList> arraylist;
	ArrayListMenuSetting(){
		arraylist = new ArrayList<MenuItemList>();
	}
	public ArrayList<MenuItemList> GetMenuSetting(){
		MenuItemList menu = new MenuItemList();
		menu.SetTitle("Đồng bộ với Web");
		menu.SetImage("drawable/web");
		MenuItemList menu1 = new MenuItemList();
		menu1.SetTitle("Thiết lập kí tự thay thế");
		menu1.SetImage("drawable/replace");
		arraylist.add(menu);
		arraylist.add(menu1);
		return arraylist;
	}
	
}
