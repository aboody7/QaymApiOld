package qaymApi.Entitylayer.Resturant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import qaymApi.Baselayer.Connection.JSONfunctions;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ResturantBranch extends Activity {
	 JSONArray json = null;
	 String resturant_id; 
	 

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
      
       
       json = JSONfunctions.getJsonArray("items/"+resturant_id+"/locations/key=");

             try{
            	 
              //Loop the Array to get the data 
              for(int i1=0; i1 < json.length();i1++){						

              	HashMap<String, String> map = new HashMap<String, String>();
              	JSONObject e = json.getJSONObject(i1);
              	
                map.put("country", e.getString("country"));
              	map.put("city",  e.getString("city"));
            	map.put("location_id",  e.getString("location_id"));
            	map.put("score",  e.getString("score"));
            	map.put("address",  e.getString("address"));
            	map.put("user_id",  e.getString("user_id"));
            	map.put("latitude",  e.getString("latitude"));
            	map.put("longitude",  e.getString("longitude"));
            	map.put("title",  e.getString("title"));
            	map.put("phone",  e.getString("phone"));
            	map.put("tiny_thumb_file_detail_id",  e.getString("tiny_thumb_file_detail_id"));
            	map.put("city_id",  e.getString("city_id"));
            	map.put("country_id",  e.getString("country_id"));
            	
            	
              	
              	
              	mylist.add(map);
              
      	}
             }catch(JSONException e)        {
             	 Log.e("log_tag", "Error parsing data "+e.toString());
             }
             
             
          
   }
}