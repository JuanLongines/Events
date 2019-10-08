package events.com.longines.interfaces;

import events.com.longines.models.Directory;

public interface DirectoryInterface {
	interface View {
		void OnClickItem(Directory directory);
	}

	interface Model {

	}

	interface Presenter {
		void OnClickItem(Directory directory);
	}
}
