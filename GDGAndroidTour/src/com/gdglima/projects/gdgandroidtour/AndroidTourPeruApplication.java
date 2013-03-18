package com.gdglima.projects.gdgandroidtour;

import com.loopj.android.http.AsyncHttpClient;
import com.novoda.imageloader.core.ImageManager;
import com.novoda.imageloader.core.LoaderSettings;
import com.novoda.imageloader.core.LoaderSettings.SettingsBuilder;
import com.orm.SugarApp;

import android.app.Application;

public class AndroidTourPeruApplication extends SugarApp{
	private static ImageManager imageManager;
	private static AsyncHttpClient async_client = new AsyncHttpClient();
	@Override
	public void onCreate() {
	    super.onCreate();
	    LoaderSettings settings = new SettingsBuilder().withDisconnectOnEveryCall(true).withConnectionTimeout(30000).build(this);
	    setImageManager(new ImageManager(this, settings));
	}

	public final ImageManager getImageManager() {
	    return imageManager;
	}

	public  void setImageManager(ImageManager imageManager) {
		AndroidTourPeruApplication.imageManager = imageManager;
	}

	public final AsyncHttpClient getAsync_client() {
		return async_client;
	}

	public static void setAsync_client(AsyncHttpClient async_client) {
		AndroidTourPeruApplication.async_client = async_client;
	}
}
