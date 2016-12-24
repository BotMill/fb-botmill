package co.aurasphere.botmill.fb.event.postback;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * A {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a postback from Facebook's Messenger Platform.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class AnyPostbackEvent extends FbBotMillBean implements FbBotMillEvent {

	/**
	 * @return true if the incoming callback contains a non-empty, non-null
	 *         postback, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return !payload.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.bean.FaceBotBean#toString()
	 */
	@Override
	public String toString() {
		return "AnyPostbackEvent []";
	}

}
