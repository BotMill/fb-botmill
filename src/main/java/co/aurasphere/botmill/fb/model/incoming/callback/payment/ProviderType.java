package co.aurasphere.botmill.fb.model.incoming.callback.payment;

/**
 * Provider type for a {@link PaymentCredential} object.
 * 
 * @author Donato Rimenti
 * @date Dec 17, 2016
 */
public enum ProviderType {
	
	/**
	 * The stripe.
	 */
	STRIPE,
	
	/**
	 * The paypal.
	 */
	PAYPAL,
	
	/**
	 * The token.
	 */
	TOKEN;
}
