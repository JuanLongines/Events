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
import events.com.longines.interfaces.DirectoryInterface;
import events.com.longines.models.Directory;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.ViewHolder> {

	private List<Directory> list_item;
	private DirectoryInterface.Presenter presenter;

	public DirectoryAdapter(List<Directory> list_item, DirectoryInterface.Presenter presenter) {
		this.list_item = list_item;
		this.presenter = presenter;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.item_directory, parent, false);
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
		private TextView textViewName;
		private ImageView imageViewDirectory;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			textViewName = itemView.findViewById(R.id.textViewName);
			imageViewDirectory = itemView.findViewById(R.id.imageViewDirectory);
		}

		void bind(final Directory directory) {
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					presenter.OnClickItem(directory);
				}
			});

			textViewName.setText(directory.getName() + " " + directory.getLastname());
			Picasso.get().load(directory.getUrl_image()).transform(new CropCircleTransformation())
					.into(imageViewDirectory);
		}
	}
}
