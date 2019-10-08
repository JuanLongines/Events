package events.com.longines.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import events.com.longines.R;
import events.com.longines.core.L;

public class EditProfileActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_profile);
		// Retrieve sent bundle
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			String hotelName = bundle.getString("key");
			L.i(hotelName);
		}
	}
}
