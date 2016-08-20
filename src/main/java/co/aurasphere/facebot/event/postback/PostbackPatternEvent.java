package co.aurasphere.facebot.event.postback;

import java.util.regex.Pattern;

import co.aurasphere.facebot.event.FaceBotEvent;
import co.aurasphere.facebot.event.base.BasePatternEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link FaceBotEvent} that processes all the incoming callbacks
 * that contains a postback payload which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class PostbackPatternEvent extends BasePatternEvent {

	/**
	 * @see BasePatternEvent#BasePatternEvent(Pattern)
	 */
	public PostbackPatternEvent(Pattern expectedPayloadPattern){
		super(expectedPayloadPattern);
	}
	
	/**
	 * @see BasePatternEvent#BasePatternEvent(String)
	 */
	public PostbackPatternEvent(String expectedPayloadPattern){
		super(expectedPayloadPattern);
	}
	
	/**
	 * @return true if the postback payload received from the callback matches the
	 *         expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return expectedPattern.matcher(payload).matches();
	}
}
