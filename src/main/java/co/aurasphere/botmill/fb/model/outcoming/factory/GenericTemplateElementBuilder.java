/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentSummary;
import co.aurasphere.botmill.fb.model.outcoming.template.generic.GenericTemplateElement;

/**
 * Builder for a {@link GenericTemplateElement}.
 * 
 * @author Donato Rimenti
 * 
 */
public class GenericTemplateElementBuilder {

	/**
	 * The parent builder of this builder.
	 */
	private GenericTemplateBuilder parentBuilder;

	/**
	 * The element managed by this builder.
	 */
	private GenericTemplateElement element;

	/**
	 * Default constructor. Creates a builder for a
	 * {@link GenericTemplateElement}.
	 * 
	 * @param title
	 *            the title of the element.
	 * @param parentBuilder
	 *            the parent builder of this builder.
	 */
	GenericTemplateElementBuilder(String title,
			GenericTemplateBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.element = new GenericTemplateElement(title);
	}

	/**
	 * Sets a subtitle for the current {@link GenericTemplateElement}.
	 * 
	 * @param subtitle
	 *            the subtitle to set.
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder setSubtitle(String subtitle) {
		element.setSubtitle(subtitle);
		return this;
	}

	/**
	 * Sets an image for the current {@link GenericTemplateElement}.
	 *
	 * @param imageUrl
	 *            the image url
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder setImage(String imageUrl) {
		element.setImageUrl(imageUrl);
		return this;
	}

	/**
	 * Sets an URL for the current {@link GenericTemplateElement}. The URL will
	 * be used to redirect the user when the element is clicked.
	 *
	 * @param itemUrl
	 *            the item url
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder setRedirectUrl(String itemUrl) {
		element.setItemUrl(itemUrl);
		return this;
	}

	/**
	 * Adds a button which redirects to an URL when clicked to the current
	 * {@link GenericTemplateElement}. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param title
	 *            the button label.
	 * @param url
	 *            the URL to whom redirect when clicked.
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addUrlButton(String title, String url) {
		Button button = ButtonFactory.createUrlButton(title, url);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a button with a phone number to the current
	 * {@link GenericTemplateElement}. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param title
	 *            the button label.
	 * @param phoneNumber
	 *            a phone number. Must be in the format '+' prefix followed by
	 *            the country code, area code and local number.
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addPhoneNumberButton(String title,
			String phoneNumber) {
		Button button = ButtonFactory.createPhoneNumberButton(title,
				phoneNumber);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a button which sends a payload back when clicked to the current
	 * {@link GenericTemplateElement}. There can be at most 3 buttons per
	 * element.
	 * 
	 * @param title
	 *            the button label.
	 * @param payload
	 *            the payload to send back when clicked.
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addPostbackButton(String title,
			String payload) {
		Button button = ButtonFactory.createPostbackButton(title, payload);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a button to the current {@link GenericTemplateElement}. There can be
	 * at most 3 buttons per element.
	 * 
	 * @param button
	 *            the button to add.
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addButton(Button button) {
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a share button on a generic template.
	 *
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addShareButton() {
		Button button = ButtonFactory.createShareButton();
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a login button on a generic template.
	 *
	 * @param url
	 *            the url
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addLoginButton(String url) {
		Button button = ButtonFactory.createLoginButton(url);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a logout button on a generic template.
	 *
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addLogoutButton() {
		Button button = ButtonFactory.createLogoutButton();
		this.element.addButton(button);
		return this;
	}

	/**
	 * Adds a buy button on a generic template.
	 * 
	 * @param payload
	 *            the payload
	 * @param paymentSummary
	 *            the payment summary
	 * @return this builder.
	 */
	public GenericTemplateElementBuilder addBuyButton(String payload,
			PaymentSummary paymentSummary) {
		Button button = ButtonFactory.createBuyButton(payload, paymentSummary);
		this.element.addButton(button);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public GenericTemplateBuilder endElement() {
		parentBuilder.addElement(element);
		return parentBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenericTemplateElementBuilder [parentBuilder=" + parentBuilder
				+ ", element=" + element + "]";
	}

}
