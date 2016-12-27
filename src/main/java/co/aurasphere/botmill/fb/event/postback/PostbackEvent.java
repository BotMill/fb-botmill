package co.aurasphere.botmill.fb.event.postback;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * A {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a specific postback payload from Facebook's Messenger Platform.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class PostbackEvent extends BaseStringEvent {

	/**
	 * Instantiates a new postback event.
	 *
	 * @param expectedPayload
	 *            the {@link BaseStringEvent#expectedString}.
	 * @param caseSensitive
	 *            the {@link BaseStringEvent#caseSensitive}.
	 */
	public PostbackEvent(String expectedPayload, boolean caseSensitive) {
		super(expectedPayload, caseSensitive);
	}

	/**
	 * Instantiates a new postback event.
	 *
	 * @param expectedPayload
	 *            the {@link BaseStringEvent#expectedString}.
	 */
	public PostbackEvent(String expectedPayload) {
		super(expectedPayload);
	}

	/**
	 * Verify event condition.
	 *
	 * @param envelope the envelope
	 * @return true if the postback payload received by the callback equals the
	 *         expected payload, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return verifyStringMatch(payload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.event.base.BaseStringEvent#toString()
	 */
	@Override
	public String toString() {
		return "PostbackEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}

}
