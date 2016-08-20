package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

public abstract class FaceBotMockableBuilder extends FaceBotBean implements FaceBotResponseBuilder{

	protected User getRecipient(MessageEnvelope envelope){
		FaceBotContext context = FaceBotContext.getInstance();
		if (context.isMockEnabled()){
			return new User(context.getFacebookMockId());
		}
		return safeGetSender(envelope);
	}
	
}
