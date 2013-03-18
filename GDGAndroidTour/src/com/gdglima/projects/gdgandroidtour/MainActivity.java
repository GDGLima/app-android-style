package com.gdglima.projects.gdgandroidtour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.model.Event;
import com.gdglima.projects.gdgandroidtour.view.EventsActivity;
import com.gdglima.projects.gdgandroidtour.view.StaffActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button staffBtn;
	private Button eventBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        staffBtn=(Button)findViewById(R.id.btnUser);
        eventBtn=(Button)findViewById(R.id.btnAndroid);
        
        staffBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goToStaffView= new Intent(MainActivity.this.getBaseContext(),StaffActivity.class);
				startActivity(goToStaffView);
			}
		});
        
        eventBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goToEventView= new Intent(MainActivity.this.getBaseContext(),EventsActivity.class);
				startActivity(goToEventView);
			}
		});
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	Log.d("resume","resume");
    	if (Event.first()==null){
    		Log.d("resume","enters");
         	Event.updateEvent(((AndroidTourPeruApplication)getApplication()).getAsync_client(),MainActivity.this, 1);
         }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
