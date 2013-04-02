package com.gdglima.projects.gdgandroidtour;

import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.view.GMapActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnShare,btnCamera, btnMaps, btnEvent, btnCollaborators;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main_menu);
        
        app();
    }

    private void app() {
		// TODO Auto-generated method stub
		btnShare=(Button)findViewById(R.id.btnLike);
		btnCamera=(Button)findViewById(R.id.btnCamera);
		btnCollaborators=(Button)findViewById(R.id.btnUser);
		btnEvent=(Button)findViewById(R.id.btnAndroid);
		btnMaps=(Button)findViewById(R.id.btnMaps);
		
		btnShare.setOnClickListener(this);
		btnEvent.setOnClickListener(this);
		btnMaps.setOnClickListener(this);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnLike:
				shareGplus();
			break;
		case R.id.btnMaps:
			goMaps();
		break;
		default:
			break;
		}
	}

	private void goMaps() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this, GMapActivity.class);
		startActivity(intent);
	}

	private void shareGplus() {
		// TODO Auto-generated method stub
		Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
				   .setText("Participando en el Android Lima Day http://gdgandroidtour.gdglima.org/")
				   .setType("text/plain")
				   .getIntent()
				   .setPackage("com.google.android.apps.plus");

		startActivity(shareIntent);
	}
    
}
