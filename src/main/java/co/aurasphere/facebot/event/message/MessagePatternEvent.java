package co.aurasphere.facebot.event.message;

import java.util.regex.Pattern;

import co.aurasphere.facebot.event.FaceBotEvent;
import co.aurasphere.facebot.event.base.BasePatternEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks
 * that contains a text message which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class MessagePatternEvent extends BasePatternEvent {

	/**
	 * @see BasePatternEvent#BasePatternEvent(Pattern)
	 */
	public MessagePatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}
	
	/**
	 * @see BasePatternEvent#BasePatternEvent(String)
	 */
	public MessagePatternEvent(String expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * @return true if the text message received from the callback matches the
	 *         expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		return expectedPattern.matcher(message).matches();
	}
}
