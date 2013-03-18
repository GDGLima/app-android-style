package com.gdglima.projects.gdgandroidtour.view;

import java.util.ArrayList;

import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.R.layout;
import com.gdglima.projects.gdgandroidtour.R.menu;
import com.gdglima.projects.gdgandroidtour.adapter.StaffAdapter;
import com.gdglima.projects.gdgandroidtour.model.Staff;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class StaffActivity extends Activity {

	//=========================================
	//declare all items for the activity
	//=========================================
	private TextView staffTitleTv=null;
	private ListView staffLv=null;
	private StaffAdapter staffAdapter=null;
	private ArrayList<Staff> staffArray=null;
	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_staff);
		ctx=StaffActivity.this;
		//=========================================
		//associate items from layout
		//=========================================
		staffLv       = (ListView) findViewById(R.id.staff_list);
		staffTitleTv = (TextView) findViewById(R.id.staff_title);
		
		//=========================================
		//set and load adapter to list view
		//=========================================
		staffArray=(ArrayList<Staff>) Staff.all();
		staffAdapter=new StaffAdapter(this,R.layout.staff_item,staffArray);
		staffLv.setAdapter(staffAdapter);
		staffLv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> array, View item, int pos,
					long arg3) {
				String plus_url = staffArray.get(pos).getPlus_url();
				if(plus_url.contains("htt"))
				{
					Intent go_to_profile = new Intent(Intent.ACTION_VIEW,Uri.parse(plus_url));
					startActivity(go_to_profile);
				}
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_staff, menu);
		return true;
	}

}
