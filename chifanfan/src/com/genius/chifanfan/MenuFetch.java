package com.genius.chifanfan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class MenuFetch extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String baseUrl = "http://192.168.101.185/chifanfan2/servlet/MenuServlet";
		HttpClient httpClient = new DefaultHttpClient(); 
		System.out.println("start");
		try {
		    HttpPost postMethod = new HttpPost(baseUrl);					
		    HttpResponse response = httpClient.execute(postMethod); //执行POST方法

		    String strResult="nothing";
		    if (response.getStatusLine().getStatusCode() == 200) {  
                /* 读返回数�?*/  
		    	strResult = EntityUtils.toString(response.getEntity());                
       
            } else {  
                strResult = "Error Response: "  
                        + response.getStatusLine().toString();  
            }  
		    System.out.println(strResult);
		    
		} catch (UnsupportedEncodingException e) {
	
		    e.printStackTrace();
		} catch (ClientProtocolException e) {

		    e.printStackTrace();
		} catch (IOException e) {
		  
		    e.printStackTrace();
		}
	}
	


}
