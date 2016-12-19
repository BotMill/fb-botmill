package co.aurasphere.facebot.event.message;

import java.util.regex.Pattern;


import co.aurasphere.facebot.event.FaceBotEvent;
import co.aurasphere.facebot.event.base.BasePatternEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks that
 * contains a text message which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Alvin Reyes
 * 
 */
public class QuickReplyMessageEventPattern extends BasePatternEvent {

	/**
	 * @see BasePatternEvent#BasePatternEvent(Pattern)
	 */
	public QuickReplyMessageEventPattern(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * @see BasePatternEvent#BasePatternEvent(String)
	 */
	public QuickReplyMessageEventPattern(String expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * @return true if the text message received from the callback matches the
	 *         expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetQuickReplyPayload(envelope);
		return expectedPattern.matcher(message).matches();
	}
}
