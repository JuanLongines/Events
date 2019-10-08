package events.com.longines.interactors;

import events.com.longines.interfaces.EventInterface;

public class EventModel implements EventInterface.Model {
	private EventInterface.Presenter presenter;

	public EventModel(EventInterface.Presenter presenter) {
		this.presenter = presenter;
	}

}
