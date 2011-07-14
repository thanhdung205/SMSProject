package com.BulkSMS;

	import android.app.AlertDialog;
	import android.content.Context;
	import android.content.DialogInterface;
	import android.content.DialogInterface.OnClickListener;

	public class DialogOK {
		AlertDialog.Builder dia; 
		public DialogOK(Context Ac,String Title, String Mes)
		{
			dia = new AlertDialog.Builder(Ac);
			dia.setTitle(Title);
			dia.setMessage(Mes);
		}
		public void ShowMes()
		{
			dia.setPositiveButton("OK", new OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}			
			}
			);
			dia.show();
		}
	}

