package com.BulkSMS;
import java.io.IOException;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;

public class ConnectService {

	 private  String namespace = "http://tempuri.org/";
	 private  String url = "http://thanhdung205.somee.com/webservice.asmx";
	 Context Con;
	 public ConnectService(Context con){
		 Con = con;
	 }
	 public ArrayList<StructTemplate> GetTemplate1() throws SoapFault{
		 String SOAP_ACTION = "http://tempuri.org/GetListSubject";
		 String method = "GetListSubject";
		 ArrayList<StructTemplate> listtem = new ArrayList<StructTemplate>();
		 SoapObject request = new SoapObject(namespace,method);
	        //request.addProperty("Username", UserName.getText().toString());
	        //request.addProperty("Pass",  Pass.getText().toString());
	        SoapSerializationEnvelope soapenvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        soapenvelope.dotNet = true;
	        soapenvelope.setOutputSoapObject(request);
	        AndroidHttpTransport http = new AndroidHttpTransport(url);
	        try
	        {
	        	http.call(SOAP_ACTION, soapenvelope);
	        	SoapObject result = (SoapObject) soapenvelope.getResponse();
	        	int totalCount = result.getPropertyCount();
	        	
	        	    for (int detailCount = 0; detailCount < totalCount; detailCount++) {
	        	       SoapObject pojoSoap = (SoapObject) result.getProperty(detailCount);
	        	       StructTemplate tem = new StructTemplate();
	        	       tem.SetID(Integer.parseInt(pojoSoap.getProperty("ID").toString()));
	        	       tem.SetContent(pojoSoap.getProperty("SubjectName").toString());
	        	       listtem.add(tem);
	        	    
	        	    }
	        }
	        catch(Exception e){
	        	 DialogOK a = new DialogOK(Con,"Thông báo",e.getMessage());
	             a.ShowMes();
	        	
	        }
		
	 
		return listtem;
}
	 public ArrayList<StructTemplate> GetTemplate2(int ID) throws SoapFault{
		 String SOAP_ACTION = "http://tempuri.org/GetListTemplate";
		 String method = "GetListTemplate";
		 ArrayList<StructTemplate> listtem = new ArrayList<StructTemplate>();
		 SoapObject request = new SoapObject(namespace,method);
	        request.addProperty("ID", ID);
	        SoapSerializationEnvelope soapenvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        soapenvelope.dotNet = true;
	        soapenvelope.setOutputSoapObject(request);
	        AndroidHttpTransport http = new AndroidHttpTransport(url);
	        try
	        {
	        	http.call(SOAP_ACTION, soapenvelope);
	        	SoapObject result = (SoapObject) soapenvelope.getResponse();
	        	int totalCount = result.getPropertyCount();
	        	       	
	        	    for (int detailCount = 0; detailCount < totalCount; detailCount++) {
	        	       SoapObject pojoSoap = (SoapObject) result.getProperty(detailCount);
	        	       StructTemplate tem = new StructTemplate();
	        	       tem.SetID(Integer.parseInt(pojoSoap.getProperty("ID").toString()));
	        	       tem.SetContent(pojoSoap.getProperty("Content").toString());
	        	       listtem.add(tem);
	        	    
	        	    }
	        }
	        catch(Exception e){
	        	 DialogOK a = new DialogOK(Con,"Thông báo",e.getMessage());
	             a.ShowMes();
	        	
	        }
		
	 
		return listtem;
}
}