package co.aurasphere.facebot.model.outcoming.message;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class TextMessage extends Message {

	private static final long serialVersionUID = 1L;

	@Size(max = 320)
	@NotEmpty
	private String text;

	public TextMessage(String message) {
		this.text = message;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
