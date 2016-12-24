package co.aurasphere.botmill.fb.event.postback;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * A {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a postback payload which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class PostbackPatternEvent extends BasePatternEvent {

	/**
	 * Instantiates a new postback pattern event.
	 *
	 * @param expectedPattern
	 *            the {@link BasePatternEvent#expecteddPattern}.
	 */
	public PostbackPatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new postback pattern event.
	 *
	 * @param expectedPattern
	 *            the {@link BasePatternEvent#expectedPattern}.
	 */
	public PostbackPatternEvent(String expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * @return true if the postback payload received from the callback matches
	 *         the expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return verifyPatternMatch(payload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.event.base.BasePatternEvent#toString()
	 */
	@Override
	public String toString() {
		return "PostbackPatternEvent [expectedPattern=" + expectedPattern + "]";
	}
}
