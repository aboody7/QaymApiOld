package qaymApi.Baselayer.Connection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONfunctions {
	static String key="PSZDzMfaP9Xo8pucmv5";
	static String RootUrl="http://api.qaym.com/0.1/";

	public static JSONObject getJsonObject(String url){
		InputStream is = null;
		String result = "";
		JSONObject jArray = null;
		String FullUrl= RootUrl +url+key;
		
		//http post
	    try{
	            HttpClient httpclient = new DefaultHttpClient();
	            HttpPost httppost = new HttpPost(FullUrl);
	            HttpResponse response = httpclient.execute(httppost);
	            System.out.print(response);
	            HttpEntity entity = response.getEntity();
	            is = entity.getContent();
                System.out.print(is);
                Log.e("json data", is.toString());
	    }catch(Exception e){
	            Log.e("log_tag", "Error in http connection "+e.toString());
	    }
	    
	  //convert response to string
	    try{
	            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                    sb.append(line + "\n");
	            }
	            is.close();
	            result=sb.toString();
	    }catch(Exception e){
	            Log.e("log_tag", "Error converting result "+e.toString());
	    }
	    
	    try{
	    	
	    	System.out.print(result);
            jArray = new JSONObject(result);            
	    }catch(JSONException e){
	            Log.e("log_tag", "Error parsing data "+e.toString());
	    }
    
	    return jArray;
	}
	
	
	public static JSONArray getJsonArray(String url){
		InputStream is = null;
		String result = "";
		JSONArray jArray = null;
		String FullUrl= RootUrl +url+key;
		
		//http post
	    try{
	            HttpClient httpclient = new DefaultHttpClient();
	            HttpGet httppost = new HttpGet(RootUrl);
	            HttpResponse response = httpclient.execute(httppost);
	            System.out.print(response);
	            HttpEntity entity = response.getEntity();
	            is = entity.getContent();
                System.out.print(is);
	    }catch(Exception e){
	            Log.e("log_tag", "Error in http connection "+e.toString());
	    }
	    
	  //convert response to string
	    try{
	            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                    sb.append(line + "\n");
	            }
	            is.close();
	            result=sb.toString();
	    }catch(Exception e){
	            Log.e("log_tag", "Error converting result "+e.toString());
	    }
	    
	    try{
	    	
	    	System.out.print(result);
            jArray = new JSONArray(result);            
	    }catch(JSONException e){
	            Log.e("log_tag", "Error parsing data "+e.toString());
	    }
    
	    return jArray;
	}
	
	
}
