package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;

/**
 * Abstract class for the response builders. Defines how a FaceBot should build
 * the {@link FaceBotResponse} object representing its response.
 * 
 * @author Donato
 * @date 25/ago/2016
 */
public abstract class FaceBotResponseBuilder extends FaceBotBean {

	/**
	 * Builds the {@link FaceBotResponse} that the FaceBot should return.
	 * 
	 * @param envelope
	 *            a {@link MessageEnvelope} object representing the incoming
	 *            message.
	 * @return the {@link FaceBotResponse} of this FaceBot.
	 */
	abstract FaceBotResponse build(MessageEnvelope envelope);

}
