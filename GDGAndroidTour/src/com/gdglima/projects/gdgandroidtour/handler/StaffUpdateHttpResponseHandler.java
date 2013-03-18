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

public class StaffUpdateHttpResponseHandler extends JsonHttpResponseHandler
{
	public boolean updated;
	public Context context;
	public int async;
	
	public StaffUpdateHttpResponseHandler(Context context,int async) {
		this.context=context;
		this.async=async;
		updated = false;
		
	}
	@Override
	public void onSuccess(JSONArray response) {
		super.onSuccess(response);
		if (Staff.first()!=null){
			Staff.deleteAll(Staff.class);
		}
		Gson gson = new Gson();
		JSONObject jsonObj;
		for (int i = 0; i < response.length(); i++) {
			try {
				jsonObj = response.getJSONObject(i);
				Staff staff_obj =  new Staff(context);
				staff_obj.setPlus_username(jsonObj.getString("plus_username"));
				staff_obj.setPlus_email(jsonObj.getString("plus_email"));
				staff_obj.setPlus_bio(jsonObj.getString("plus_bio"));
				staff_obj.setPlus_image(jsonObj.getString("plus_image"));
				staff_obj.setPlus_url(jsonObj.getString("plus_url"));
				Log.d("json obj", jsonObj.toString());
				staff_obj.save();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.d("alls",Staff.all().toString());
		updated=true;
	}
	
	@Override
	public void onFinish()
	{
	//	if (async==0)
	//	((HomeActivity)context).UpdateNoticeCallback(updated);
	}
}
