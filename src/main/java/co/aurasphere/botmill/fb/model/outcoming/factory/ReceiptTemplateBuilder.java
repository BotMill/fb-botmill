package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ReceiptTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Address;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Adjustment;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.ReceiptTemplateElement;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Summary;

/**
 * A builder for a Receipt Template.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/receipt-template"
 *      > Facebook's Messenger Platform Receipt Template Documentation</a>
 * 
 * @author Donato Rimenti
 * @date Aug 25, 2016
 */
public class ReceiptTemplateBuilder extends TemplateBaseBuilder {

	/**
	 * The payload of the current builder.
	 */
	private ReceiptTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for a Receipt Template.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/receipt-template"
	 *      > Facebook's Messenger Platform Generic Receipt Documentation</a>
	 * 
	 */
	ReceiptTemplateBuilder(String recipientName, String orderNumber,
			String currency, String paymentMethod) {
		this.payload = new ReceiptTemplatePayload();
		this.payload.setRecipientName(recipientName);
		this.payload.setOrderNumber(orderNumber);
		this.payload.setCurrency(currency);
		this.payload.setPaymentMethod(paymentMethod);
		this.messageBuilder = new AttachmentMessageBuilder(
				AttachmentType.TEMPLATE, this.payload);
	}

	/**
	 * Sets the merchant name. If present this is shown as logo text.
	 * 
	 * @param merchantName
	 *            the merchant name to set.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder setMerchantName(String merchantName) {
		this.payload.setMerchantName(merchantName);
		return this;
	}

	/**
	 * Sets the timestamp of the order, in seconds.
	 * 
	 * @param timestamp
	 *            the timestamp to set.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder setTimestamp(String timestamp) {
		this.payload.setTimestamp(timestamp);
		return this;
	}

	/**
	 * Sets the URL of order.
	 * 
	 * @param orderUrl
	 *            the URL of order to set.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder setOrderUrl(String orderUrl) {
		this.payload.setOrderUrl(orderUrl);
		return this;
	}

	/**
	 * Adds a {@link ReceiptTemplateElement} to this template. This field can't
	 * be empty. The elements must be at most 100 and the sorting is not
	 * guaranteed.
	 * 
	 * @param element
	 *            the element to add.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder addElement(ReceiptTemplateElement element) {
		this.payload.addElement(element);
		return this;
	}

	/**
	 * Adds a {@link ReceiptTemplateElement} to this template. This field can't
	 * be empty. The elements must be at most 100 and the sorting is not
	 * guaranteed.
	 * 
	 * @param title
	 *            the title of the item. This field is mandatory and can't be
	 *            empty or null.
	 * @return a {@link ReceiptTemplateElementBuilder} for building the element.
	 */
	public ReceiptTemplateElementBuilder addElement(String title) {
		return new ReceiptTemplateElementBuilder(title, this);
	}

	/**
	 * The shipping address. The address is optional. If you do not ship an
	 * item, you may omit these fields.
	 * 
	 * @param address
	 *            the address to set.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder setAddress(Address address) {
		this.payload.setAddress(address);
		return this;
	}

	/**
	 * The shipping address. The address is optional. If you do not ship an
	 * item, you may omit these fields.
	 * 
	 * @return an {@link AddressBuilder} to build the address.
	 */
	public AddressBuilder setAddress() {
		return new AddressBuilder(this);
	}

	/**
	 * Sets the payment {@link Summary}. This field is required and can't be
	 * null.
	 * 
	 * @param summary
	 *            the summary to set.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder setSummary(Summary summary) {
		this.payload.setSummary(summary);
		return this;
	}

	/**
	 * Sets the payment {@link Summary}. This field is required and can't be
	 * null. These numbers should be valid and well formatted decimal numbers,
	 * using '.' (dot) as the decimal separator. Note that most currencies only
	 * accept up to 2 decimal places.
	 * 
	 * @param subtotal
	 *            the subtotal.
	 * @param shippingCost
	 *            the cost of the shipping.
	 * @param totalTax
	 *            the total tax.
	 * @param totalCost
	 *            the total cost.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder setSummary(double subtotal,
			double shippingCost, double totalTax, double totalCost) {
		Summary summary = new Summary(subtotal, shippingCost, totalTax,
				totalCost);
		return this.setSummary(summary);
	}

	/**
	 * Adds an {@link Adjustment} to this builder. Adjustments allow a way to
	 * insert adjusted pricing (e.g., sales). Adjustments are optional.
	 * 
	 * @param adjustment
	 *            the adjustment to add.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder addAdjustment(Adjustment adjustment) {
		this.payload.addAdjustment(adjustment);
		return this;
	}

	/**
	 * Adds an {@link Adjustment} to this builder. Adjustments allow a way to
	 * insert adjusted pricing (e.g., sales). Adjustments are optional.
	 * 
	 * @param name
	 *            the name of the adjustment.
	 * @param amount
	 *            the amount of the adjustment.
	 * @return this builder.
	 */
	public ReceiptTemplateBuilder addAdjustment(String name, double amount) {
		Adjustment adjustment = new Adjustment(name, amount);
		return this.addAdjustment(adjustment);
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
	public ReceiptTemplateBuilder addQuickReply(String title, String payload) {
		this.messageBuilder.addQuickReply(title, payload);
		return this;
	}

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
	public ReceiptTemplateBuilder addQuickReply(QuickReply reply) {
		this.messageBuilder.addQuickReply(reply);
		return this;
	}

	/**
	 * {@inheritDoc} Creates a response containing a Receipt Template.
	 */
	@Override
	public FbBotMillResponse build(MessageEnvelope envelope) {
		return this.messageBuilder.build(envelope);
	}

}
