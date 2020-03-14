package com.aerors.ocs.cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

//动态调用
public class DynamicClientTest {
	private static String url = "http://192.168.0.103:8080/ocs/service/ws?wsdl";
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory  factory =JaxWsDynamicClientFactory.newInstance();
		Client client =factory.createClient(url);
		Object[] obj =client.invoke("test", "");
		System.out.println("resp:"+obj[0]);
	}
}
