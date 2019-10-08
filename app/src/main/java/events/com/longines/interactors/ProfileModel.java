package events.com.longines.interactors;

import android.view.MenuItem;

import events.com.longines.R;
import events.com.longines.interfaces.Profile;

public class ProfileModel implements Profile.Model {

	private Profile.Presenter presenter;

	public ProfileModel(Profile.Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void menuOption(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.logout:
//			presenter.logout();
			break;
		default:
		}
	}

	@Override
	public void clickItem(int item) {
		switch (item) {
		case R.id.fab:
			presenter.openCamera();
			break;
		}
	}

}
