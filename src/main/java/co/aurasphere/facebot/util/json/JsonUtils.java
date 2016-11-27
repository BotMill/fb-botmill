package co.aurasphere.facebot.util.json;

import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Utility class for handling JSON.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class JsonUtils {

	/**
	 * Gson which handles the JSON conversion.
	 */
	private static Gson gson;

	/**
	 * Initializes the current Gson object if null and returns it. The Gson
	 * object has a custom adapter to manage timestamp datatype as this is the
	 * format used by Facebook.
	 * 
	 * @return the current instance of Gson.
	 */
	private static Gson getGson() {
		if (gson == null) {
			// Creates the Gson object which will manage the information
			// received
			GsonBuilder builder = new GsonBuilder();

			// Register an adapter to manage the date types as long values
			builder.registerTypeAdapter(Date.class,
					new DateToLongJsonDeserializer());
			// Serializes enums as lower-case.
			builder.registerTypeHierarchyAdapter(Enum.class,
					new EnumLowercaseSerializer());

			// Serializes calendar in format YYYY-MM-DDThh:mm.
			builder.registerTypeHierarchyAdapter(Calendar.class,
					new CalendarSerializer());

			gson = builder.create();
		}
		return gson;
	}
	
	public static <T> T fromJson(String json, Class<T> T){
		return getGson().fromJson(json, T);
	}
	
	public static String toJson(Object src){
		return getGson().toJson(src);
	}

}
