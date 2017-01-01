package co.aurasphere.botmill.fb.event.message;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * An {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a text message which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Alvin Reyes
 * 
 */
public class QuickReplyMessagePatternEvent extends BasePatternEvent {

	/**
	 * Instantiates a new quick reply message event pattern.
	 *
	 * @param expectedPattern the expected pattern
	 * @see BasePatternEvent#BasePatternEvent(Pattern)
	 */
	public QuickReplyMessagePatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new quick reply message event pattern.
	 *
	 * @param expectedPattern the expected pattern
	 * @see BasePatternEvent#BasePatternEvent(String)
	 */
	public QuickReplyMessagePatternEvent(String expectedPattern) {
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
