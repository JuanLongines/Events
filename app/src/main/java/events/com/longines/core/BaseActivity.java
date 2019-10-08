package events.com.longines.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

	protected void showToast(String message) {
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}

	protected void next(Bundle bundle, Class<?> activity, boolean destroy) {
		Intent intent = new Intent(this, activity);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
		if (destroy)
			finish();
	}

	protected void next(Bundle bundle, Class<?> activity) {
		Intent intent = new Intent(this, activity);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	protected void next(Class<?> activity) {
		Intent intent = new Intent(this, activity);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
	}

	protected void next(Class<?> activity, boolean close) {
		Intent intent = new Intent(this, activity);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		if (close) {
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		}

		startActivity(intent);
	}

}
