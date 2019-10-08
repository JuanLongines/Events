package events.com.longines.core;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {
	public JSONObject objectToJSON(Object obj) {
		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(gson.toJson(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public <T> T jsonToObject(String json, Class<T> cls) {

		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		return gson.fromJson(json, cls);
	}
}
