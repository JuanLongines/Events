package events.com.longines.activities;

import com.rengwuxian.materialedittext.MaterialEditText;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import events.com.longines.R;
import events.com.longines.core.BaseActivity;
import events.com.longines.core.SharedPref;
import events.com.longines.interfaces.Login;
import events.com.longines.interfaces.Preferences;
import events.com.longines.presenters.LoginPresenter;

public class LoginActivity extends BaseActivity implements Login.View, View.OnClickListener {

	private LoginPresenter presenter;
	private Button button_login;
	private Switch switch_remember;
	private MaterialEditText edit_text_username;
	private MaterialEditText edit_text_userpass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		bindUI();
		checkPreferences();
		setCredentialIfExist();
	}

	private void bindUI() {
		switch_remember = findViewById(R.id.switch_rememberme);
		edit_text_username = findViewById(R.id.edit_text_username);
		edit_text_userpass = findViewById(R.id.edit_text_userpass);
		button_login = findViewById(R.id.button_login);
		button_login.setOnClickListener(this);
		presenter = new LoginPresenter(this);
		SharedPref.init(getApplicationContext());

	}

	private void setCredentialIfExist() {
		String username = SharedPref.read(Preferences.USERNAME, null);
		String password = SharedPref.read(Preferences.USERPASSWORD, null);
		if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
			edit_text_username.setText(username);
			edit_text_userpass.setText(password);
			switch_remember.setChecked(true);
		}
	}

	private void checkPreferences() {
		if (SharedPref.read(Preferences.USERLOGGED, false)) {
			next(MainActivity.class, true);
			finish();
		}
	}

	@Override
	public void showLoading() {

	}

	@Override
	public void hideLoading() {

	}

	@Override
	public void showMessage(String message) {
		showToast(message);
	}

	@Override
	public void showUserError(String message) {
		edit_text_username.setError(message);
	}

	@Override
	public void showPasswordError(String message) {
		edit_text_userpass.setError(message);
	}

//	@Override
//	public void doLogin(String username, String password) {
//		presenter.doLogin(username, password);
//	}

	@Override
	public Context getContext() {
		return this;
	}

	@Override
	public void onClick(View item) {
		switch (item.getId()) {
		case R.id.button_login:
			String user = edit_text_username.getText().toString().trim();
			String password = edit_text_userpass.getText().toString().trim();
			if (presenter.doLogin(user, password)) {
				next(MainActivity.class);
				saveOnPreferences(user, password);
			}
			break;
		}
	}

	private void saveOnPreferences(String user, String password) {
		if (switch_remember.isChecked()) {
			SharedPref.write(Preferences.USERLOGGED, true);

			SharedPref.write(Preferences.USERNAME, user);
			SharedPref.write(Preferences.USERPASSWORD, password);
		}
	}
}
