package com.BulkSMS;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;



public class RunnableGetContact extends Thread {

	
	  	public void run(){
    		ContentResolver cr = All_Var.Con.getContentResolver();
    		Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
    		ArrayListContact contact = new ArrayListContact();
    		if (cur.getCount() > 0) {
    			          while (cur.moveToNext()) {
    			        	  StructContact con = new StructContact();
    			              String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
    			               
    			              if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
    			                   			
    			                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
    			                                           ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
    			                                           new String[]{id}, null);
    			                    while (pCur.moveToNext()) {
    			                    	int typephone = pCur.getInt((pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE)));
    			                    	///
    			                    	if(typephone == ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE){
	    			                    	con.Name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
	    			                    	con.NumberPhone = pCur.getString(
	    			                                 pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
	    			                    	contact.SetListContact(con);
    			                    	}
    			                    }
    			                    pCur.close();
    			                }
    			          }
    	}
    	    All_Var.listcontact = contact;
    	}
    	
	
}
