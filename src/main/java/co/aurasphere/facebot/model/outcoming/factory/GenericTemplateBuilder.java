package co.aurasphere.facebot.model.outcoming.factory;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.model.outcoming.payload.GenericTemplatePayload;
import co.aurasphere.facebot.model.outcoming.payload.Payload;
import co.aurasphere.facebot.model.outcoming.template.generic.GenericTemplateElement;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class GenericTemplateBuilder<T extends PayloadDelegatorBuilder> extends FaceBotBean {
	
	private List<GenericTemplateElement> elements;
	
	private T parentBuilder;
	
	GenericTemplateBuilder(T parentBuilder){
		FaceBotValidator.notNull(parentBuilder, "Parent builder");
		this.elements = new ArrayList<GenericTemplateElement>();
		this.parentBuilder = parentBuilder;
	}
	
	public GenericTemplateElementBuilder addElement(String title){
		return new GenericTemplateElementBuilder(title, this);
	}
	
	public void addElement(GenericTemplateElement element){
		FaceBotValidator.notNull(element, "Generic Template Element");
		this.elements.add(element);
	}

	public T build() {
		FaceBotValidator.lessElementsThanNotEmpty(elements, FaceBotConstants.GENERIC_TEMPLATE_MAX_ELEMENTS, "Elements");
		Payload payload = new GenericTemplatePayload(elements);
		parentBuilder.setPayload(payload);
		return parentBuilder;
	}
	

}
