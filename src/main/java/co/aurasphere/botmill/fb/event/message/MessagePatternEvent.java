package co.aurasphere.botmill.fb.event.message;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * A {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a text message which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class MessagePatternEvent extends BasePatternEvent {

	/**
	 * Instantiates a new message pattern event.
	 *
	 * @param expectedPattern
	 *            the {@link BasePatternEvent#expectedPattern}.
	 */
	public MessagePatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new message pattern event.
	 *
	 * @param expectedPattern
	 *            the {@link BasePatternEvent#expectedPattern}.
	 */
	public MessagePatternEvent(String expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * @return true if the text message received from the callback matches the
	 *         expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		return verifyPatternMatch(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.event.base.BasePatternEvent#toString()
	 */
	@Override
	public String toString() {
		return "MessagePatternEvent [expectedPattern=" + expectedPattern + "]";
	}
}
