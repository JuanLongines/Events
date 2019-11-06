package events.com.longines.core;

import android.app.Application;

public class Injector {

    private static SharedPref sharedPref;

    public static void setup(Application application) {
        sharedPref = SharedPref.getInstance(application);
    }

    public static SharedPref provideSharedPref() {
        return sharedPref;
    }
}
