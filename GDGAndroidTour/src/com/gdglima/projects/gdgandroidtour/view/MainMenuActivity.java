package com.gdglima.projects.gdgandroidtour.view;

import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.R.layout;
import com.gdglima.projects.gdgandroidtour.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}

}
