package co.aurasphere.facebot.exception;

/**
 * Exception used to handle an {@link Attachment} that's not permitted for a response.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class FaceBotIllegalAttachmentException extends IllegalArgumentException {

	public FaceBotIllegalAttachmentException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
