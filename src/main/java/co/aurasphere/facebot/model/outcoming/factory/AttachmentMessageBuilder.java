package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.message.AttachmentMessage;
import co.aurasphere.facebot.model.outcoming.message.FaceBotMessageResponse;
import co.aurasphere.facebot.model.outcoming.message.Message;
import co.aurasphere.facebot.model.outcoming.payload.Payload;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class AttachmentMessageBuilder extends FaceBotBean implements FaceBotResponseBuilder{

	private Attachment attachment;

	AttachmentMessageBuilder(AttachmentType type, String url) {
		this.attachment = new AttachmentBuilder(type, url).build();
	}
	
	AttachmentMessageBuilder(AttachmentType type, Payload payload){
		this.attachment = new AttachmentBuilder(type, payload).build();
	}
	
	AttachmentMessageBuilder(Attachment attachment){
		FaceBotValidator.notNull(attachment, "Attachment");
		this.attachment = attachment;
	}

	public FaceBotResponse build(MessageEnvelope envelope) {
		User recipient = safeGetSender(envelope);
		Message message = new AttachmentMessage(attachment);
		return new FaceBotMessageResponse(recipient, message);
	}

}
