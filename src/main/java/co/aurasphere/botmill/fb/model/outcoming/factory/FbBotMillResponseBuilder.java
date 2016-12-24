package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;


/**
 * Abstract class for the response builders. Defines how a bot should build
 * the {@link FbBotMillResponse} object representing its response.
 * 
 * @author Donato Rimenti
 * @date Aug 25, 2016
 */
public abstract class FbBotMillResponseBuilder extends FbBotMillBean {

	/**
	 * Builds the {@link FbBotMillResponse} that the bot should return.
	 * 
	 * @param envelope
	 *            a {@link MessageEnvelope} object representing the incoming
	 *            message.
	 * @return the {@link FbBotMillResponse} of this bot.
	 */
	abstract FbBotMillResponse build(MessageEnvelope envelope);

}
