package co.aurasphere.facebot.model.base;

import java.io.Serializable;

import co.aurasphere.facebot.model.outcoming.payload.Payload;

/**
 * Represents an attachment that may be a file or a template.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class Attachment implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The attachment type.
	 */
	private AttachmentType type;

	/**
	 * The payload of the attachment.
	 */
	private Payload payload;

	public Attachment() {}

	public Attachment(Payload payload, AttachmentType type) {
		this.payload = payload;
		this.type = type;
	}

	public AttachmentType getType() {
		return type;
	}

	public void setType(AttachmentType type) {
		this.type = type;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

}
