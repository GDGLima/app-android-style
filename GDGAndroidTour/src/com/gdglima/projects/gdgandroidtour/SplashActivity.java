package com.gdglima.projects.gdgandroidtour;

import java.util.Timer;
import java.util.TimerTask;

import com.gdglima.projects.gdgandroidtour.model.Configuration;
import com.gdglima.projects.gdgandroidtour.model.Event;
import com.gdglima.projects.gdgandroidtour.model.Staff;
import com.gdglima.projects.gdgandroidtour.utils.Constants;
import com.loopj.android.http.AsyncHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class SplashActivity extends Activity {
    private long splashDelay = 1500;
    private ProgressDialog progress_dialog;
    private Context context;
    private boolean dismiss = false;
    private Timer timer;
    private TimerTask go_home_sync_task;
    private TimerTask go_home_async_task;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	init(savedInstanceState);
    	
    	go_home_sync_task = new TimerTask() {
    		@Override
            public void run() {
    			if(dismiss)
    				goToHome();
            }
        };
        go_home_async_task = new TimerTask() {
            @Override
            public void run() {
            	progress_dialog.dismiss();
           		goToHome();
            }
        };
         timer = new Timer();
       	if (Configuration.checkVersion(context)==0)
        {
        	dismiss=false;
        	progress_dialog= ProgressDialog.show(context, Constants.app_name, Constants.sync_data);
        	syncData(0);
        	
        }
        else
        {
        	dismiss=true;
        	syncData(1);
        }
       	timer.schedule(go_home_sync_task, splashDelay);
    }

    private void syncData(int async)
    {
    	Staff.updateStaff(((AndroidTourPeruApplication)getApplication()).getAsync_client(),context,1);
    	Event.updateEvent(((AndroidTourPeruApplication)getApplication()).getAsync_client(), context,1);
    	Configuration.setVersion(context,"1");
    	if (async==0)
    		syncCallback();
    }
    
    private void syncCallback()
    {
    	timer.schedule(go_home_async_task, splashDelay);
    }
    
    private void goToHome()
    {
        Intent nextActivity;
        nextActivity = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(nextActivity);
        finish();
    }
	private void init(Bundle savedInstanceState) {
		//screen init
		//=====================================================================================
	    super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.activity_splash);
	    context = this;
	    //=====================================================================================
	}
}


