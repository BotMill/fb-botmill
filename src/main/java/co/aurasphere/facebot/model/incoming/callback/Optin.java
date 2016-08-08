package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;

public class Optin implements Serializable{
// messaging_optins callback.
	private static final long serialVersionUID = 1L;

	private String ref;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
