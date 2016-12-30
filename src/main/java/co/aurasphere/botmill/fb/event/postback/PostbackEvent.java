package co.aurasphere.botmill.fb.event.postback;

import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * The Class PostbackEvent.
 */
public class PostbackEvent extends BaseStringEvent {

	/**
	 * Instantiates a new PostbackEvent.
	 *
	 * @param expectedPayload the expectedPayload.
	 * @param caseSensitive the {@link #caseSensitive}.
	 */
	public PostbackEvent(String expectedPayload, boolean caseSensitive) {
		super(expectedPayload, caseSensitive);
	}

	/**
	 * Instantiates a new PostbackEvent.
	 *
	 * @param expectedPayload the expectedPayload.
	 */
	public PostbackEvent(String expectedPayload) {
		super(expectedPayload);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return verifyStringMatch(payload);
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.base.BaseStringEvent#toString()
	 */
	@Override
	public String toString() {
		return "PostbackEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}

}
