package events.com.longines.core;

import android.content.Context;
import android.content.SharedPreferences;

import events.com.longines.BuildConfig;

public class ShatteredPreferencesHelper
// implements Preferences
{

	private final SharedPreferences sharedPreferences;
	public final SharedPreferences.Editor editor;
	private final GsonHelper gsonHelper;
	private Context context;

	public ShatteredPreferencesHelper(Context context) {
		this.context = context;
		this.sharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
		this.editor = sharedPreferences.edit();
		this.gsonHelper = new GsonHelper();
	}

//	@Override
//	public void saveUsername(String username) {
//
//	}
//
//	@Override
//	public String getUsername() {
//		return null;
//	}
//
//	@Override
//	public void clear() {
//		editor.clear();
//		editor.apply();
//	}
}
