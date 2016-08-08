package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;

public interface FaceBotResponseBuilder {

	public abstract FaceBotResponse build(MessageEnvelope envelope);
}
