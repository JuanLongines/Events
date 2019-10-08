package events.com.longines.presenters;

import events.com.longines.interactors.DirectoryModel;
import events.com.longines.interfaces.DirectoryInterface;
import events.com.longines.models.Directory;

public class DirectoryPresenter implements DirectoryInterface.Presenter {
	private DirectoryInterface.View view;
	private DirectoryInterface.Model model;

	public DirectoryPresenter(DirectoryInterface.View view) {
		this.view = view;
		this.model = new DirectoryModel(this);
	}

	@Override
	public void OnClickItem(Directory directory) {
		if (view != null) {
			view.OnClickItem(directory);
		}
	}
}
