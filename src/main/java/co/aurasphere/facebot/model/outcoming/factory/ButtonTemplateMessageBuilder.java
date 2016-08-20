package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.util.FaceBotConstants;

/**
 * A builder for a Button Template.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/button-template"
 *      > Facebook's Messenger Platform Button Template Documentation</a>
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class ButtonTemplateMessageBuilder extends PayloadDelegatorBuilder {

	private ButtonTemplateBuilder<ButtonTemplateMessageBuilder> builder;

	ButtonTemplateMessageBuilder(String text) {
		builder = new ButtonTemplateBuilder<ButtonTemplateMessageBuilder>(text,
				this);
	}

	/**
	 * Adds a button that opens a web page when clicked.
	 * 
	 * @param title
	 *            the label of the button. Must be shorter than
	 *            {@value FaceBotConstants#BUTTON_TITLE_MAX_LENGTH} and not
	 *            empty.
	 * @param url
	 *            the url of the web page to open. Must be not null.
	 * @return this builder.
	 */
	public ButtonTemplateMessageBuilder addUrlButton(String title, String url) {
		builder.addUrlButtonInternal(title, url);
		return this;
	}

	public ButtonTemplateMessageBuilder addPhoneNumberButton(String title,
			String phoneNumber) {
		builder.addPhoneNumberButtonInternal(title, phoneNumber);
		return this;
	}

	public ButtonTemplateMessageBuilder addPostbackButton(String title,
			String payload) {
		builder.addPostbackButtonInternal(title, payload);
		return this;
	}

	public ButtonTemplateMessageBuilder addButton(Button button) {
		builder.addButtonInternal(button);
		return this;
	}

	public FaceBotResponse build(MessageEnvelope envelope) {
		builder.build();
		return new AttachmentMessageBuilder(AttachmentType.TEMPLATE,
				this.payload).build(envelope);
	}

}
