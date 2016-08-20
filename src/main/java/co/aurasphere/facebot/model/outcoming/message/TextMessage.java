package co.aurasphere.facebot.model.outcoming.message;


public class TextMessage extends Message {

	private static final long serialVersionUID = 1L;

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
