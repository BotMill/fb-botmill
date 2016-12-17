package co.aurasphere.facebot.model.incoming.callback.payment;

import co.aurasphere.facebot.model.outcoming.template.button.BuyButton;
import co.aurasphere.facebot.model.outcoming.template.button.RequestedUserInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Model for the Payment Callback. <br/>
 * <br/>
 * This callback occurs when a persons taps the pay button from the checkout
 * dialog rendered by the {@link BuyButton}. It contains the requested user
 * information as well as payment credentials. Depends on the payment provider
 * you use, the payment credential will differ. <br/>
 * <br/>
 * You must subscribe to this callback by selecting the messaging_payments field
 * when setting up your webhook.
 * 
 * <h1>Stripe/Paypal</h1>
 * 
 * After user click on pay, user will be charged directly and the payment will
 * be send to your Stripe/Paypal account. This webhook event will be called once
 * the process succeed. All the requested user information that user entered in
 * the payment dialog will be passed back in the webhook event. The charge_id
 * from Paypal/Stripe will be passed to you for tracking the payment. You need
 * to return HTTP status of 200 once you finished processing the event. <br/>
 * <br/>
 * If the payment is a test payment, we will not charge the card but will send a
 * result with dummy fb_payment_id/charge_id to you. You can do test payment
 * with Stripe/Paypal only if your page has payment permission for now. Refers
 * to <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#test_payments"
 * >How to Test Payment</a> for details. <br/>
 * 
 * <h1>Tokenized Payment</h1>
 * 
 * If you are using tokenized payment, when user click on pay, we will send you
 * a single-use Discover virtual card provisioned by PayPal. The card credential
 * will be encrypted by the public key you provided in previous steps. You can
 * then decrypt the tokenized card by following the <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#decrypting"
 * >detail steps here</a>. After you successfully decoded the credential, you
 * can then integrate with your preferred payment provider to charge the card.
 * You need to return HTTP status of 200 once you finished processing the event.<br/>
 * </br> If the payment is a test payment, you will get a dummy tokenized card
 * back with the following dummy information (card_number: 4111111111111111,
 * cvv: 123, expiry month: 11, expiry year: 2020). You can test tokenized
 * payment even if your page/app has not been accepted to beta program. Refers
 * to <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#test_payments"
 * >How to Test Payment</a> for details. <br/>
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/payment"
 *      >Facebook's Messenger Platform Payment Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/buy-button"
 *      >Facebook's Messenger Platform Buy Button Documentation</a>
 * @author Donato Rimenti
 * @date Dec 4, 2016
 */
public class Payment {

	/**
	 * Metadata defined in the Buy Button.
	 */
	private String payload;

	/**
	 * Information that was requested from the user by the Buy Button.
	 */
	@SerializedName("requested_user_info")
	private RequestedUserInfo requestedUserInfo;

	/**
	 * Payment credentials.
	 */
	@SerializedName("payment_credential")
	private PaymentCredential paymentCredential;

	/**
	 * Total amount of transaction.
	 */
	private PaymentAmount amount;

	/**
	 * The option_id of the selected shipping option sent via the checkout
	 * update callback. Only applicable for flexible payments.
	 */
	@SerializedName("shipping_option_id")
	private String shippingOptionId;

	/**
	 * Gets the metadata defined in the Buy Button.
	 * 
	 * @return the metadata defined in the Buy Button.
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the metadata defined in the Buy Button.
	 * 
	 * @param payload
	 *            metadata defined in the Buy Button to set.
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the information that was requested from the user by the Buy Button.
	 * 
	 * @return the requested user info.
	 */
	public RequestedUserInfo getRequestedUserInfo() {
		return requestedUserInfo;
	}

	/**
	 * Sets the information that was requested from the user by the Buy Button.
	 * 
	 * @param requestedUserInfo
	 *            the requested user info to set.
	 */
	public void setRequestedUserInfo(RequestedUserInfo requestedUserInfo) {
		this.requestedUserInfo = requestedUserInfo;
	}

	/**
	 * Gets the payment credentials.
	 * 
	 * @return the payment credentials.
	 */
	public PaymentCredential getPaymentCredential() {
		return paymentCredential;
	}

	/**
	 * Sets the payment credentials.
	 * 
	 * @param paymentCredential
	 *            the payment credentials to set.
	 */
	public void setPaymentCredential(PaymentCredential paymentCredential) {
		this.paymentCredential = paymentCredential;
	}

	/**
	 * Gets the total amount of transaction.
	 * 
	 * @return the total amount of transaction.
	 */
	public PaymentAmount getAmount() {
		return amount;
	}

	/**
	 * Sets the total amount of transaction.
	 * 
	 * @param amount
	 *            the total amount of transaction to set.
	 */
	public void setAmount(PaymentAmount amount) {
		this.amount = amount;
	}

	/**
	 * Gets the option_id of the selected shipping option sent via the checkout
	 * update callback. Only applicable for flexible payments.
	 * 
	 * @return the shipping option ID.
	 */
	public String getShippingOptionId() {
		return shippingOptionId;
	}

	/**
	 * Sets the option_id of the selected shipping option sent via the checkout
	 * update callback. Only applicable for flexible payments.
	 * 
	 * @param shippingOptionId
	 *            the shipping option ID to set.
	 */
	public void setShippingOptionId(String shippingOptionId) {
		this.shippingOptionId = shippingOptionId;
	}

}
