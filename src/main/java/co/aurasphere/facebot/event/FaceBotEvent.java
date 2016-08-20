package co.aurasphere.facebot.event;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An interface that defines an event from Facebook Messenger Platform callback.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public interface FaceBotEvent {

	/**
	 * A method which evaluates whether the event is verified or not.
	 * 
	 * @param envelope
	 *            the callback message.
	 * @return true if the event is verified, false otherwise.
	 */
	public boolean verifyEventCondition(MessageEnvelope envelope);

}
