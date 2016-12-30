package co.aurasphere.botmill.fb.event.message;

import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * The Class MessageEvent.
 */
public class MessageEvent extends BaseStringEvent {

	/**
	 * Instantiates a new MessageEvent.
	 *
	 * @param expectedMessage the message string use to match a user response.
	 * @param caseSensitive the flag to set if the checker will be case sensitive or not.
	 */
	public MessageEvent(String expectedMessage, boolean caseSensitive) {
		super(expectedMessage, caseSensitive);
	}

	/**
	 * Instantiates a new MessageEvent.
	 *
	 * @param expectedMessage the message string use to match a user response.
	 */
	public MessageEvent(String expectedMessage) {
		super(expectedMessage);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		return verifyStringMatch(message);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.base.BaseStringEvent#toString()
	 */
	@Override
	public String toString() {
		return "MessageEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}

}
