package co.aurasphere.botmill.fb.event;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * An interface that defines an event from Facebook Messenger Platform callback.
 * 
 * @author Donato Rimenti
 * 
 */
public interface FbBotMillEvent {

	/**
	 * A method which evaluates whether the event is verified or not.
	 * 
	 * @param envelope
	 *            the callback message.
	 * @return true if the event is verified, false otherwise.
	 */
	public boolean verifyEventCondition(MessageEnvelope envelope);

}
