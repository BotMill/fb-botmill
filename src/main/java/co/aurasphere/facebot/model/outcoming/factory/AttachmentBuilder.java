package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.outcoming.payload.Payload;
import co.aurasphere.facebot.model.outcoming.payload.UrlPayload;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class AttachmentBuilder{

	private Payload payload;

	private AttachmentType type;
	
	AttachmentBuilder(AttachmentType type, String url) {
		FaceBotValidator.notNull(type, "AttachmentType");
		FaceBotValidator.notEmpty(url, "URL");
		this.payload = new UrlPayload(url);
		this.type = type;
	}
	
	AttachmentBuilder(AttachmentType type, Payload payload) {
		FaceBotValidator.notNull(type, "AttachmentType");
		FaceBotValidator.notNull(payload, "Payload");
		this.payload = payload;
		this.type = type;
	}
	
	public Attachment build(){
		return new Attachment(payload, type);
	}
	

}
