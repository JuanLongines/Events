package events.com.longines.fragments;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import events.com.longines.R;
import events.com.longines.adapters.EventAdapter;
import events.com.longines.interfaces.EventInterface;
import events.com.longines.interfaces.Main;
import events.com.longines.models.Event;
import events.com.longines.presenters.EventPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements EventInterface.View {
	private RecyclerView recyclerView;
	private List<Event> list;
	private EventAdapter adapter;
	private Main.CallbackEventSelected callbackEventSelected;
	private EventInterface.Presenter presenter;

	public EventFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_event, container, false);
		bindUI(view);
		return view;
	}

	private void bindUI(View view) {

		presenter = new EventPresenter(this);

		Event e1 = new Event(1, "Evento 1",
				"https://laverdadnoticias.com/__export/1567342087803/sites/laverdad/img/2019/09/01/horoscopo_chino_1.png_793492074.png",
				"2019/09/01", 1);
		Event e2 = new Event(2, "Evento 2",
				"https://www.eldesconcierto.cl/wp-content/uploads/2019/09/Jornada-de-protesta-feminista-11-de-septiembre.jpeg",
				"2019/09/01", 1);
		Event e3 = new Event(3, "Evento 3",
				"https://www.dondehayferia.com/sites/default/files/imagenes_eventos/grito-independencia-2019-naucalpan-edomex-cardenales-poder-fiestas-patrias-viva-mexico-noche-mexicana-15-septiembre.jpg",
				"2019/09/01", 1);
		Event e4 = new Event(4, "Evento 4",
				"http://fiestashard.es/wp-content/uploads/2019/09/Fabrik-150-edición-septiembre-1.jpg", "2019/09/01",
				1);
		Event e5 = new Event(5, "Evento 5",
				"https://cdn.wegow.com/media/venues/ibiza-sun-dance/ibiza-sun-dance-1558526855.42.430x241.jpg",
				"2019/09/01", 1);

		list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		recyclerView = view.findViewById(R.id.reciclerview_events);
		adapter = new EventAdapter(list, presenter);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try {
			if (callbackEventSelected == null) {
				this.callbackEventSelected = (Main.CallbackEventSelected) context;
			}
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " should implement DataListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		this.callbackEventSelected = null;
	}

	@Override
	public void OnClickItem(Event event) {
		callbackEventSelected.getEvent(event);
	}
}
