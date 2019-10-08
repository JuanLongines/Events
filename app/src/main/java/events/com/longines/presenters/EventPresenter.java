package events.com.longines.presenters;

import events.com.longines.interactors.EventModel;
import events.com.longines.interfaces.EventInterface;
import events.com.longines.models.Event;

public class EventPresenter implements EventInterface.Presenter {

	private EventInterface.View view;
	private EventInterface.Model model;

	public EventPresenter(EventInterface.View view) {
		this.view = view;
		this.model = new EventModel(this);
	}

	@Override
	public void OnClickItem(Event event) {
		if (view != null) {
			view.OnClickItem(event);
		}
	}
}
