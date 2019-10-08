package events.com.longines.presenters;

import events.com.longines.interactors.LoginModel;
import events.com.longines.interfaces.Login;

public class LoginPresenter implements Login.Presenter {

	private Login.View view;
	private Login.Model model;

	public LoginPresenter(Login.View view) {
		this.view = view;
		this.model = new LoginModel(this);
	}

	@Override
	public boolean doLogin(String user, String pass) {
		if (view != null) {
			return model.doLogin(user, pass);
		} else {
			return false;
		}
	}

	@Override
	public void showMessage(String message) {
		if (view != null) {
			view.showMessage(message);
		}
	}

	@Override
	public void showUserError(String message) {
		if (view != null) {
			view.showUserError(message);
		}
	}

	@Override
	public void showPasswordError(String message) {
		if (view != null) {
			view.showPasswordError(message);
		}
	}
}
