package co.aurasphere.facebot.model.incoming;

import java.io.Serializable;

public class FacebookErrorMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private FacebookError error;

	public FacebookError getError() {
		return error;
	}

	public void setError(FacebookError error) {
		this.error = error;
	}

}
