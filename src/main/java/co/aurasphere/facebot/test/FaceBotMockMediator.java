package co.aurasphere.facebot.test;

import java.util.List;

import co.aurasphere.facebot.FaceBot;
import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.bean.FaceBotNetworkAwareBean;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.incoming.callback.IncomingMessageBody;
import co.aurasphere.facebot.model.incoming.callback.Postback;

public class FaceBotMockMediator extends FaceBotNetworkAwareBean {

	public static void sendTextMessage(String message) {
		MessageEnvelope envelope = new MessageEnvelope();
		IncomingMessageBody body = new IncomingMessageBody();
		
		body.setText(message);
		envelope.setMessage(body);
		
		forward(envelope);
	}

	public static void sendPayload(String payload){
		MessageEnvelope envelope = new MessageEnvelope();		
		Postback postback = new Postback();
		
		postback.setPayload(payload);
		envelope.setPostback(postback);
		
		forward(envelope);
	}
	
	private static void forward(MessageEnvelope envelope) {
		List<FaceBot> bots = FaceBotContext.getInstance().getRegisteredBots();
		for(FaceBot b : bots){
			b.processMessage(envelope);
		}
	}

}
