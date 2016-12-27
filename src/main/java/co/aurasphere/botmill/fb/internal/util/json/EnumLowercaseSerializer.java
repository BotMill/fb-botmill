package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


/**
 * Class that serializes an Enum as its lowercase name.
 * 
 * @author Donato Rimenti
 * @date Dec 18, 2016
 */
public class EnumLowercaseSerializer implements JsonSerializer<Enum<?>> {

	/**
	 * Serializes an Enum as its lowercase name.
	 *
	 * @param src the src
	 * @param typeOfSrc the type of src
	 * @param context the context
	 * @return the json element
	 */
	public JsonElement serialize(Enum<?> src, Type typeOfSrc,
			JsonSerializationContext context) {
		return context.serialize(src.name().toLowerCase());
	}
}