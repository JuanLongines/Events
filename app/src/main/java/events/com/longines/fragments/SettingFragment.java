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
import events.com.longines.adapters.SettingAdapter;
import events.com.longines.interfaces.Main;
import events.com.longines.interfaces.SettingInterface;
import events.com.longines.models.Setting;
import events.com.longines.presenters.SettingPresenter;

public class SettingFragment extends Fragment implements SettingInterface.View {

	private RecyclerView recyclerViewSettings;
	private List<Setting> list;
	private SettingAdapter adapter;
	private SettingInterface.View view;
	private SettingPresenter presenter;
	private Main.CallbackSettingSelected callbackSettingSelected;

	public SettingFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_setting, container, false);
		bindUI(view);

		return view;
	}

	private void bindUI(View view) {

		presenter = new SettingPresenter(this);

		Setting s1 = new Setting(1, "Aviso de privacidad", SettingInterface.OPEN_BROWSER, "https://www.google.com.mx",
				1);
		Setting s2 = new Setting(2, "Terminos y condiciones", SettingInterface.OPEN_BROWSER, "http://www.yahoo.com.mx",
				1);
		Setting s3 = new Setting(3, "Editar Cuenta", SettingInterface.OPEN_INTENT, "", 1);
		Setting s4 = new Setting(4, "Permisos", SettingInterface.OPEN_SETTINGS, "", 1);
		Setting s5 = new Setting(5, "Cerrar Sesión", SettingInterface.LOGOUT, "", 1);
		list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		recyclerViewSettings = view.findViewById(R.id.reciclerview_settings);
		adapter = new SettingAdapter(list, presenter);
		recyclerViewSettings.setHasFixedSize(true);
		recyclerViewSettings.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerViewSettings.setAdapter(adapter);

	}

	@Override
	public void OnClickItem(Setting setting) {
		callbackSettingSelected.getSetting(setting);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try {
			if (callbackSettingSelected == null) {
				this.callbackSettingSelected = (Main.CallbackSettingSelected) context;
			}
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " should implement DataListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		this.callbackSettingSelected = null;
	}
}
