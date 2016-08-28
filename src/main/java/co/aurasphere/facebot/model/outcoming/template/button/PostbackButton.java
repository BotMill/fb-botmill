package co.aurasphere.facebot.model.outcoming.template.button;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class PostbackButton extends Button {

	private static final long serialVersionUID = 1L;

	/**
	 * For postback buttons, this data will be sent back to you via webhook. For
	 * phone_number buttons, this must be a well formatted phone number i.e.
	 * must be '+' prefix followed by the country code, area code and local
	 * number.
	 */
	@Size(max = 1000)
	@NotEmpty
	private String payload;

	public PostbackButton(String title, ButtonType type, String payload) {
		this.title = title;
		this.type = type;
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
