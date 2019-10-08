package events.com.longines.interactors;

import events.com.longines.interfaces.DirectoryInterface;

public class DirectoryModel implements DirectoryInterface.Model {
	private DirectoryInterface.Presenter presenter;

	public DirectoryModel(DirectoryInterface.Presenter presenter) {
		this.presenter = presenter;
	}
}
