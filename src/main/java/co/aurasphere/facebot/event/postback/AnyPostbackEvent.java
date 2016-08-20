package co.aurasphere.facebot.event.postback;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.event.FaceBotEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks
 * that contains a postback from Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class AnyPostbackEvent extends FaceBotBean implements FaceBotEvent {

	/**
	 * @return true if the incoming callback contains a non-empty, non-null
	 *         postback, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return !payload.isEmpty();
	}

}
