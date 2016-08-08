package co.aurasphere.facebot.event.message;

import java.util.regex.Pattern;

import co.aurasphere.facebot.event.reply.AutoReply;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.validator.FaceBotValidator;

/**
 * A {@link MessagePatternEvent} that delegates an {@link AutoReply} to handle
 * the callback.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class MessagePatternEventAutoReply extends MessagePatternEvent {

	/**
	 * The {@link AutoReply} that will handle the incoming callbacks.
	 */
	private AutoReply reply;

	/**
	 * Object constructor.
	 * 
	 * @param expectedMessagePattern
	 *            the pattern to match against the incoming text message. It
	 *            can't be null or empty.
	 * @param reply
	 *            the {@link AutoReply} that will handle the incoming callbacks.
	 *            It can't be null.
	 */
	public MessagePatternEventAutoReply(String expectedPattern,
			AutoReply reply) {
		super(expectedPattern);
		FaceBotValidator.notNull(reply, "AutoReply for MessagePatternEventAutoReply");
		this.reply = reply;
	}

	/**
	 * Object constructor.
	 * 
	 * @param expectedMessagePattern
	 *            the pattern to match against the incoming text message. It
	 *            can't be null or empty.
	 * @param reply
	 *            the {@link AutoReply} that will handle the incoming callbacks.
	 *            It can't be null.
	 */
	public MessagePatternEventAutoReply(Pattern expectedMessagePattern,
			AutoReply reply) {
		super(expectedMessagePattern);
		FaceBotValidator.notNull(reply, "AutoReply for MessagePatternEventAutoReply");
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
