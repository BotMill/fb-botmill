package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.outcoming.template.receipt.ReceiptTemplateElement;


/**
 * Builder for a {@link ReceiptTemplateElement}.
 * 
 * @author Donato Rimenti
 * @date Nov 25, 2016
 */
public class ReceiptTemplateElementBuilder {

	/**
	 * The parent builder of this builder.
	 */
	private ReceiptTemplateBuilder parentBuilder;

	/**
	 * The element managed by this builder.
	 */
	private ReceiptTemplateElement element;

	/**
	 * Default constructor. Creates a builder for a
	 * {@link ReceiptTemplateElement}.
	 * 
	 * @param title
	 *            the title of the item. This field is mandatory and can't be
	 *            empty or null.
	 * @param parentBuilder
	 *            the parent builder of this builder.
	 */
	ReceiptTemplateElementBuilder(String title,
			ReceiptTemplateBuilder parentBuilder) {
		this.element = new ReceiptTemplateElement();
		this.element.setTitle(title);
		this.parentBuilder = parentBuilder;
	}

	/**
	 * Sets a subtitle for the item.
	 * 
	 * @param subtitle
	 *            the subtitle to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setSubtitle(String subtitle) {
		this.element.setSubtitle(subtitle);
		return this;
	}

	/**
	 * Sets a quantity of item.
	 * 
	 * @param quantity
	 *            the quantity to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setQuantity(int quantity) {
		this.element.setQuantity(quantity);
		return this;
	}

	/**
	 * Sets the item price. This field is mandatory and can't be empty but 0 is
	 * allowed.
	 * 
	 * @param price
	 *            the item price to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setPrice(double price) {
		this.element.setPrice(price);
		return this;
	}

	/**
	 * Sets the currency of price.
	 * 
	 * @param currency the currency of price to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setCurrency(String currency) {
		this.element.setCurrency(currency);
		return this;
	}

	/**
	 * Sets the image URL of item.
	 * @param imageUrl the image URL of item to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setImageUrl(String imageUrl) {
		this.element.setImageUrl(imageUrl);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public ReceiptTemplateBuilder endElement() {
		this.parentBuilder.addElement(this.element);
		return parentBuilder;
	}

}
