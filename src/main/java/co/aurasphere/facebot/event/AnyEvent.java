package co.aurasphere.facebot.event;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link EventCallbackHandler} that processes all the incoming callbacks
 * from Facebook Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public abstract class AnyEvent implements
		EventCallbackHandler {

	/**
	 * @return always true, in order to process any incoming callback.
	 */
	public boolean verifyEventCondition(MessageEnvelope envelope) {
		return true;
	}

}
