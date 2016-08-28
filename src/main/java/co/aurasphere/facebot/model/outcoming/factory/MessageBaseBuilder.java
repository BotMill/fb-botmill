package co.aurasphere.facebot.model.outcoming.factory;

import java.util.List;

import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;

/**
 * Base class for a {@link FaceBotMockableBuilder} that builds a message.
 * 
 * @author Donato
 * @date 27/ago/2016
 */
public abstract class MessageBaseBuilder extends FaceBotMockableBuilder {

	/**
	 * The quick replies of this message. It's initialized lazily.
	 */
	protected List<QuickReply> quickReplies;

}
