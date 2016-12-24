package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;


/**
 * The Class ButtonTemplatePayload.
 *
 * @author Donato Rimenti
 * @date Dec 24, 2016
 */
public class ButtonTemplatePayload extends TemplateBasePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text. */
	@NotBlank
	private String text;

	/** The buttons. */
	@Valid
	@Size(max=3)
	@NotEmpty
	private List<Button> buttons;
	
	/**
	 * Instantiates a new button template payload.
	 *
	 * @param text the text
	 */
	public ButtonTemplatePayload(String text){
		this.text = text;
		this.buttons = new ArrayList<Button>();
		this.templateType = PayloadType.BUTTON;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the buttons.
	 *
	 * @return the buttons
	 */
	public List<Button> getButtons() {
		return buttons;
	}

	/**
	 * Sets the buttons.
	 *
	 * @param buttons the new buttons
	 */
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	/**
	 * Adds the button.
	 *
	 * @param button the button
	 */
	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
