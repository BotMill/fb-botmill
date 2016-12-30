package co.aurasphere.botmill.fb.model.outcoming.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.Attachment;

/**
 * A {@link Message} which contains an {@link Attachment}.
 * 
 * @author Donato Rimenti
 * 
 */
public class AttachmentMessage extends Message {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The attachment associated with this message.
	 */
	@Valid
	@NotNull
	private Attachment attachment;

	/**
	 * Instantiates a new attachment message.
	 *
	 * @param attachment the {@link #attachment}.
	 */
	public AttachmentMessage(Attachment attachment){
		this.attachment = attachment;
	}
	
	/**
	 * Gets the {@link #attachment}.
	 *
	 * @return the {@link #attachment}.
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * Sets the {@link #attachment}.
	 *
	 * @param attachment the {@link #attachment} to set.
	 */
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
}
