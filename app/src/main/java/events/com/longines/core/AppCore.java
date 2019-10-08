package events.com.longines.core;

import android.app.Application;
import android.content.Intent;

import events.com.longines.activities.MainActivity;
import events.com.longines.interfaces.Preferences;

public class AppCore extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		SharedPref.init(getApplicationContext());
		if (SharedPref.read(Preferences.USERLOGGED, false)) {
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
		}

	}
}
