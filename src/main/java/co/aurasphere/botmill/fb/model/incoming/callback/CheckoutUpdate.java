package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;

import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;

import com.google.gson.annotations.SerializedName;


/**
 * Model for a checkout update callback. <br/>
 * <br/>
 * This callback enables you to update pricing for flexible-amount transactions
 * on the checkout dialog displayed by the {@link BuyButton}. <br/>
 * <br/>
 * After the Buy Button is tapped, a call is made to the webhook containing the
 * person's shipping address. This enables you to update pricing with shipping
 * and taxes based on a person's location. This callback is made each time the
 * shipping address is changed. <br/>
 * <br/>
 * You can subscribe to this callback by selecting the
 * messaging_checkout_updates field when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/checkout-update"
 *      >Facebook's Messenger Platform Checkout Update Callback
 *      Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/buy-button"
 *      >Facebook's Messenger Platform Buy Button Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * @date Dec 17, 2016
 */
public class CheckoutUpdate implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metadata defined in the {@link BuyButton}.
	 */
	private String payload;

	/**
	 * The person's shipping address.
	 */
	@SerializedName("shipping_address")
	private ShippingAddress shippingAddress;

	/**
	 * Gets the {@link #payload}.
	 *
	 * @return the {@link #payload}.
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the {@link #payload}.
	 *
	 * @param payload
	 *            the {@link #payload} to set.
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the {@link #shippingAddress}.
	 *
	 * @return the {@link #shippingAddress}.
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Sets the {@link #shippingAddress}.
	 *
	 * @param shippingAddress
	 *            the {@link #shippingAddress} to set.
	 */
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
