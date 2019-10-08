package events.com.longines.adapters;

import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import events.com.longines.R;
import events.com.longines.interfaces.SettingInterface;
import events.com.longines.models.Setting;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder> {

	private List<Setting> list_item;
	private SettingInterface.Presenter presenter;

	public SettingAdapter(List<Setting> list_item, SettingInterface.Presenter presenter) {
		this.list_item = list_item;
		this.presenter = presenter;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.item_setting, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.bind(list_item.get(position), presenter);
	}

	@Override
	public int getItemCount() {
		return list_item == null ? 0 : list_item.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		TextView textViewTitleSetting;

		ViewHolder(@NonNull View itemView) {
			super(itemView);
			textViewTitleSetting = itemView.findViewById(R.id.textViewTitleSetting);
		}

		void bind(final Setting setting, final SettingInterface.Presenter presenter) {
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					presenter.OnClickItem(setting);
				}
			});

			textViewTitleSetting.setText(setting.getTitle());

		}
	}
}
