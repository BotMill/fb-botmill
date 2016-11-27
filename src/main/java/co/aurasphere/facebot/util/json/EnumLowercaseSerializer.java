package co.aurasphere.facebot.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EnumLowercaseSerializer implements JsonSerializer<Enum<?>> {
	
	public JsonElement serialize(Enum<?> src, Type typeOfSrc,
			JsonSerializationContext context) {
		return context.serialize(src.name().toLowerCase());
	}
}