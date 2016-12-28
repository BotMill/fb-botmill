package co.aurasphere.botmill.fb.model.outcoming.template.button;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


/**
 * The Class PostbackButton.
 */
public class PostbackButton extends Button {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * For postback buttons, this data will be sent back to you via webhook. For
	 * phone_number buttons, this must be a well formatted phone number i.e.
	 * must be '+' prefix followed by the country code, area code and local
	 * number.
	 */
	@Size(max = 1000)
	@NotBlank
	private String payload;

	/**
	 * Instantiates a new postback button.
	 *
	 * @param title the title
	 * @param type the type
	 * @param payload the payload
	 */
	public PostbackButton(String title, ButtonType type, String payload) {
		this.title = title;
		this.type = type;
		this.payload = payload;
	}

	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload the new payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

}
