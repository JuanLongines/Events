package events.com.longines.interfaces;

import events.com.longines.models.Setting;

public interface SettingInterface {
	String OPEN_BROWSER = "OPEN_BROWSER";
	String OPEN_INTENT = "OPEN_INTENT";
	String OPEN_SETTINGS = "OPEN_SETTINGS";
	String LOGOUT = "LOGOUT";

	interface View {
		void OnClickItem(Setting setting);
	}

	interface Model {

	}

	interface Presenter {
		void OnClickItem(Setting setting);
	}

	interface CallbackLogout {
		void logout();
	}
}
