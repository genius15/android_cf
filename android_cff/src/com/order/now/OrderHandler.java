package com.order.now;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.ClientParamsStack;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class OrderHandler extends Thread {
	LinkedList<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
	public OrderHandler(){
		params.add(new BasicNameValuePair("owner", "张帅"));
		params.add(new BasicNameValuePair("menu", "51"));
	}
	public void run(){
		String baseUrl = "http://192.168.101.85/chifanfan2/servlet/OrderServlet";
		HttpClient httpClient = new DefaultHttpClient(); 
		try {
		    HttpPost postMethod = new HttpPost(baseUrl);
		    postMethod.setEntity(new UrlEncodedFormEntity(params, "utf-8")); //将参数填入POST Entity中
						
		    HttpResponse response = httpClient.execute(postMethod); //执行POST方法
		   // Log.i(TAG, "resCode = " + response.getStatusLine().getStatusCode()); //获取响应码
		   // Log.i(TAG, "result = " + EntityUtils.toString(response.getEntity(), "utf-8")); //获取响应内容
		    String strResult;
		    if (response.getStatusLine().getStatusCode() == 200) {  
                /* 读返回数据 */  
                strResult = EntityUtils.toString(response.getEntity(),"utf-8");  
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
