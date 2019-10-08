package events.com.longines.activities;

import java.io.ByteArrayOutputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import events.com.longines.R;
import events.com.longines.core.BaseActivity;
import events.com.longines.core.L;
import events.com.longines.core.SharedPref;
import events.com.longines.fragments.ProfileFragment;
import events.com.longines.interfaces.Main;
import events.com.longines.interfaces.SettingInterface;
import events.com.longines.models.Directory;
import events.com.longines.models.Event;
import events.com.longines.models.Setting;
import events.com.longines.presenters.MainPresenter;

public class MainActivity extends BaseActivity
		implements Main.View, Main.CallbackSettingSelected, Main.CallbackEventSelected, Main.CallbackDirectorySelected,
		BottomNavigationView.OnNavigationItemSelectedListener {

	private MainPresenter presenter;
	private Main.CallbackPhoto callbackPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindUI();
		setToolbar();
		presenter = new MainPresenter(this);
		SharedPref.init(getApplicationContext());

		if (savedInstanceState == null) {
			loadFragment(new ProfileFragment());
		}

	}

	private void setToolbar() {
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}

	private void bindUI() {
		BottomNavigationView navigation = findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(this);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.menu_profile, menu);
//		return super.onCreateOptionsMenu(menu);
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		presenter.menuOption(item);
//		return super.onOptionsItemSelected(item);
//	}

	@Override
	public void logout() {
		SharedPref.clear();
		next(LoginActivity.class);
	}

	@Override
	public boolean loadFragment(Fragment fragment) {
		if (fragment != null) {
			if (fragment instanceof ProfileFragment) {
				callbackPhoto = (Main.CallbackPhoto) fragment;
			}
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
			return true;
		}
		return false;
	}

	@Override
	public void setTitleFragment(MenuItem item) {
		getSupportActionBar().setTitle(item.getTitle());
	}

	@Override
	public void openCamera() {
		L.i("Abriendo camera");
		Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(camera_intent, 100);
	}

	@Override
	public void goToSettingPermission() {
		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setData(Uri.fromParts("package", getPackageName(), null));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		startActivity(intent);
	}

	@Override
	public void goToEditProfile() {
		Bundle bundle = new Bundle();
		bundle.putString("key", "Prueba");
		next(bundle, EditProfileActivity.class);
	}

	@Override
	public void openBrowser(String url) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		startActivity(intent);
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
		return presenter.navigationItem(menuItem);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 100:
			if (resultCode == RESULT_OK) {
				L.i("Foto tomada con la camara");
				Bitmap photo = (Bitmap) data.getExtras().get("data");
				if (photo != null) {
					callbackPhoto.setPhotoData(getImageUri(photo));
				}

			}
			break;
		}
	}

	private Uri getImageUri(Bitmap photo) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		photo.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
		String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), photo,
				"ProfileImage", null);
		return Uri.parse(path);
	}

	@Override
	public void getSetting(Setting setting) {
		L.i("Setting click item from SettingFragment");
		switch (setting.getAccion()) {
		case SettingInterface.OPEN_BROWSER:
			presenter.openBrowser(setting.getAtributte());
			break;
		case SettingInterface.OPEN_INTENT:
			presenter.goToEditProfile();
			break;
		case SettingInterface.OPEN_SETTINGS:
			presenter.goToSettingPermission();
			break;
		case SettingInterface.LOGOUT:
			presenter.logout();
			break;
		}

	}

	@Override
	public void getEvent(Event event) {
		Toast.makeText(getApplicationContext(), event.getId() + "\n" + event.getDate() + "\n" + event.getTitle(),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void getDirectory(Directory directory) {
		Toast.makeText(getApplicationContext(),
				directory.getId() + "\n" + directory.getName() + "\n" + directory.getLastname(), Toast.LENGTH_SHORT)
				.show();
	}
}
