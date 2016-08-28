package co.aurasphere.facebot.model.outcoming.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.facebot.model.base.Attachment;

public class AttachmentMessage extends Message {

	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private Attachment attachment;

	public AttachmentMessage(Attachment attachment){
		this.attachment = attachment;
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
}
