package utility;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Utility {
	
	public static <T> String toJson(T jsonClass) {
		Gson gson = new Gson();
		return gson.toJson(jsonClass);
	}
	
	public static <T> Object fromJson(String jsonString, Class<T> jsonClass) throws JsonSyntaxException {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, jsonClass);
	}
}
