package events.com.longines.presenters;

import android.net.Uri;
import android.view.MenuItem;

import events.com.longines.interactors.ProfileModel;
import events.com.longines.interfaces.Profile;

public class ProfilePresenter implements Profile.Presenter {

	private Profile.View view;
	private Profile.Model model;

	public ProfilePresenter(Profile.View view) {
		this.view = view;
		this.model = new ProfileModel(this);
	}

	@Override
	public void menuOption(MenuItem item) {
		if (view != null) {
			model.menuOption(item);
		}
	}

	@Override
	public void loadDefaultImage(String url) {
		if (view != null) {
			view.loadDefaultImage(url);
		}
	}

	@Override
	public void clickItem(int item) {
		if (view != null) {
			model.clickItem(item);
		}
	}

	@Override
	public void openCamera() {
		if (view != null) {
			view.openCamera();
		}
	}

	@Override
	public void changePhoto(Uri uri_photo) {
		if (view != null) {
			view.changePhoto(uri_photo);
		}
	}

//	@Override
//	public void logout() {
//		if (view != null) {
//			view.logout();
//		}
//	}
}
