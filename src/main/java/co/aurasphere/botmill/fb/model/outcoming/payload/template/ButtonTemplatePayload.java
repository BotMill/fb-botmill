/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buttons == null) ? 0 : buttons.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ButtonTemplatePayload other = (ButtonTemplatePayload) obj;
		if (buttons == null) {
			if (other.buttons != null)
				return false;
		} else if (!buttons.equals(other.buttons))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ButtonTemplatePayload [text=" + text + ", buttons=" + buttons
				+ ", templateType=" + templateType + "]";
	}
}
