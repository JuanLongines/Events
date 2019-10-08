package events.com.longines.fragments;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import events.com.longines.R;
import events.com.longines.core.L;
import events.com.longines.interfaces.Main;
import events.com.longines.interfaces.Profile;
import events.com.longines.presenters.ProfilePresenter;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements Profile.View, Main.CallbackPhoto, View.OnClickListener {

	private ProfilePresenter presenter;

//	private Main.View listener;
	private Main.View listenerCamera;
	private FloatingActionButton fab;
	ImageView img_profile;

	public ProfileFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_profile, container, false);
		setHasOptionsMenu(true);

		presenter = new ProfilePresenter(this);
		bindUI(view);

		return view;
	}

	private void bindUI(View view) {
		img_profile = view.findViewById(R.id.img_profile);

		fab = view.findViewById(R.id.fab);
		fab.setOnClickListener(this);
		presenter.loadDefaultImage(
				"http://fc07.deviantart.net/fs71/f/2015/057/2/e/resident_evil__revelations_2_v1_by_piratemartin-d8jl24a.png");
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_profile, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		presenter.menuOption(item);
		return super.onOptionsItemSelected(item);
	}

//	@Override
//	public void logout() {
//		L.i("logout");
//		listener.logout();
//	}

	@Override
	public void openCamera() {
		listenerCamera.openCamera();
	}

	@Override
	public void changePhoto(Uri uri_photo) {
		Picasso.get().load(uri_photo).transform(new CropCircleTransformation()).into(img_profile);
	}

	@Override
	public void loadDefaultImage(String url) {
		Picasso.get().load(url).transform(new CropCircleTransformation()).into(img_profile);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try {
//			if (listener == null) {
//				this.listener = (Main.View) context;
//			}
			if (listenerCamera == null) {
				this.listenerCamera = (Main.View) context;
			}
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " should implement DataListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
//		this.listener = null;
		this.listenerCamera = null;
	}

	@Override
	public void onClick(View item) {
		presenter.clickItem(item.getId());
	}

	@Override
	public void setPhotoData(Uri uri_photo) {
		L.i("data photo from main");
		presenter.changePhoto(uri_photo);

	}

}
