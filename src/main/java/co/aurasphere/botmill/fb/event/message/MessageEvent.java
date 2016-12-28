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
	 * @param expectedMessage the {@link #expectedMessage}.
	 * @param caseSensitive the {@link #caseSensitive}.
	 */
	public MessageEvent(String expectedMessage, boolean caseSensitive) {
		super(expectedMessage, caseSensitive);
	}

	/**
	 * Instantiates a new MessageEvent.
	 *
	 * @param expectedMessage the {@link #expectedMessage}.
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
