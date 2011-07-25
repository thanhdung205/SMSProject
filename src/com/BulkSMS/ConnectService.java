package com.BulkSMS;
import java.io.IOException;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;

public class ConnectService {
	 private static final String SOAP_ACTION = "http://tempuri.org/GetListSubject";
	 private static final String METHOD_NAME = "GetListSubject";
	 private static final String NAMESPACE = "http://tempuri.org/";
	 private static final String URL = "http://localhost:50736/ServiceSmartSMS/Service.asmx";
	 Context Con;
	 public ConnectService(Context con){
		 Con = con;
	 }
	 public ArrayList<StructTemplate> GetTemplate(){
		 ArrayList<StructTemplate> listtem = new ArrayList<StructTemplate>();
		 SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
         //request.addProperty("prop1", "myprop");
         SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
         envelope.dotNet=true;
         envelope.setOutputSoapObject(request);

         HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
         DialogOK a = new DialogOK(Con,"faf","hoho");
         a.ShowMes();
         
         try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			DialogOK b = new DialogOK(Con,"faf",e1.getMessage());
	         b.ShowMes();
		} catch (XmlPullParserException e1) {
			// TODO Auto-generated catch block
			DialogOK c = new DialogOK(Con,"faf",e1.getMessage());
	         c.ShowMes();
		}

         Object result = null;
		try {
			result = (Object)envelope.getResponse();
		} catch (SoapFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
         int totalCount = ((SoapObject) result).getPropertyCount();
         for (int detailCount = 0; detailCount < totalCount; detailCount++) {
             SoapObject pojoSoap = (SoapObject) ((SoapObject) result).getProperty(detailCount);
             StructTemplate tem = new StructTemplate();
             tem.SetID(Integer.parseInt(pojoSoap.getProperty("ID").toString()));
             tem.SetContent(pojoSoap.getProperty("SubjectName").toString());

             listtem.add(tem);
         }
		 return listtem;
	 }
}
