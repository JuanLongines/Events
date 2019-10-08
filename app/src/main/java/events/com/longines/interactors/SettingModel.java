package events.com.longines.interactors;

import events.com.longines.interfaces.SettingInterface;

public class SettingModel implements SettingInterface.Model {
	private SettingInterface.Presenter presenter;

	public SettingModel(SettingInterface.Presenter presenter) {
		this.presenter = presenter;
	}
}
