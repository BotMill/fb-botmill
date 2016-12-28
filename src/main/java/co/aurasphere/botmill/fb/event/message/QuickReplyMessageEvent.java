package co.aurasphere.botmill.fb.event.message;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * An {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a specific text message from Facebook's Messenger Platform.
 * 
 * @author Alvin Reyes
 * @date Dec 25, 2016
 */
public class QuickReplyMessageEvent extends BaseStringEvent {

	/**
	 * Instantiates a new quick reply message event.
	 *
	 * @param expectedPayload the expected payload
	 * @param caseSensitive the case sensitive
	 * @see BaseStringEvent#BaseEvent(String)
	 */
	public QuickReplyMessageEvent(String expectedPayload, boolean caseSensitive) {
		super(expectedPayload, caseSensitive);
	}

	/**
	 * Instantiates a new quick reply message event.
	 *
	 * @param expectedPayload the expected payload
	 */
	public QuickReplyMessageEvent(String expectedPayload) {
		super(expectedPayload);
	}

	/**
	 * Verify event condition.
	 *
	 * @param envelope the envelope
	 * @return true if the text message received by the callback equals the
	 *         expected message, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetQuickReplyPayload(envelope);
		if (!caseSensitive) {
			expectedString = expectedString.toLowerCase();
			message = message.toLowerCase();
		}
		return message.equals(expectedString);
	}

}
