package co.aurasphere.botmill.fb.event.message;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * The Class MessagePatternEvent.
 */
public class MessagePatternEvent extends BasePatternEvent {

	/**
	 * Instantiates a new MessagePatternEvent.
	 *
	 * @param expectedPattern the {@link #expectedPattern}.
	 */
	public MessagePatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new MessagePatternEvent.
	 *
	 * @param expectedPattern the {@link #expectedPattern}.
	 */
	public MessagePatternEvent(String expectedPattern) {
		super(expectedPattern);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		return verifyPatternMatch(message);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.base.BasePatternEvent#toString()
	 */
	@Override
	public String toString() {
		return "MessagePatternEvent [expectedPattern=" + expectedPattern + "]";
	}
}
