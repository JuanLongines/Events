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
import events.com.longines.adapters.DirectoryAdapter;
import events.com.longines.interfaces.DirectoryInterface;
import events.com.longines.interfaces.Main;
import events.com.longines.models.Directory;
import events.com.longines.presenters.DirectoryPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DirectoryFragment extends Fragment implements DirectoryInterface.View {
	private RecyclerView recyclerView;
	private List<Directory> list;
	private DirectoryAdapter adapter;
	private Main.CallbackDirectorySelected callbackDirectorySelected;
	private DirectoryInterface.Presenter presenter;

	public DirectoryFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_directory, container, false);
		initData();
		bindUI(view);
		return view;
	}

	private void initData() {
		presenter = new DirectoryPresenter(this);
		Directory d1 = new Directory(1,
				"https://linksys.i.lithium.com/t5/image/serverpage/image-id/17360i094A9CC74F39EE12/image-size/original?v=1.0&px=-1",
				"Juan", "Longines", 1, "Owner", 1);
		Directory d2 = new Directory(2,
				"https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg-760x506.jpg",
				"Martha", "Contreras", 2, "Owner", 1);
		Directory d3 = new Directory(3, "https://amp.businessinsider.com/images/5899ffcf6e09a897008b5c04-750-750.jpg",
				"Ramón", "Peréz", 1, "Owner", 1);
		Directory d4 = new Directory(4,
				"https://cdn.moneymarketing.co.uk/content/uploads/2019/08/04235011/Profile-Neil-Wheelan-334x500.jpg",
				"José", "Cardona", 1, "Owner", 1);
		Directory d5 = new Directory(5,
				"https://www.rd.com/wp-content/uploads/2017/09/03-shutterstock_450728395-F8-studio-1024x683.jpg",
				"Rocio", "Robles", 2, "Owner", 1);
		list = new ArrayList<>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		list.add(d5);
	}

	private void bindUI(View view) {
		recyclerView = view.findViewById(R.id.reciclerview_directory);
		adapter = new DirectoryAdapter(list, presenter);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try {
			if (callbackDirectorySelected == null) {
				this.callbackDirectorySelected = (Main.CallbackDirectorySelected) context;
			}
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " should implement Main.CallbackDirectorySelected");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		this.callbackDirectorySelected = null;
	}

	@Override
	public void OnClickItem(Directory directory) {
		callbackDirectorySelected.getDirectory(directory);
	}
}
