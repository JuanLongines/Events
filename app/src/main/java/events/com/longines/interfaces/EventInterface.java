package events.com.longines.interfaces;

import events.com.longines.models.Event;

public interface EventInterface {

	interface View {
		void OnClickItem(Event event);
	}

	interface Model {

	}

	interface Presenter {
		void OnClickItem(Event event);
	}
}
