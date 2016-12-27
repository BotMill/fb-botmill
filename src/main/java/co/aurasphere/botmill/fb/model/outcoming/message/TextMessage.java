package co.aurasphere.botmill.fb.model.outcoming.message;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;


/**
 * A {@link Message} which contains text.
 * 
 * @author Donato Rimenti
 * @date Dec 24, 2016
 */
public class TextMessage extends Message {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The text of this message.
	 */
	@Size(max = FbBotMillValidationConstants.MESSAGE_MAX_LENGTH)
	@NotEmpty
	private String text;

	/**
	 * Instantiates a new TextMessage.
	 *
	 * @param text the {@link #text}.
	 */
	public TextMessage(String text) {
		this.text = text;
	}

	/**
	 * Gets the {@link #text}.
	 *
	 * @return the {@link #text}.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the {@link #text}.
	 *
	 * @param text the {@link #text} to set.
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
