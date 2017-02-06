package co.aurasphere.botmill.fb.exception;

public class FbBotMillControllerEventMisMatchException extends Exception {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new FbBot illegal attachment exception.
	 *
	 * @param message
	 *            the message.
	 */
	public FbBotMillControllerEventMisMatchException(String message) {
		super(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillControllerEventMisMatchException []";
	}

}
