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

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;
import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;
import co.aurasphere.botmill.fb.model.outcoming.template.list.TopElementStyle;

import com.google.gson.annotations.SerializedName;

/**
 * Payload for a List Template.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/list-template"
 *      > Facebook's Messenger Platform List Template Documentation</a>
 * 
 * @author Alvin Reyes
 * 
 */
public class ListTemplatePayload extends TemplateBasePayload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * List view elements (maximum of 4 elements and minimum of 2 elements).
	 */
	@Valid
	@Size(min = FbBotMillValidationConstants.LIST_TEMPLATE_MIN_ELEMENTS, max = FbBotMillValidationConstants.LIST_TEMPLATE_MAX_ELEMENTS)
	@NotEmpty
	private List<ListTemplateElement> elements;

	/**
	 * List view elements (maximum of 4 elements and minimum of 2 elements).
	 */
	@Valid
	@Size(max = FbBotMillValidationConstants.LIST_TEMPLATE_MAX_BUTTONS)
	@NotEmpty
	private List<Button> buttons;

	/**
	 * Value must be large or compact. Default to large if not specified.
	 */
	@SerializedName("top_element_style")
	private TopElementStyle topElementStyle;

	/**
	 * Instantiates a new ListTemplatePayload.
	 */
	public ListTemplatePayload() {
		this.templateType = PayloadType.LIST;
		this.elements = new ArrayList<ListTemplateElement>();
		this.buttons = new ArrayList<Button>();
	}

	/**
	 * Instantiates a new ListTemplatePayload.
	 *
	 * @param elements
	 *            the {@link #elements}.
	 */
	public ListTemplatePayload(List<ListTemplateElement> elements) {
		this();
		this.elements = elements;
	}

	/**
	 * Instantiates a new ListTemplatePayload.
	 *
	 * @param elements
	 *            the {@link #elements}.
	 * @param buttons
	 *            the {@link #buttons}.
	 */
	public ListTemplatePayload(List<ListTemplateElement> elements,
			List<Button> buttons) {
		this();
		this.elements = elements;
		this.buttons = buttons;
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
	 * Gets the {@link #topElementStyle}.
	 *
	 * @return the {@link #topElementStyle}.
	 */
	public TopElementStyle getTopElementStyle() {
		return topElementStyle;
	}

	/**
	 * Sets the {@link #topElementStyle}.
	 *
	 * @param topElementStyle
	 *            the {@link #topElementStyle} to set.
	 */
	public void setTopElementStyle(TopElementStyle topElementStyle) {
		this.topElementStyle = topElementStyle;
	}

	/**
	 * Gets the {@link #elements}.
	 *
	 * @return the {@link #elements}.
	 */
	public List<ListTemplateElement> getElements() {
		return elements;
	}

	/**
	 * Sets the {@link #elements}.
	 *
	 * @param elements
	 *            the {@link #elements} to set.
	 */
	public void setElements(List<ListTemplateElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds the element.
	 *
	 * @param element
	 *            the element to add.
	 */
	public void addElement(ListTemplateElement element) {
		this.elements.add(element);
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
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
		result = prime * result
				+ ((topElementStyle == null) ? 0 : topElementStyle.hashCode());
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
		ListTemplatePayload other = (ListTemplatePayload) obj;
		if (buttons == null) {
			if (other.buttons != null)
				return false;
		} else if (!buttons.equals(other.buttons))
			return false;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		if (topElementStyle != other.topElementStyle)
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
		return "ListTemplatePayload [elements=" + elements + ", buttons="
				+ buttons + ", topElementStyle=" + topElementStyle
				+ ", templateType=" + templateType + "]";
	}
}
