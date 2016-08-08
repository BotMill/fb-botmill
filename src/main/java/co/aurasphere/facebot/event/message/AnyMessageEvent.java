package co.aurasphere.facebot.event.message;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.event.EventCallbackHandler;
import co.aurasphere.facebot.event.FaceBotEventType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link EventCallbackHandler} that processes all the incoming callbacks
 * that contains a text message from Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public abstract class AnyMessageEvent extends FaceBotBean implements
		EventCallbackHandler {

	/**
	 * @return true if the incoming callback contains a non-empty, non-null text
	 *         message, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		return eventKind(envelope) == FaceBotEventType.MESSAGE;
	}

}
