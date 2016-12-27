package co.aurasphere.botmill.fb.event.message;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * A {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a specific text message from Facebook's Messenger Platform.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class MessageEvent extends BaseStringEvent {

	/**
	 * Instantiates a new message event.
	 *
	 * @param expectedMessage
	 *            the {@link BaseStringEvent#expectedString}.
	 * @param caseSensitive
	 *            the {@link BaseStringEvent#caseSensitive}.
	 */
	public MessageEvent(String expectedMessage, boolean caseSensitive) {
		super(expectedMessage, caseSensitive);
	}

	/**
	 * Instantiates a new message event.
	 *
	 * @param expectedMessage
	 *            the {@link BaseStringEvent#expectedString}.
	 */
	public MessageEvent(String expectedMessage) {
		super(expectedMessage);
	}

	/**
	 * Verify event condition.
	 *
	 * @param envelope the envelope
	 * @return true if the text message received by the callback equals the
	 *         expected message, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		return verifyStringMatch(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.event.base.BaseStringEvent#toString()
	 */
	@Override
	public String toString() {
		return "MessageEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}

}
