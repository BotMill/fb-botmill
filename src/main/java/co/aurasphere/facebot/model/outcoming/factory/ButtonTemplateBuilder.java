package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.payload.template.ButtonTemplatePayload;
import co.aurasphere.facebot.model.outcoming.template.button.Button;

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
public class ButtonTemplateBuilder extends TemplateBaseBuilder {

	/**
	 * The payload of the current builder.
	 */
	private ButtonTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for a Button Template.
	 *
	 * @param text
	 *            the Button Template main text.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/button-template"
	 *      > Facebook's Messenger Platform Button Template Documentation</a>
	 * 
	 */
	ButtonTemplateBuilder(String text) {
		this.payload = new ButtonTemplatePayload(text);
		this.messageBuilder = new AttachmentMessageBuilder(
				AttachmentType.TEMPLATE, this.payload);
	}

	/**
	 * Adds a button which redirects to an URL when clicked to the current
	 * template. There can be at most 3 buttons.
	 * 
	 * @param title
	 *            the button label.
	 * @param url
	 *            the URL to whom redirect when clicked.
	 * @return this builder.
	 */
	public ButtonTemplateBuilder addUrlButton(String title, String url) {
		Button button = ButtonFactory.createUrlButton(title, url);
		this.payload.addButton(button);
		return this;
	}

	/**
	 * Adds a button with a phone number to the current template. There can be
	 * at most 3 buttons.
	 * 
	 * @param title
	 *            the button label.
	 * @param phoneNumber
	 *            a phone number.
	 * @return this builder.
	 */
	public ButtonTemplateBuilder addPhoneNumberButton(String title,
			String phoneNumber) {
		Button button = ButtonFactory.createPhoneNumberButton(title,
				phoneNumber);
		this.payload.addButton(button);
		return this;
	}

	/**
	 * Adds a button which sends a payload back when clicked to the current
	 * template. There can be at most 3 buttons.
	 * 
	 * @param title
	 *            the button label.
	 * @param payload
	 *            the payload to send back when clicked.
	 * @return this builder.
	 */
	public ButtonTemplateBuilder addPostbackButton(String title, String payload) {
		Button button = ButtonFactory.createPostbackButton(title, payload);
		this.payload.addButton(button);
		return this;
	}

	/**
	 * Adds a button to the current template. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param button
	 *            the button to add.
	 * @return this builder.
	 */
	public ButtonTemplateBuilder addButton(Button button) {
		this.payload.addButton(button);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param title
	 *            the quick reply button label. It can't be empty.
	 * @param payload
	 *            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 */
	// TODO: can't be used with button template.
	// public ButtonTemplateBuilder addQuickReply(String title, String payload)
	// {
	// this.messageBuilder.addQuickReply(title, payload);
	// return this;
	// }

	/**
	 * Adds a {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param reply
	 *            a quick reply object.
	 * @return this builder.
	 */

	// TODO: can't be used with button template.
	// public ButtonTemplateBuilder addQuickReply(QuickReply reply) {
	// this.messageBuilder.addQuickReply(reply);
	// return this;
	// }

	/**
	 * {@inheritDoc} Creates a response that contains a Button Template.
	 */
	public FaceBotResponse build(MessageEnvelope envelope) {
		return this.messageBuilder.build(envelope);
	}

}
