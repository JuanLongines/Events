package events.com.longines.presenters;

import events.com.longines.interactors.SettingModel;
import events.com.longines.interfaces.SettingInterface;
import events.com.longines.models.Setting;

public class SettingPresenter implements SettingInterface.Presenter {

	private SettingInterface.View view;
	private SettingInterface.Model model;

	public SettingPresenter(SettingInterface.View view) {
		this.view = view;
		this.model = new SettingModel(this);
	}

	@Override
	public void OnClickItem(Setting setting) {
		if (view != null) {
			view.OnClickItem(setting);
		}
	}
}
