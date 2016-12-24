package co.aurasphere.botmill.fb.event.message;

import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks that
 * contains a specific text message from Facebook's Messenger Platform.
 * 
 * @author Alvin Reyes
 * 
 */
public class QuickReplyMessageEvent extends BaseStringEvent {

	/**
	 * @see BaseStringEvent#BaseEvent(String)
	 */
	public QuickReplyMessageEvent(String expectedPayload, boolean caseSensitive) {
		super(expectedPayload, caseSensitive);
	}

	public QuickReplyMessageEvent(String expectedPayload) {
		super(expectedPayload);
	}

	/**
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
