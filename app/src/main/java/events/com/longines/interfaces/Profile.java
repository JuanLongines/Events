package events.com.longines.interfaces;

import android.net.Uri;
import android.view.MenuItem;

public interface Profile {
	interface View {
//		void logout();

		void openCamera();

		void changePhoto(Uri photo);

		void loadDefaultImage(String url);

	}

	interface Model {

		void menuOption(MenuItem item);

		void clickItem(int item);

	}

	interface Presenter {

		void menuOption(MenuItem item);

		void loadDefaultImage(String url);

		void clickItem(int item);

		void openCamera();

		void changePhoto(Uri photo);

//		void logout();
	}

}
