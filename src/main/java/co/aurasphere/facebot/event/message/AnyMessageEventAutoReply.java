package co.aurasphere.facebot.event.message;

import co.aurasphere.facebot.event.reply.AutoReply;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.validator.FaceBotValidator;

/**
 * A {@link AnyMessageEvent} that delegates an {@link AutoReply} to handle the
 * callback.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class AnyMessageEventAutoReply extends AnyMessageEvent {

	/**
	 * The {@link AutoReply} that will handle the incoming callbacks.
	 */
	private AutoReply reply;

	/**
	 * Default constructor.
	 * 
	 * @param reply
	 *            the {@link AutoReply} that will handle the incoming callbacks.
	 *            It can't be null.
	 */
	public AnyMessageEventAutoReply(AutoReply reply) {
		FaceBotValidator.notNull(reply, "AutoReply");
		this.reply = reply;
	}

	/**
	 * {@inheritDoc} It delegates the current callback to the {@link AutoReply}
	 * associated to this object.
	 */
	public void handleCallback(MessageEnvelope envelope) {
		reply.reply(envelope);
	}
}
