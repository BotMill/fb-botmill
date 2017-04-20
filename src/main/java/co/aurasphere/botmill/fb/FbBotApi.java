package co.aurasphere.botmill.fb;

import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.fb.autoreply.AutoReply;

public class FbBotApi {
	
	private static BotDefinition botDefinition;
	public static void setFbBot(BotDefinition botDefinition) {
		FbBotApi.botDefinition = botDefinition;
	}
	
	public static void reply(AutoReply reply) {
		((FbBot)botDefinition).reply(reply);
	}

}
