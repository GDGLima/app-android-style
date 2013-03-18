package com.gdglima.projects.gdgandroidtour.handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.gdglima.projects.gdgandroidtour.model.Event;
import com.gdglima.projects.gdgandroidtour.model.Staff;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

public class EventUpdateHttpResponseHandler extends JsonHttpResponseHandler
{
	public boolean updated;
	public Context context;
	public int async;
	
	public EventUpdateHttpResponseHandler(Context context,int async) {
		this.context=context;
		this.async=async;
		updated = false;
		
	}
	@Override
	public void onSuccess(JSONObject response) {
		super.onSuccess(response);
		if (Event.first()!=null){
			Event.deleteAll(Event.class);
		}
		Gson gson = new Gson();
		JSONObject jsonObj;
		try {
			jsonObj = response;
			Event event_obj =  new Event(context);
			event_obj.setDate(jsonObj.getString("date"));
			event_obj.setTime(jsonObj.getString("time"));
			event_obj.setUrl(jsonObj.getString("url"));
			event_obj.setAbout(jsonObj.getString("about"));
			event_obj.setPlus_event_url(jsonObj.getString("google+_event_url"));
			event_obj.setLocation(jsonObj.getString("location"));
			Log.d("json obj", jsonObj.toString());
			event_obj.save();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		Log.d("alls event",Event.all().toString());
		updated=true;
	}
	
	@Override
	public void onFinish()
	{
	//	if (async==0)
	//	((HomeActivity)context).UpdateNoticeCallback(updated);
	}
}
