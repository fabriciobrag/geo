package com.uni.android;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.getjson.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends Activity {

	private AsyncHttpClient client;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		client = new AsyncHttpClient();
		makeRequest();
		
	}
	
	public void makeRequest () {
		
		client.get("http://echo.jsontest.com/lat/3.5413/log/58.54665", new AsyncHttpResponseHandler() {
		    @Override
		    public void onSuccess(String response) {
		    	try {
					JSONArray finalResult = new JSONArray(new JSONTokener("["+response+"]"));
					
					for (int i = 0; i < finalResult.length(); i++) {
					    JSONObject message = finalResult.getJSONObject(i);
					    String lat = message.getString("lat");
					    String log = message.getString("log");
					    
					    System.out.println(lat);
					    System.out.println(log);
					}
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.update:
	        makeRequest();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}
