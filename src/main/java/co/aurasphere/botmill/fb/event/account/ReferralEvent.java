package co.aurasphere.botmill.fb.event.account;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

public class ReferralEvent extends FbBotMillBean implements FbBotMillEvent {

	/**
	 * Instantiates a new LocationEvent.
	 */
	public ReferralEvent() {
	}

	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		return eventKind(envelope) == FbBotMillEventType.REFERRAL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "ReferralEvent []";
	}
}
