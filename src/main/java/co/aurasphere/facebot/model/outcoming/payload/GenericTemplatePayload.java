package co.aurasphere.facebot.model.outcoming.payload;

import java.util.List;

import co.aurasphere.facebot.model.outcoming.template.generic.GenericTemplateElement;

public class GenericTemplatePayload extends TemplateBasePayload {

	private static final long serialVersionUID = 1L;

	private List<GenericTemplateElement> elements;
	
	public GenericTemplatePayload(List<GenericTemplateElement> elements){
		this.templateType = PayloadType.GENERIC;
		this.elements = elements;
	}

	public List<GenericTemplateElement> getElements() {
		return elements;
	}

	public void setElements(List<GenericTemplateElement> elements) {
		this.elements = elements;
	}
}
