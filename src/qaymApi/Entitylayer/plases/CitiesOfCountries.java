package qaymApi.Entitylayer.plases;

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

public class CitiesOfCountries extends Activity {
	 JSONArray json = null;
	 String country_id;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
      
      //Get the data of countries list 
       json = JSONfunctions.getJsonArray("countries/"+country_id+"/cities/key=");

             try{
            	 
            	       	//Loop the Array to get the data 
              for(int i1=0; i1 < json.length();i1++){						

              	HashMap<String, String> map = new HashMap<String, String>();
              	JSONObject e = json.getJSONObject(i1);
              // adding json to list 
              	map.put("CityId",   e.getString("city_id"));
              	map.put("Cityname",   e.getString("name"));
              	map.put("CityAddedBy",   e.getString("added_by"));
              	map.put("CityAdditionTimestamp",   e.getString("addition_timestamp"));
              	map.put("CityLatitude",   e.getString("latitude"));
              	map.put("CityLongitude",   e.getString("longitude"));
              	map.put("Cityzoom",   e.getString("zoom"));
              	
              	mylist.add(map);
              
      	}
             }catch(JSONException e)        {
             	 Log.e("log_tag", "Error parsing data "+e.toString());
             }
             
             
          
   }
}