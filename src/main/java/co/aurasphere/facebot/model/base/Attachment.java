package co.aurasphere.facebot.model.base;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.facebot.model.outcoming.payload.Payload;

/**
 * Represents a Facebook Messenger Platform attachment. It may be a file or a
 * template.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class Attachment implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The attachment type.
	 */
	@NotNull
	private AttachmentType type;

	/**
	 * The payload of the attachment.
	 */
	@Valid
	@NotNull
	private Payload payload;
	
	public Attachment(){}

	public Attachment(AttachmentType type, Payload payload) {
		this.type = type;
		this.payload = payload;
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
