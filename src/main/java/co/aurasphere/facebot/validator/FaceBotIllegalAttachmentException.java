package co.aurasphere.facebot.validator;

/**
 * Exception used to handle an {@link Attachment} that's not permitted for a response.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class FaceBotIllegalAttachmentException extends IllegalArgumentException {

	public FaceBotIllegalAttachmentException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
