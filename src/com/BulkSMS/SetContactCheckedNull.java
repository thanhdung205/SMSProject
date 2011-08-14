package com.BulkSMS;

public class SetContactCheckedNull extends Thread{
	public  void run(){
		for(int i = 0 ; i < All_Var.listcontact.GetListContact().size(); i++){
			All_Var.listcontact.GetListContact().get(i).SetIsChecked(false);
		}
	}

}
