package co.aurasphere.facebot.util;

import java.lang.reflect.Type;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Utility class for handling JSON.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class JsonUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(JsonUtils.class);

	/**
	 * Gson which handles the JSON conversion. It's a singleton.
	 */
	private static Gson gson;

	/**
	 * Initializes the current Gson object if null and returns it. The Gson
	 * object has a custom adapter to manage timestamp datatype as this is the
	 * format used by Facebook.
	 * 
	 * @return the current instance of Gson.
	 */
	public static Gson getGson() {
		if (gson == null) {
			// Creates the Gson object which will manage the information
			// received
			GsonBuilder builder = new GsonBuilder();

			// Register an adapter to manage the date types as long values
			builder.registerTypeAdapter(Date.class,
					new JsonDeserializer<Date>() {
						public Date deserialize(JsonElement json, Type typeOfT,
								JsonDeserializationContext context)
								throws JsonParseException {
							return new Date(json.getAsJsonPrimitive()
									.getAsLong());
						}
					});
			// Serializes enums as lower-case.
			builder.registerTypeHierarchyAdapter(Enum.class, new JsonSerializer<Enum>() {
				public JsonElement serialize(Enum src, Type typeOfSrc,
						JsonSerializationContext context) {
					return context.serialize(src.name().toLowerCase());
				}
			});
			gson = builder.create();
		}
		return gson;
	}

}
