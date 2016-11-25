package co.aurasphere.facebot.event;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks from
 * Facebook Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class AnyEvent implements FaceBotEvent {

	/**
	 * @return always true, in order to process any incoming callback.
	 */
	public boolean verifyEventCondition(MessageEnvelope envelope) {
		return true;
	}

}
