package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;

/**
 * Represents an account linking incoming event.
 * @author Donato
 * @date 08/ago/2016
 */
public class AccountLinking implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * May be linked or unlinked.
	 */
	private String status;
	
	/**
	 * The authorization code for the user.
	 */
	private String authorization_code;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuthorization_code() {
		return authorization_code;
	}

	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
}
