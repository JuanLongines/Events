package events.com.longines.adapters;

import java.util.List;

import com.squareup.picasso.Picasso;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import events.com.longines.R;
import events.com.longines.interfaces.EventInterface;
import events.com.longines.models.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

	private List<Event> list_item;
	private EventInterface.Presenter presenter;

	public EventAdapter(List<Event> list_item, EventInterface.Presenter presenter) {
		this.list_item = list_item;
		this.presenter = presenter;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.item_event, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.bind(list_item.get(position));
	}

	@Override
	public int getItemCount() {
		return list_item == null ? 0 : list_item.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private TextView textViewDate, textViewTitle;
		private ImageView imageViewEvent;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			textViewDate = itemView.findViewById(R.id.textViewDate);
			textViewTitle = itemView.findViewById(R.id.textViewTitle);
			imageViewEvent = itemView.findViewById(R.id.imageViewEvent);
		}

		void bind(final Event event) {
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					presenter.OnClickItem(event);
				}
			});

			textViewTitle.setText(event.getTitle());
			textViewDate.setText(event.getDate());
			Picasso.get().load(event.getUrl_image()).fit().centerCrop().into(imageViewEvent);
		}
	}
}
