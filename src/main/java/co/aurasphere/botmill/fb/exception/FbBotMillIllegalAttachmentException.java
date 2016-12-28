package co.aurasphere.botmill.fb.exception;

import co.aurasphere.botmill.fb.model.base.Attachment;


/**
 * Exception used to handle an {@link Attachment} that's not permitted for a
 * response.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class FbBotMillIllegalAttachmentException extends IllegalArgumentException {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new FbBot illegal attachment exception.
	 *
	 * @param message the message.
	 */
	public FbBotMillIllegalAttachmentException(String message) {
		super(message);
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillIllegalAttachmentException []";
	}

}
