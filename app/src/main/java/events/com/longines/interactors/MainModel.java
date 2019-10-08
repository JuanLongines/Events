package events.com.longines.interactors;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import events.com.longines.R;
import events.com.longines.fragments.DirectoryFragment;
import events.com.longines.fragments.EventFragment;
import events.com.longines.fragments.ProfileFragment;
import events.com.longines.fragments.SettingFragment;
import events.com.longines.interfaces.Main;

public class MainModel implements Main.Model {
	private Main.Presenter presenter;

	public MainModel(Main.Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public boolean navigationItem(MenuItem item) {
		Fragment fragment = null;
		switch (item.getItemId()) {
		case R.id.navigation_profile:
			fragment = new ProfileFragment();
			break;
		case R.id.navigation_directory:
			fragment = new DirectoryFragment();
			break;
		case R.id.navigation_event:
			fragment = new EventFragment();
			break;
		case R.id.navigation_setting:
			fragment = new SettingFragment();
			break;
		}
		presenter.setTitleFragment(item);
		return presenter.loadFragment(fragment);
	}
}
