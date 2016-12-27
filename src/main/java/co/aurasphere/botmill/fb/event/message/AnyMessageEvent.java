package co.aurasphere.botmill.fb.event.message;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * A {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a text message from Facebook's Messenger Platform.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class AnyMessageEvent extends FbBotMillBean implements FbBotMillEvent {

	/**
	 * Verify event condition.
	 *
	 * @param envelope the envelope
	 * @return true if the incoming callback contains a non-empty, non-null text
	 *         message, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		return eventKind(envelope) == FbBotMillEventType.MESSAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.bean.FaceBotBean#toString()
	 */
	@Override
	public String toString() {
		return "AnyMessageEvent []";
	}

}
