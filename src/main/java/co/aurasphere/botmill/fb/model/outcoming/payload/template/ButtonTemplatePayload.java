package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;
import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;

/**
 * Payload for a Button Template.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/button-template"
 *      > Facebook's Messenger Platform Button Template Documentation</a>
 *
 * @author Donato Rimenti
 * 
 */
public class ButtonTemplatePayload extends TemplateBasePayload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * UTF-8 encoded text of up to 320 characters that appears the in main body.
	 */
	@Size(max = FbBotMillValidationConstants.MESSAGE_MAX_LENGTH)
	@NotBlank
	private String text;

	/**
	 * Set of, one to three, buttons that appear as call-to-actions.
	 */
	@Valid
	@Size(max = FbBotMillValidationConstants.BUTTONS_MAX_ELEMENTS)
	@NotEmpty
	private List<Button> buttons;

	/**
	 * Instantiates a new ButtonTemplatePayload.
	 *
	 * @param text
	 *            the {@link #text}.
	 */
	public ButtonTemplatePayload(String text) {
		this.text = text;
		this.buttons = new ArrayList<Button>();
		this.templateType = PayloadType.BUTTON;
	}

	/**
	 * Instantiates a new ButtonTemplatePayload.
	 */
	public ButtonTemplatePayload() {
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
	 * @param text
	 *            the {@link #text} to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the {@link #buttons}.
	 *
	 * @return the {@link #buttons}.
	 */
	public List<Button> getButtons() {
		return buttons;
	}

	/**
	 * Sets the {@link #buttons}.
	 *
	 * @param buttons
	 *            the {@link #buttons} to set.
	 */
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	/**
	 * Adds the button.
	 *
	 * @param button
	 *            the button to add.
	 */
	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
