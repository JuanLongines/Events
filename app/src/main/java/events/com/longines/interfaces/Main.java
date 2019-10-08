package events.com.longines.interfaces;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import events.com.longines.models.Directory;
import events.com.longines.models.Event;
import events.com.longines.models.Setting;

public interface Main {
	interface View {
		void logout();

		boolean loadFragment(Fragment fragment);

		void setTitleFragment(MenuItem item);

		void openCamera();

		void goToSettingPermission();

		void goToEditProfile();

		void openBrowser(String url);
	}

	interface Model {

		boolean navigationItem(MenuItem item);

	}

	interface Presenter {

		boolean navigationItem(MenuItem item);

		boolean loadFragment(Fragment fragment);

		void setTitleFragment(MenuItem item);

		void logout();

		void goToSettingPermission();

		void goToEditProfile();

		void openBrowser(String url);
	}

	interface CallbackPhoto {
		void setPhotoData(Uri uri_photo);
	}

	interface CallbackSettingSelected {
		void getSetting(Setting setting);
	}

	interface CallbackEventSelected {
		void getEvent(Event event);
	}

	interface CallbackDirectorySelected {
		void getDirectory(Directory directory);
	}

}
