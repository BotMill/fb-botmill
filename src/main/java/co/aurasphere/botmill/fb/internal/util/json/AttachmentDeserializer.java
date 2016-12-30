package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.base.QuickReplyLocationPayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Custom deserializer for an {@link Attachment}. Instantiates the correct
 * payload according to the current object.
 * 
 * @author Donato Rimenti
 * 
 */
public class AttachmentDeserializer implements JsonDeserializer<Attachment> {

	/**
	 * Gson delegate used to avoid infinite loops during the deserialization.
	 */
	private static Gson delegateGson;

	/**
	 * Instantiates a new AttachmentDeserializer.
	 */
	public AttachmentDeserializer() {
		GsonBuilder builder = new GsonBuilder();
		builder.addDeserializationExclusionStrategy(new SkipDeserializationAnnotationExclusionStrategy());
		delegateGson = builder.create();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public Attachment deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {

		Attachment attachment = delegateGson.fromJson(json, Attachment.class);
		AttachmentType type = attachment.getType();
		Class<? extends Payload> payloadClass = null;
		JsonElement payloadjson = json.getAsJsonObject().get("payload");

		switch (type) {
		case AUDIO:
		case FILE:
		case IMAGE:
		case VIDEO:
			payloadClass = UrlPayload.class;
			break;
		case LOCATION:
			payloadClass = QuickReplyLocationPayload.class;
			break;
		case FALLBACK:
			// In case of Fallback attachment the payload will be null so I do nothing.
			break;
		case TEMPLATE:
			// TODO: this may happen in case of an echo callback. should be handled properly
			break;
//		default:
//			throw new RuntimeException(
//					"Template and Fallbacks are not supported as incoming message.");
		}
		Payload payload = context.deserialize(payloadjson, payloadClass);
		attachment.setPayload(payload);
		return attachment;
	}

}
