/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.base.QuickReplyLocationPayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ButtonTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.GenericTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ListTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ReceiptTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineBoardingPassTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineCheckinTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineFlightUpdateTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineItineraryTemplatePayload;

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
		JsonElement payloadJson = json.getAsJsonObject().get("payload");

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
			// In case of Fallback attachment the payload will be null so I do
			// nothing.
			break;
		case TEMPLATE:
			// In case of a template I need to check which one to instantiate.
			String payloadTypeString = payloadJson.getAsJsonObject()
					.get("template_type").getAsString();
			PayloadType templateType = PayloadType.valueOf(payloadTypeString
					.toUpperCase());

			switch (templateType) {
			case AIRLINE_BOARDINGPASS:
				payloadClass = AirlineBoardingPassTemplatePayload.class;
				break;
			case AIRLINE_CHECKIN:
				payloadClass = AirlineCheckinTemplatePayload.class;
				break;
			case AIRLINE_ITINERARY:
				payloadClass = AirlineItineraryTemplatePayload.class;
				break;
			case AIRLINE_UPDATE:
				payloadClass = AirlineFlightUpdateTemplatePayload.class;
				break;
			case BUTTON:
				payloadClass = ButtonTemplatePayload.class;
				break;
			case GENERIC:
				payloadClass = GenericTemplatePayload.class;
				break;
			case LIST:
				payloadClass = ListTemplatePayload.class;
				break;
			case RECEIPT:
				payloadClass = ReceiptTemplatePayload.class;
				break;
			}
			break;
		}
		Payload payload = context.deserialize(payloadJson, payloadClass);
		attachment.setPayload(payload);
		return attachment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AttachmentDeserializer []";
	}

}
