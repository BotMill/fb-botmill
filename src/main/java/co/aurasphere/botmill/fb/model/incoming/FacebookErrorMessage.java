package co.aurasphere.botmill.fb.model.incoming;

import java.io.Serializable;

/**
 * Message which contains a {@link FacebookError}.
 * 
 * @author Donato Rimenti
 * @date Dec 18, 2016
 */
public class FacebookErrorMessage implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The error from Facebook.
	 */
	private FacebookError error;

	/**
	 * Gets the {@link #error}.
	 *
	 * @return the {@link #error}.
	 */
	public FacebookError getError() {
		return error;
	}

	/**
	 * Sets the {@link #error}.
	 *
	 * @param error
	 *            the {@link #error} to set.
	 */
	public void setError(FacebookError error) {
		this.error = error;
	}

}
