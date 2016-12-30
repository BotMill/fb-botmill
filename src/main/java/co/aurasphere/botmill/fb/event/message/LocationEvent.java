package co.aurasphere.botmill.fb.event.message;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.callback.LocationCoordinates;

public class LocationEvent extends FbBotMillBean implements FbBotMillEvent {
	
	public LocationEvent() {}

	/**
	 * This method is called to verify that the message envelop contains the payload to verify that
	 * we are processing a location input.
	 * 
	 * @param envelope the message envelop that contains the location payload.
	 * @return true if the text message received from the callback is a location.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		LocationCoordinates locationCoordinates = getLocationMessage(envelope);
		return (locationCoordinates != null ? true : false);
	}
}
