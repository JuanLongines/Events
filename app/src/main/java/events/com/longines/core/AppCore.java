package events.com.longines.core;

import android.app.Application;
import android.content.Intent;

import events.com.longines.activities.MainActivity;
import events.com.longines.interfaces.Preferences;

public class AppCore extends Application {
    SharedPref sharedPref;

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.setup(this);
        sharedPref = Injector.provideSharedPref();
        if (sharedPref.read(Preferences.USERLOGGED, false)) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}
