package co.aurasphere.facebot.autoreply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.factory.ReplyFactory;
import co.aurasphere.facebot.validator.FaceBotIllegalAttachmentException;

/**
 * An {@link AutoReply} that replies with a file, video, image or audio
 * attachment.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class AttachmentAutoReply extends AutoReply {

	private static final Logger logger = LoggerFactory
			.getLogger(AttachmentAutoReply.class);

	/**
	 * The attachment type.
	 */
	private AttachmentType type;

	/**
	 * The URL pointing to the attachment.
	 */
	private String url;

	/**
	 * Object constructor.
	 * 
	 * @param type
	 *            the attachment type. This can only be
	 *            {@link AttachmentType#FILE}, {@link AttachmentType#AUDIO},
	 *            {@link AttachmentType#IMAGE} or {@link AttachmentType#VIDEO}.
	 * @param url
	 *            the URL pointing to the attachment.
	 */
	public AttachmentAutoReply(AttachmentType type, String url) {
		this.type = type;
		this.url = url;
	}

	/**
	 * {@inheritDoc} Replies with an attachment.
	 */
	@Override
	public FaceBotResponse createResponse(MessageEnvelope envelope) {
		FaceBotResponse response = null;

		switch (type) {
		case FILE:
			response = ReplyFactory.addFileAttachment(url).build(envelope);
			break;
		case IMAGE:
			response = ReplyFactory.addImageAttachment(url).build(envelope);
			break;
		case AUDIO:
			response = ReplyFactory.addAudioAttachment(url).build(envelope);
			break;
		case VIDEO:
			response = ReplyFactory.addVideoAttachment(url).build(envelope);
			break;
		default:
			String message = "Illegal attachment of type [ " + type.name()
					+ " ] for AttachmentAutoReply";
			logger.error(message);
			throw new FaceBotIllegalAttachmentException(message);
		}
		return response;
	}

}
