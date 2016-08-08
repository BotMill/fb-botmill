package co.aurasphere.facebot.exception;

/**
 * Exception used to handle an invalid response from a FaceBot.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class FaceBotValidationException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public FaceBotValidationException(String message) {
		super(message);
	}

}
