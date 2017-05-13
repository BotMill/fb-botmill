package co.aurasphere.botmill.fb;

import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.fb.autoreply.AutoReply;

/**
 * The Class FbBotApi.
 */
public class FbBotApi {
	
	/** The bot definition. */
	private static BotDefinition botDefinition;
	
	/**
	 * Sets the fb bot.
	 *
	 * @param botDefinition the new fb bot
	 */
	public static void setFbBot(BotDefinition botDefinition) {
		FbBotApi.botDefinition = botDefinition;
	}
	
	/**
	 * Reply.
	 *
	 * @param reply the reply
	 */
	public static void reply(AutoReply reply) {
		if(FbBotApi.botDefinition == null) {
			botDefinition = new FbBotApiBot();
		}
		((FbBot)FbBotApi.botDefinition).reply(reply);
	}


}
class FbBotApiBot extends FbBot implements BotDefinition {
	public FbBotApiBot() {
	}
}
