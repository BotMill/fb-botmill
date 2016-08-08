package co.aurasphere.facebot.event.postback;

import java.util.regex.Pattern;

import co.aurasphere.facebot.event.reply.AutoReply;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.validator.FaceBotValidator;

/**
 * A {@link PostbackPatternEvent} that delegates an {@link AutoReply} to handle the
 * callback.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class PostbackPatternEventAutoReply extends PostbackPatternEvent {

	/**
	 * The {@link AutoReply} that will handle the incoming callbacks.
	 */
	private AutoReply reply;

	/**
	 * Object constructor.
	 * 
	 * @param expectedPayloadPattern
	 *            the pattern to match against the incoming postback payload. It
	 *            can't be null or empty.
	 * @param reply
	 *            the {@link AutoReply} that will handle the incoming callbacks.
	 *            It can't be null.
	 */
	public PostbackPatternEventAutoReply(String expectedPayloadPattern, AutoReply reply) {
		super(expectedPayloadPattern);
		FaceBotValidator.notNull(reply, "AutoReply for PostbackPatternEventAutoReply");
		this.reply = reply;
	}

	/**
	 * Object constructor.
	 * 
	 * @param expectedPayloadPattern
	 *            the pattern to match against the incoming postback payload. It
	 *            can't be null or empty.
	 * @param reply
	 *            the {@link AutoReply} that will handle the incoming callbacks.
	 *            It can't be null.
	 */
	public PostbackPatternEventAutoReply(Pattern expectedPayloadPattern, AutoReply reply) {
		super(expectedPayloadPattern);
		FaceBotValidator.notNull(reply, "AutoReply for PostbackPatternEventAutoReply");
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
