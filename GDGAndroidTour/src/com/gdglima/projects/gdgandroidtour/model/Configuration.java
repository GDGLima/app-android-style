package com.gdglima.projects.gdgandroidtour.model;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.orm.SugarRecord;

public class Configuration  extends SugarRecord {
	
	private String key;
	private String value;
	public Configuration(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public Configuration(Context ctx,String _key,String _value){
		super(ctx);
		setKey(_key);
		setValue(_value);
	}
	
	//=================================
	//accessors methods
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	//=================================
	//custom methods

	public static int checkVersion(Context ctx) {
		int version = 0;
		Configuration version_config;
		Log.d("sdsds",Configuration.getTableName(Configuration.class));
		if (Configuration.all().size()==0){
			version_config=new Configuration(ctx, "version","0");
			version_config.save();
	    }
		version = Integer.parseInt(Configuration.all().get(0).getValue());
		return version;
	}
	
	public static void setVersion(Context ctx,String version) {
   		Configuration config = Configuration.all().get(0);
   		config.value="1";
   		config.save();
    }
	
	//=================================
	//other methods
	public static ArrayList<Configuration> all(){
		return (ArrayList<Configuration>) Configuration.listAll(Configuration.class);
	}
}
