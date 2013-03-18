package com.gdglima.projects.gdgandroidtour.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import android.content.Context;

import com.gdglima.projects.gdgandroidtour.handler.EventUpdateHttpResponseHandler;
import com.gdglima.projects.gdgandroidtour.handler.StaffUpdateHttpResponseHandler;
import com.gdglima.projects.gdgandroidtour.utils.Constants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.orm.SugarRecord;

public class Event extends SugarRecord {
	private String date;
	private String time;
	private String url;
	private String plus_event_url;
	private String about;
	private String location;
	private String associate_group;
	
	public Event(Context ctx){
		super(ctx);
	}
	public Event(Context ctx,String _date,String _time,String _url,String _plus_event_url,
				String _about,String _location, String _group){
		super(ctx);
		setDate(_date);
		setDate(_time);
		setUrl(_url);
		setAbout(_about);
		setGroup(_group);
		setLocation(_location);
		setPlus_event_url(_plus_event_url);
		
		
		
	}
	
	//========================
	//otros metodos
	public static void updateEvent(AsyncHttpClient async_client, Context context, int async) {
		HashMap params = new HashMap();
		RequestParams request_params = new RequestParams(params);
		EventUpdateHttpResponseHandler handler = new EventUpdateHttpResponseHandler(context,async);
		async_client.get(Constants.updateEventUrl, request_params,handler);
	}
	
	public static ArrayList<Event> all(){
		ArrayList<Event> events;
		try
		{
			events = (ArrayList<Event>) Event.listAll(Event.class);
		}
		catch(Exception e)
		{
			events = null;
		}
		return events;
	}
	
	public static Event first(){
		ArrayList<Event> events = all();
		if(events != null && events.size()!=0)
			return events.get(0);
		else
			return null;
	}
	
	//========================
	//accesors methods

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPlus_event_url() {
		return plus_event_url;
	}
	public void setPlus_event_url(String plus_event_url) {
		this.plus_event_url = plus_event_url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getGroup() {
		return associate_group;
	}
	public void setGroup(String group) {
		this.associate_group = group;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
