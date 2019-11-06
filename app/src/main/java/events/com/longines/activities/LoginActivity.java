package events.com.longines.activities;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.rengwuxian.materialedittext.MaterialEditText;

import events.com.longines.R;
import events.com.longines.core.BaseActivity;
import events.com.longines.core.Injector;
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
    private SharedPref sharedPref;

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
        sharedPref = Injector.provideSharedPref();

    }

    private void setCredentialIfExist() {
        String username = sharedPref.read(Preferences.USERNAME, null);
        String password = sharedPref.read(Preferences.USERPASSWORD, null);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            edit_text_username.setText(username);
            edit_text_userpass.setText(password);
            switch_remember.setChecked(true);
        }
    }

    private void checkPreferences() {
        if (sharedPref.read(Preferences.USERLOGGED, false)) {
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
            sharedPref.write(Preferences.USERLOGGED, true);

            sharedPref.write(Preferences.USERNAME, user);
            sharedPref.write(Preferences.USERPASSWORD, password);
        }
    }
}
