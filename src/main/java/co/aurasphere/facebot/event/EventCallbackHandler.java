package co.aurasphere.facebot.event;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An interface that defines how to handle a Facebook Messenger Platform
 * callback.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public interface EventCallbackHandler {

	/**
	 * A method which evaluates whether the callback should be processed by this
	 * handler.
	 * 
	 * @param envelope
	 *            the callback message
	 * @return true if the callback should be processed by this handler,
	 *         otherwise false
	 */
	public abstract boolean verifyEventCondition(MessageEnvelope envelope);

	/**
	 * A method that defines how to handle this callback.
	 * 
	 * @param envelope
	 *            the callback message
	 */
	public abstract void handleCallback(MessageEnvelope envelope);

}
