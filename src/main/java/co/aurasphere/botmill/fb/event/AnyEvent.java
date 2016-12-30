package co.aurasphere.botmill.fb.event;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * An {@link FbBotMillEvent} that processes all the incoming callbacks from
 * Facebook Messenger Platform.
 * 
 * @author Donato Rimenti
 * 
 */
public class AnyEvent implements FbBotMillEvent {

	/**
	 * Verify event condition.
	 *
	 * @param envelope the envelope
	 * @return always true, in order to process any incoming callback.
	 */
	public boolean verifyEventCondition(MessageEnvelope envelope) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnyEvent []";
	}

}
