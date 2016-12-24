package co.aurasphere.botmill.fb.model.outcoming.factory;

import java.util.List;

import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

/**
 * Base class for a {@link FbBotMillMockableBuilder} that builds a message.
 * 
 * @author Donato Rimenti
 * @date Aug 27, 2016
 */
public abstract class MessageBaseBuilder extends FbBotMillMockableBuilder {

	/**
	 * The quick replies of this message. It's initialized lazily.
	 */
	protected List<QuickReply> quickReplies;

}
