package co.aurasphere.facebot.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.payload.PayloadType;
import co.aurasphere.facebot.model.outcoming.template.generic.GenericTemplateElement;

public class GenericTemplatePayload extends TemplateBasePayload {

	private static final long serialVersionUID = 1L;

	@Valid
	@Size(max=10)
	@NotEmpty
	private List<GenericTemplateElement> elements;
	
	public GenericTemplatePayload(){
		this.templateType = PayloadType.GENERIC;
		this.elements = new ArrayList<GenericTemplateElement>();
	}
	
	public GenericTemplatePayload(List<GenericTemplateElement> elements){
		this();
		this.elements = elements;
	}

	public List<GenericTemplateElement> getElements() {
		return elements;
	}

	public void setElements(List<GenericTemplateElement> elements) {
		this.elements = elements;
	}

	public void addElement(GenericTemplateElement element) {
		this.elements.add(element);
	}
}
