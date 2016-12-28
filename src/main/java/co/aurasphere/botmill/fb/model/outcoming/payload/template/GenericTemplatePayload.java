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
 * @date Dec 24, 2016
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
}
