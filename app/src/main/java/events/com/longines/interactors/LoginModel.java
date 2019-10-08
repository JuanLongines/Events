package events.com.longines.interactors;

import android.text.TextUtils;
import android.util.Patterns;

import events.com.longines.interfaces.Login;

public class LoginModel implements Login.Model {
	private Login.Presenter presenter;

	public LoginModel(Login.Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public boolean doLogin(String user, String pass) {
		if (!isValidEmail(user)) {
			presenter.showUserError("Email is not valid, please try again");
			return false;
		} else if (!isValidPassword(pass)) {
			presenter.showPasswordError("Password required 6 characters minimun ");
			return false;
		} else {
			return true;
		}
	}

	private boolean isValidEmail(String email) {
		return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	private boolean isValidPassword(String password) {
		return !TextUtils.isEmpty(password) && password.length() >= 5;
	}
}
