package co.aurasphere.botmill.fb.event.postback;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * The Class PostbackPatternEvent.
 */
public class PostbackPatternEvent extends BasePatternEvent {

	/**
	 * Instantiates a new PostbackPatternEvent.
	 *
	 * @param expectedPattern the {@link #expectedPattern}.
	 */
	public PostbackPatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new PostbackPatternEvent.
	 *
	 * @param expectedPattern the {@link #expectedPattern}.
	 */
	public PostbackPatternEvent(String expectedPattern) {
		super(expectedPattern);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return verifyPatternMatch(payload);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.base.BasePatternEvent#toString()
	 */
	@Override
	public String toString() {
		return "PostbackPatternEvent [expectedPattern=" + expectedPattern + "]";
	}
}
