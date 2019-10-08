package events.com.longines.presenters;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import events.com.longines.interactors.MainModel;
import events.com.longines.interfaces.Main;

public class MainPresenter implements Main.Presenter {

	private Main.View view;
	private Main.Model model;

	public MainPresenter(Main.View view) {
		this.view = view;
		this.model = new MainModel(this);
	}

	@Override
	public boolean navigationItem(MenuItem item) {
		if (view != null) {
			return model.navigationItem(item);
		}
		return false;

	}

	@Override
	public boolean loadFragment(Fragment fragment) {
		if (view != null) {
			return view.loadFragment(fragment);
		}
		return false;
	}

	@Override
	public void setTitleFragment(MenuItem item) {
		if (view != null) {
			view.setTitleFragment(item);
		}
	}

	@Override
	public void logout() {
		if (view != null) {
			view.logout();
		}
	}

	@Override
	public void goToSettingPermission() {
		if (view != null) {
			view.goToSettingPermission();
		}
	}

	@Override
	public void goToEditProfile() {
		if (view != null) {
			view.goToEditProfile();
		}
	}

	@Override
	public void openBrowser(String url) {
		if (view != null) {
			view.openBrowser(url);
		}
	}

}
