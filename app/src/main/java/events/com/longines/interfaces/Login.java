package events.com.longines.interfaces;

public interface Login {
	interface View extends BaseView {
		void showLoading();

		void hideLoading();

		void showMessage(String message);

		void showUserError(String message);

		void showPasswordError(String message);

//		void doLogin(String username, String password);

//		void gotoPlace(Bundle bundle);
	}

	interface Model {
		boolean doLogin(String user, String pass);
	}

	interface Presenter {
		boolean doLogin(String user, String pass);

		void showMessage(String message);

		void showUserError(String message);

		void showPasswordError(String message);

	}
}
