package events.com.longines.core;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    //	private static SharedPreferences mSharedPref;
    private static SharedPref instance;
    private SharedPreferences mSharedPref;
    private Context appContext;

    private SharedPref() {

    }

    private SharedPref(Context applicationContext) {
        appContext = applicationContext;
        mSharedPref = appContext.getSharedPreferences(appContext.getPackageName(), Context.MODE_PRIVATE);
    }

    public static synchronized SharedPref getInstance(Context applicationContext) {
        if (instance == null)
            instance = new SharedPref(applicationContext);
        return instance;
    }

    //	public static void init(Context context) {
//		if (mSharedPref == null)
//			mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
//	}
//
    public String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).apply();
    }

    public void clear() {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.clear();
        prefsEditor.apply();
    }


}
