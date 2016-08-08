package co.aurasphere.facebot.event.postback;

import co.aurasphere.facebot.event.reply.AutoReply;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.validator.FaceBotValidator;

/**
 * A {@link PostbackEvent} that delegates an {@link AutoReply} to handle the
 * callback.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class PostbackEventAutoReply extends PostbackEvent {

	/**
	 * The {@link AutoReply} that will handle the incoming callbacks.
	 */
	private AutoReply reply;

	/**
	 * Default constructor.
	 * 
	 * @param expectedPayload
	 *            the postback payload that will trigger this handler. It can't
	 *            be null or empty.
	 * @param caseSensitive
	 *            indicates whether the comparison should be caseSensitive or
	 *            not.
	 * @param reply
	 *            the {@link AutoReply} that will handle the incoming callbacks.
	 *            It can't be null.
	 */
	public PostbackEventAutoReply(String expectedPayload,
			boolean caseSensitive, AutoReply reply) {
		super(expectedPayload, caseSensitive);
		FaceBotValidator.notNull(reply, "AutoReply for PostbackEventAutoReply");
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
