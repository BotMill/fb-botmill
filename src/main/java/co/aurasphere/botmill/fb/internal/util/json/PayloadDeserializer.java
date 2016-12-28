package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;

import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.base.QuickReplyLocationPayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Class which handles {@link Payload} objects deserialization by instantiating
 * the specific class.
 * 
 * @author Donato Rimenti
 * @date Dec 27, 2016
 */
public class PayloadDeserializer implements JsonDeserializer<Payload>,
		InstanceCreator<Payload> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public Payload deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {

		Class<?> realClass = (Class<?>) typeOfT;
		if (realClass.isAssignableFrom(UrlPayload.class)) {
			return context.deserialize(json, UrlPayload.class);
		}
		if (realClass.isAssignableFrom(QuickReplyLocationPayload.class)) {
			return context.deserialize(json, QuickReplyLocationPayload.class);
		}
		throw new JsonParseException("Unable to deserialize FbBotMill Payload.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.InstanceCreator#createInstance(java.lang.reflect.Type)
	 */
	public Payload createInstance(Type type) {

		Class<?> realClass = (Class<?>) type;
		if (realClass.isAssignableFrom(UrlPayload.class)) {
			return new UrlPayload();
		}
		if (realClass.isAssignableFrom(QuickReplyLocationPayload.class)) {
			return new QuickReplyLocationPayload();
		}
		throw new RuntimeException("Unable to instantiate FbBotMill Payload.");

	}

}
