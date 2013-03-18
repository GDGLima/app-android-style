package com.gdglima.projects.gdgandroidtour.view;

import com.gdglima.projects.gdgandroidtour.AndroidTourPeruApplication;
import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.R.layout;
import com.gdglima.projects.gdgandroidtour.R.menu;
import com.gdglima.projects.gdgandroidtour.model.Event;
import com.gdglima.projects.gdgandroidtour.utils.Constants;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.TextView;

public class EventsActivity extends Activity {
	private TextView date_tv;
	private TextView time_tv;
	private TextView description_tv;
	private Event event;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		date_tv = (TextView) findViewById(R.id.date_detail);
		time_tv = (TextView) findViewById(R.id.time_detail);
		description_tv = (TextView) findViewById(R.id.description_detail);
		
		event = Event.first();  
		if (event == null){
			final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    	alertDialog.setTitle("Aviso");
			alertDialog.setMessage(Constants.noEventData);
			alertDialog.setCancelable(false);
			alertDialog.setButton(Dialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
			   public void onClick(DialogInterface dialog, int which) {
				   alertDialog.dismiss();
				   EventsActivity.this.finish();
			   }
			});
			alertDialog.show();
		}
		else{
			date_tv.setText(event.getDate());
			time_tv.setText(event.getTime());
			description_tv.setText(event.getAbout());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_events, menu);
		return true;
	}

}
