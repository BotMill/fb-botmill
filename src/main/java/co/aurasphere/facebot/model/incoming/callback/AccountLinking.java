package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

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
	@SerializedName("authorization_code")
	private String authorizationCode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
}
