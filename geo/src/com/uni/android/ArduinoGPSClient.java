package com.uni.android;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;

class ArduinoGPSClient {
    
	public void getCordenates() throws JSONException {
        ArduinoGPSRestClient.get("key/value", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray response) {
            	System.out.println(response);
//            	JSONObject firstEvent = null;
//				
//                try {
//					firstEvent = (JSONObject) timeline.get(0);
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//                String tweetText = null;
//
//                try {
//					tweetText = firstEvent.getString("text");
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//
//                // Do something with the response
//                System.out.println(tweetText);
            }
        });
    }
}