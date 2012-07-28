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

public class ResturantReview extends Activity {
	 JSONArray json = null;
	 String resturant_id; 
	 

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
      
       
       json = JSONfunctions.getJsonArray("items/"+resturant_id+"/reviews/key=");

             try{
            	 
              //Loop the Array to get the data 
              for(int i1=0; i1 < json.length();i1++){						

              	HashMap<String, String> map = new HashMap<String, String>();
              	JSONObject e = json.getJSONObject(i1);
              	
              	map.put("username", e.getString("username"));
              	map.put("title",  e.getString("title"));
            	map.put("user_id",  e.getString("user_id"));
            	map.put("score",  e.getString("score"));
            	map.put("time",  e.getString("time"));
            	map.put("number_of_posts",  e.getString("number_of_posts"));
            	map.put("last_poster_id",  e.getString("last_poster_id"));
            	map.put("last_post_time",  e.getString("last_post_time"));
            	map.put("text",  e.getString("text"));
            	map.put("last_edit_user_id",  e.getString("last_edit_user_id"));
            	map.put("last_edit_time",  e.getString("last_edit_time"));
            	
              	
              	
              	mylist.add(map);
              
      	}
             }catch(JSONException e)        {
             	 Log.e("log_tag", "Error parsing data "+e.toString());
             }
             
             
          
   }
}