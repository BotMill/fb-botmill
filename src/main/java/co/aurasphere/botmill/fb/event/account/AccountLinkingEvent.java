package co.aurasphere.botmill.fb.event.account;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

public class AccountLinkingEvent extends FbBotMillBean implements FbBotMillEvent {

	/**
	 * Instantiates a new LocationEvent.
	 */
	public AccountLinkingEvent() {
	}

	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		return eventKind(envelope) == FbBotMillEventType.ACCOUNT_LINKING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "AccountLinking []";
	}
}
