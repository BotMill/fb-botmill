package co.aurasphere.botmill.fb.model.outcoming.factory;


import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;


/**
 * Builder for a {@link ListTemplateElement}.
 * 
 * @author Alvin Reyes
 * @date Nov 27, 2016
 */
public class ListTemplateElementBuilder {

	/**
	 * The parent builder of this builder.
	 */
	private ListTemplateBuilder parentBuilder;

	/**
	 * The element managed by this builder.
	 */
	private ListTemplateElement element;

	/**
	 * Default constructor. Creates a builder for a
	 * {@link ListTemplateElement}.
	 * 
	 * @param title
	 *            the title of the element.
	 * @param parentBuilder
	 *            the parent builder of this builder.
	 */
	ListTemplateElementBuilder(String title, ListTemplateBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.element = new ListTemplateElement(title);
	}

	/**
	 * Sets a subtitle for the current {@link ListTemplateElement}.
	 * 
	 * @param subtitle
	 *            the subtitle to set.
	 * @return this builder.
	 */
	public ListTemplateElementBuilder setSubtitle(String subtitle) {
		element.setSubtitle(subtitle);
		return this;
	}

	/**
	 * Sets an image for the current {@link ListTemplateElement}.
	 *
	 * @param imageUrl the image url
	 * @return this builder.
	 */
	public ListTemplateElementBuilder setImage(String imageUrl) {
		element.setImageUrl(imageUrl);
		return this;
	}

	/**
	 * Adds a button which redirects to an URL when clicked to the current
	 * {@link ListTemplateElement}. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param title
	 *            the button label.
	 * @param url
	 *            the URL to whom redirect when clicked.
	 * @return this builder.
	 */
	public ListTemplateElementBuilder addUrlButton(String title, String url) {
		Button button = ButtonFactory.createUrlButton(title, url);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a button with a phone number to the current
	 * {@link ListTemplateElement}. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param title
	 *            the button label.
	 * @param phoneNumber
	 *            a phone number. Must be in the format '+' prefix followed by
	 *            the country code, area code and local number.
	 * @return this builder.
	 */
	public ListTemplateElementBuilder addPhoneNumberButton(String title, String phoneNumber) {
		Button button = ButtonFactory.createPhoneNumberButton(title, phoneNumber);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a button which sends a payload back when clicked to the current
	 * {@link ListTemplateElement}. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param title
	 *            the button label.
	 * @param payload
	 *            the payload to send back when clicked.
	 * @return this builder.
	 */
	public ListTemplateElementBuilder addPostbackButton(String title, String payload) {
		Button button = ButtonFactory.createPostbackButton(title, payload);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a button to the current {@link ListTemplateElement}. There can be
	 * at most 3 buttons per element.
	 * 
	 * @param button
	 *            the button to add.
	 * @return this builder.
	 */
	public ListTemplateElementBuilder addButton(Button button) {
		this.element.addButton(button);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public ListTemplateBuilder endElement() {
		parentBuilder.addElement(element);
		return parentBuilder;
	}

}
