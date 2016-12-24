package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.generic.GenericTemplateElement;


/**
 * The Class GenericTemplatePayload.
 */
public class GenericTemplatePayload extends TemplateBasePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The elements. */
	@Valid
	@Size(max=10)
	@NotEmpty
	private List<GenericTemplateElement> elements;
	
	/**
	 * Instantiates a new generic template payload.
	 */
	public GenericTemplatePayload(){
		this.templateType = PayloadType.GENERIC;
		this.elements = new ArrayList<GenericTemplateElement>();
	}
	
	/**
	 * Instantiates a new generic template payload.
	 *
	 * @param elements the elements
	 */
	public GenericTemplatePayload(List<GenericTemplateElement> elements){
		this();
		this.elements = elements;
	}

	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public List<GenericTemplateElement> getElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements the new elements
	 */
	public void setElements(List<GenericTemplateElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds the element.
	 *
	 * @param element the element
	 */
	public void addElement(GenericTemplateElement element) {
		this.elements.add(element);
	}
}
