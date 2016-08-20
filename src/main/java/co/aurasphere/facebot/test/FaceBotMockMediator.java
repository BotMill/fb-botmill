package co.aurasphere.facebot.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.FaceBot;
import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.FaceBotDefinition;
import co.aurasphere.facebot.bean.FaceBotNetworkAwareBean;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.incoming.callback.IncomingMessageBody;
import co.aurasphere.facebot.model.incoming.callback.Postback;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class FaceBotMockMediator extends FaceBotNetworkAwareBean {
	
	// Initializes the bots.
	public FaceBotMockMediator(String mockFacebookId, FaceBotDefinition... faceBotDefinitions) {
		FaceBotValidator.notEmpty(mockFacebookId, "Facebook ID");
		FaceBotValidator.notEmpty(faceBotDefinitions, "FaceBotDefinitions");
		
		FaceBotContext.getInstance().setFacebookMockId(mockFacebookId);
		
		for (FaceBotDefinition f : faceBotDefinitions) {
			FaceBotValidator.notNull(f, "FaceBotDefinition");
			f.defineBehavior();
		}
	}

	// Initializes the bots.
	public FaceBotMockMediator(String mockFacebookId, Class<? extends FaceBotDefinition>... faceBotDefinitions) {
		FaceBotValidator.notEmpty(mockFacebookId, "Facebook ID");
		FaceBotValidator.notEmpty(faceBotDefinitions, "FaceBotDefinitions");
		
		FaceBotContext.getInstance().setFacebookMockId(mockFacebookId);
		
		for (Class<? extends FaceBotDefinition> f : faceBotDefinitions) {
			FaceBotValidator.notNull(f, "FaceBotDefinition");
			FaceBotDefinition definition = instantiateClass(f);
			definition.defineBehavior();
		}
	}

	private FaceBotDefinition instantiateClass(
			Class<? extends FaceBotDefinition> klass) {
		FaceBotDefinition definition = null;
		try {
			definition = klass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return definition;
	}

	public static void sendTextMessage(String message) {
		MessageEnvelope envelope = new MessageEnvelope();
		IncomingMessageBody body = new IncomingMessageBody();

		body.setText(message);
		envelope.setMessage(body);

		forward(envelope);
	}

	public static void sendPayload(String payload) {
		MessageEnvelope envelope = new MessageEnvelope();
		Postback postback = new Postback();

		postback.setPayload(payload);
		envelope.setPostback(postback);

		forward(envelope);
	}

	private static void forward(MessageEnvelope envelope) {
		List<FaceBot> bots = FaceBotContext.getInstance().getRegisteredBots();
		for (FaceBot b : bots) {
			b.processMessage(envelope);
		}
	}

}
