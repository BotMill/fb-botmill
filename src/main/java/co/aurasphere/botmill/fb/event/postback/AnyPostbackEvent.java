package co.aurasphere.botmill.fb.event.postback;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * The Class AnyPostbackEvent.
 */
public class AnyPostbackEvent extends FbBotMillBean implements FbBotMillEvent {

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return !payload.isEmpty();
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "AnyPostbackEvent []";
	}

}
