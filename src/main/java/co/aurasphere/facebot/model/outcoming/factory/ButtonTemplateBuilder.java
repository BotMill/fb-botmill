package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.outcoming.payload.ButtonTemplatePayload;
import co.aurasphere.facebot.model.outcoming.payload.Payload;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class ButtonTemplateBuilder<T extends PayloadDelegatorBuilder> extends ButtonBuilder {

	private String text;
	
	private T parentBuilder;
	
	ButtonTemplateBuilder(String text, T parentBuilder){
		FaceBotValidator.shorterThanNotEmpty(text, FaceBotConstants.MESSAGE_MAX_LENGTH, "Text");
		FaceBotValidator.notNull(parentBuilder, "Parent builder");
		this.text = text;
		this.parentBuilder = parentBuilder;
	}
	
	public T build(){
		FaceBotValidator.lessElementsThanNotEmpty(buttons, FaceBotConstants.BUTTONS_MAX_ELEMENTS, "Buttons");
		Payload payload = new ButtonTemplatePayload(buttons, text);
		parentBuilder.setPayload(payload);
		return parentBuilder;
	}
}
