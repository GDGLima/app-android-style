package com.gdglima.projects.gdgandroidtour.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import android.content.Context;

import com.gdglima.projects.gdgandroidtour.handler.StaffUpdateHttpResponseHandler;
import com.gdglima.projects.gdgandroidtour.utils.Constants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.orm.SugarRecord;

public class Staff extends SugarRecord {
	private String plus_username;
	private String plus_image;
	private String plus_email;
	private String plus_url;
	private String plus_bio;
	
	public Staff(Context ctx){
		super(ctx);
	}
	public Staff(Context ctx,String _username,String _image,String _email,String _url,String _bio){
		super(ctx);
		setPlus_username(_username);
		setPlus_image(_image);
		setPlus_email(_email);
		setPlus_bio(_bio);
		setPlus_url(_url);
		
		
	}
	
	//========================
	//otros metodos
	public static void updateStaff(AsyncHttpClient async_client, Context context, int async) {
		HashMap params = new HashMap();
		RequestParams request_params = new RequestParams(params);
		StaffUpdateHttpResponseHandler handler = new StaffUpdateHttpResponseHandler(context,async);
		async_client.get(Constants.updateStaffUrl, request_params,handler);
	}
	
	public static ArrayList<Staff> all(){
		ArrayList<Staff> staff_list;
		try
		{
			staff_list = (ArrayList<Staff>) Staff.listAll(Staff.class);
		}
		catch(Exception e)
		{
			staff_list = null;
		}
		return staff_list;
	}
	
	public static Staff first(){
		ArrayList<Staff> staff_list = all();
		if(staff_list != null && staff_list.size()!=0)
			return staff_list.get(0);
		else
			return null;
	}
	
	//========================
	//accesors methods

	public String getPlus_username() {
		return plus_username;
	}

	public void setPlus_username(String plus_username) {
		this.plus_username = plus_username;
	}

	public String getPlus_image() {
		return plus_image;
	}

	public void setPlus_image(String plus_image) {
		this.plus_image = plus_image;
	}

	public String getPlus_email() {
		return plus_email;
	}

	public void setPlus_email(String plus_email) {
		this.plus_email = plus_email;
	}

	public String getPlus_url() {
		return plus_url;
	}

	public void setPlus_url(String plus_url) {
		this.plus_url = plus_url;
	}

	public String getPlus_bio() {
		return plus_bio;
	}

	public void setPlus_bio(String plus_bio) {
		this.plus_bio = plus_bio;
	}

}
