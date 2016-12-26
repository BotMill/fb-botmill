package co.aurasphere.botmill.fb.event.message;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks that
 * contains a text message which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Alvin Reyes
 * @date Dec 25, 2016
 */
public class QuickReplyMessageEventPattern extends BasePatternEvent {

	/**
	 * Instantiates a new quick reply message event pattern.
	 *
	 * @param expectedPattern the expected pattern
	 * @see BasePatternEvent#BasePatternEvent(Pattern)
	 */
	public QuickReplyMessageEventPattern(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new quick reply message event pattern.
	 *
	 * @param expectedPattern the expected pattern
	 * @see BasePatternEvent#BasePatternEvent(String)
	 */
	public QuickReplyMessageEventPattern(String expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Verify event condition.
	 *
	 * @param envelope the envelope
	 * @return true if the text message received from the callback matches the
	 *         expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetQuickReplyPayload(envelope);
		return expectedPattern.matcher(message).matches();
	}
}
