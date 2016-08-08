package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;

public class Postback implements Serializable{
// messaging_postbacks callback
	private static final long serialVersionUID = 1L;

	private String payload;

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
