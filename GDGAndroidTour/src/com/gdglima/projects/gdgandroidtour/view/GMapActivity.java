package com.gdglima.projects.gdgandroidtour.view;

import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.R.layout;
import com.gdglima.projects.gdgandroidtour.R.menu;
import com.gdglima.projects.gdgandroidtour.view.maps.FixedMyLocationOverlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.Toast;

public class GMapActivity extends MapActivity {

	private MapView map=null;
	private MapController controlMapa = null;
	private MyLocationOverlay _myLocationOverlay;
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_map);
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		map=(MapView)findViewById(R.id.mapa);
		map.setBuiltInZoomControls(true);//zoom
		map.setSatellite(false);
		
		controlMapa =map.getController();
		
		_myLocationOverlay = new FixedMyLocationOverlay(this, map);
		
		// add this overlay to the MapView and refresh it
		map.getOverlays().add(_myLocationOverlay);
		map.postInvalidate();
		_myLocationOverlay.enableMyLocation();
		zoomToMyLocation();
	}
	
	private void zoomToMyLocation() {
		GeoPoint myLocationGeoPoint = _myLocationOverlay.getMyLocation();
		if(myLocationGeoPoint != null) {
			map.getController().animateTo(myLocationGeoPoint);
			map.getController().setZoom(17);
		}
		else {
			Toast.makeText(this, "Se recomienda activar GPS ", Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_map, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
