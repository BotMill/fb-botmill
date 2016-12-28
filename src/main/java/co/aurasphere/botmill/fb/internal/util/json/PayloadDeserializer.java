package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;

import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.base.QuickReplyLocationPayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ButtonTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.GenericTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ListTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ReceiptTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineBoardingPassTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineCheckinTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineFlightUpdateTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineItineraryTemplatePayload;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Class which handles {@link Payload} objects serialization and deserialization
 * by instantiating the specific class.
 * 
 * @author Donato Rimenti
 * @date Dec 27, 2016
 */
public class PayloadDeserializer implements JsonSerializer<Payload>,
		JsonDeserializer<Payload>, InstanceCreator<Payload> {

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

		// This cases should never happen but are implemented for completeness.
		// Template payloads.
		if (realClass.isAssignableFrom(ButtonTemplatePayload.class)) {
			return context.deserialize(json, ButtonTemplatePayload.class);
		}
		if (realClass.isAssignableFrom(GenericTemplatePayload.class)) {
			return context.deserialize(json, GenericTemplatePayload.class);
		}
		if (realClass.isAssignableFrom(ReceiptTemplatePayload.class)) {
			return context.deserialize(json, ReceiptTemplatePayload.class);
		}
		if (realClass.isAssignableFrom(ListTemplatePayload.class)) {
			return context.deserialize(json, ListTemplatePayload.class);
		}

		// Airline template payloads.
		if (realClass.isAssignableFrom(AirlineCheckinTemplatePayload.class)) {
			return context.deserialize(json,
					AirlineCheckinTemplatePayload.class);
		}
		if (realClass
				.isAssignableFrom(AirlineFlightUpdateTemplatePayload.class)) {
			return context.deserialize(json,
					AirlineFlightUpdateTemplatePayload.class);
		}
		if (realClass.isAssignableFrom(AirlineItineraryTemplatePayload.class)) {
			return context.deserialize(json,
					AirlineItineraryTemplatePayload.class);
		}
		if (realClass
				.isAssignableFrom(AirlineBoardingPassTemplatePayload.class)) {
			return context.deserialize(json,
					AirlineBoardingPassTemplatePayload.class);
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

		// This cases should never happen but are implemented for completeness.
		// Template payloads.
		if (realClass.isAssignableFrom(ButtonTemplatePayload.class)) {
			return new ButtonTemplatePayload();
		}
		if (realClass.isAssignableFrom(GenericTemplatePayload.class)) {
			return new GenericTemplatePayload();
		}
		if (realClass.isAssignableFrom(ReceiptTemplatePayload.class)) {
			return new ReceiptTemplatePayload();
		}
		if (realClass.isAssignableFrom(ListTemplatePayload.class)) {
			return new ListTemplatePayload();
		}

		// Airline template payloads.
		if (realClass.isAssignableFrom(AirlineCheckinTemplatePayload.class)) {
			return new AirlineCheckinTemplatePayload();
		}
		if (realClass
				.isAssignableFrom(AirlineFlightUpdateTemplatePayload.class)) {
			return new AirlineFlightUpdateTemplatePayload();
		}
		if (realClass.isAssignableFrom(AirlineItineraryTemplatePayload.class)) {
			return new AirlineItineraryTemplatePayload();
		}
		if (realClass
				.isAssignableFrom(AirlineBoardingPassTemplatePayload.class)) {
			return new AirlineBoardingPassTemplatePayload();
		}
		throw new RuntimeException("Unable to instantiate FbBotMill Payload.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
	 * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public JsonElement serialize(Payload src, Type typeOfSrc,
			JsonSerializationContext context) {

		if (src instanceof UrlPayload) {
			return context.serialize(src, UrlPayload.class);
		}
		if (src instanceof QuickReplyLocationPayload) {
			return context.serialize(src, QuickReplyLocationPayload.class);
		}

		// Template payloads.
		if (src instanceof ButtonTemplatePayload) {
			return context.serialize(src, ButtonTemplatePayload.class);
		}
		if (src instanceof GenericTemplatePayload) {
			return context.serialize(src, GenericTemplatePayload.class);
		}
		if (src instanceof ReceiptTemplatePayload) {
			return context.serialize(src, ReceiptTemplatePayload.class);
		}
		if (src instanceof ListTemplatePayload) {
			return context.serialize(src, ListTemplatePayload.class);
		}

		// Airline template payloads.
		if (src instanceof AirlineCheckinTemplatePayload) {
			return context.serialize(src, AirlineCheckinTemplatePayload.class);
		}
		if (src instanceof AirlineFlightUpdateTemplatePayload) {
			return context.serialize(src,
					AirlineFlightUpdateTemplatePayload.class);
		}
		if (src instanceof AirlineItineraryTemplatePayload) {
			return context
					.serialize(src, AirlineItineraryTemplatePayload.class);
		}
		if (src instanceof AirlineBoardingPassTemplatePayload) {
			return context.serialize(src,
					AirlineBoardingPassTemplatePayload.class);
		}

		throw new JsonParseException("Unable to serialize FbBotMill Payload.");
	}

}
