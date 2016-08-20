package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.template.generic.GenericTemplateElement;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class GenericTemplateMessageBuilder extends PayloadDelegatorBuilder {
	
	private GenericTemplateBuilder<GenericTemplateMessageBuilder> builder;
	
	GenericTemplateMessageBuilder(){
		this.builder = new GenericTemplateBuilder<GenericTemplateMessageBuilder>(this);
	}
	
	public GenericTemplateElementBuilder addElement(String title){
		return builder.addElement(title);
	}
	
	public GenericTemplateMessageBuilder addElement(GenericTemplateElement element){
		FaceBotValidator.notNull(element, "GenericTemplateElement");
		builder.addElement(element);
		return this;
	}

	public FaceBotResponse build(MessageEnvelope envelope) {
		builder.build();
		return new AttachmentMessageBuilder(AttachmentType.TEMPLATE, this.payload).build(envelope);
	}
	
}
