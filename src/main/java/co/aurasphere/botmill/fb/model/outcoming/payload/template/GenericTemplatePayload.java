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
import co.aurasphere.botmill.fb.model.outcoming.template.generic.GenericTemplateElement;

/**
 * Payload for a Generic Template.
 * 
 * * @see <a href=
 * "https://developers.facebook.com/docs/messenger-platform/send-api-reference/generic-template"
 * > Facebook's Messenger Platform Generic Template Documentation</a>
 * 
 * @author Donato Rimenti
 * 
 */
public class GenericTemplatePayload extends TemplateBasePayload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Data for each bubble in message. Elements are limited to
	 * {@value FbBotMillValidationConstants#GENERIC_TEMPLATE_MAX_ELEMENTS}.
	 */
	@Valid
	@Size(max = FbBotMillValidationConstants.GENERIC_TEMPLATE_MAX_ELEMENTS)
	@NotEmpty
	private List<GenericTemplateElement> elements;

	/**
	 * Instantiates a new GenericTemplatePayload.
	 */
	public GenericTemplatePayload() {
		this.templateType = PayloadType.GENERIC;
		this.elements = new ArrayList<GenericTemplateElement>();
	}

	/**
	 * Instantiates a new GenericTemplatePayload.
	 *
	 * @param elements
	 *            the {@link #elements}.
	 */
	public GenericTemplatePayload(List<GenericTemplateElement> elements) {
		this();
		this.elements = elements;
	}

	/**
	 * Gets the {@link #elements}.
	 *
	 * @return the {@link #elements}.
	 */
	public List<GenericTemplateElement> getElements() {
		return elements;
	}

	/**
	 * Sets the {@link #elements}.
	 *
	 * @param elements
	 *            the {@link #elements} to set.
	 */
	public void setElements(List<GenericTemplateElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds the element.
	 *
	 * @param element
	 *            the element to add.
	 */
	public void addElement(GenericTemplateElement element) {
		this.elements.add(element);
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
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
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
		GenericTemplatePayload other = (GenericTemplatePayload) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
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
		return "GenericTemplatePayload [elements=" + elements
				+ ", templateType=" + templateType + "]";
	}
}
