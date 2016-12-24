package co.aurasphere.botmill.fb.autoreply;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.internal.util.network.NetworkUtils;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

/**
 * A class that represents an automatic reply to an event. AutoReply are used in
 * conjuction with {@link FbBotMillEvent} in order to handle an Facebook's
 * Messenger Platform callback automatically, using the delegation design
 * pattern.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public abstract class AutoReply extends FbBotMillBean {

	/**
	 * Method which defines the reply flow.
	 * 
	 * @param envelope
	 *            the current callback message
	 */
	public void reply(MessageEnvelope envelope) {
		FbBotMillResponse response = createResponse(envelope);
		if (response != null) {
			// If the response is valid, replies to it.
			if (validate(response)) {
				NetworkUtils.postJsonMessage(response);
			}
		}
	}

	/**
	 * Method which defines the response to send back as a response to the
	 * current message.
	 * 
	 * @param envelope
	 *            the current message.
	 * @return a {@link FbBotMillResponse} which contains the response to the
	 *         current message.
	 */
	public abstract FbBotMillResponse createResponse(MessageEnvelope envelope);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AutoReply []";
	}

}
