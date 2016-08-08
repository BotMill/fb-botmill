package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.model.outcoming.template.generic.GenericTemplateElement;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.validator.FaceBotValidator;

@SuppressWarnings(value = "rawtypes")
public class GenericTemplateElementBuilder extends ButtonBuilder {
	
	private GenericTemplateBuilder parentBuilder;
	
	private String title;
	
	private String subtitle;
	
	private String itemUrl;
	
	private String imageUrl;
	
	GenericTemplateElementBuilder(String title, GenericTemplateBuilder parentBuilder){
		FaceBotValidator.notNull(parentBuilder, "Parent builder");
		FaceBotValidator.shorterThanNotEmpty(title, FaceBotConstants.GENERIC_TEMPLATE_TITLE_MAX_LENGHT, "Title");
		this.parentBuilder = parentBuilder;
		this.title = title;
	}
	
	public GenericTemplateElementBuilder addSubtitle(String subtitle){
		FaceBotValidator.shorterThan(subtitle, FaceBotConstants.GENERIC_TEMPLATE_SUBTITLE_MAX_LENGHT, "Subtitle");
		this.subtitle = subtitle;
		return this;
	}
	
	public GenericTemplateElementBuilder addImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
		return this;
	}
	
	public GenericTemplateElementBuilder addItemUrl(String itemUrl){
		this.itemUrl = itemUrl;
		return this;
	}

	public GenericTemplateElementBuilder addUrlButton(String title, String url) {
		addUrlButtonInternal(title, url);
		return this;
	}

	public GenericTemplateElementBuilder addPhoneNumberButton() {
		// TODO
		return null;
	}

	public GenericTemplateElementBuilder addPostbackButton(String title, String payload) {
		addPostbackButtonInternal(title, payload);
		return this;
	}
	
	public GenericTemplateElementBuilder addButton(Button button){
		addButtonInternal(button);
		return this;
	}
	
	public GenericTemplateBuilder build(){
		FaceBotValidator.lessElementsThan(buttons, FaceBotConstants.BUTTONS_MAX_ELEMENTS, "Buttons");
		FaceBotValidator.atLeastOneNotNull("Image URL, Subtitle, Buttons", imageUrl, subtitle, buttons);
		
		GenericTemplateElement element = new GenericTemplateElement(title);
		element.setSubtitle(subtitle);
		element.setItemUrl(itemUrl);
		element.setImageUrl(imageUrl);
		element.setButtons(buttons);
		
		parentBuilder.addElement(element);
		return parentBuilder;
	}

}
