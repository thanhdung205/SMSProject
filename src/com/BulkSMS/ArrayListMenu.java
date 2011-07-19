package com.BulkSMS;

import java.util.ArrayList;

public class ArrayListMenu {
	public ArrayList<MenuItemList> arraylist;
	ArrayListMenu(){
		arraylist = new ArrayList<MenuItemList>();
	}
	public void GetMenu()
	{
		MenuItemList menu = new MenuItemList();
		menu.SetImage("drawable/group");
		menu.SetTitle("Nhóm");
		MenuItemList menu1 = new MenuItemList();
		menu1.SetImage("drawable/sendsms");
		menu1.SetTitle("Gửi tin nhắn");
		MenuItemList menu2 = new MenuItemList();
		menu2.SetImage("drawable/template");
		menu2.SetTitle("Các mẫu SMS");
		MenuItemList menu3 = new MenuItemList();
		menu3.SetImage("drawable/scheduler");
		menu3.SetTitle("Sắp lịch nhắn tin");
		MenuItemList menu4 = new MenuItemList();
		menu4.SetImage("drawable/onlinestorage");
		menu4.SetTitle("Các mẫu trực tuyến");
		MenuItemList menu5 = new MenuItemList();
		menu5.SetImage("drawable/history");
		menu5.SetTitle("Lịch sử tin nhắn");
		MenuItemList menu6 = new MenuItemList();
		menu6.SetImage("drawable/setting");
		menu6.SetTitle("Cấu hình");
		MenuItemList menu7 = new MenuItemList();
		menu7.SetImage("drawable/exit");
		menu7.SetTitle("Thoát");
		
		arraylist.add(menu);
		arraylist.add(menu1);
		arraylist.add(menu2);
		arraylist.add(menu3);
		arraylist.add(menu4);
		arraylist.add(menu5);
		arraylist.add(menu6);
		arraylist.add(menu7);
	}
	

}
