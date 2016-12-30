package co.aurasphere.botmill.fb.model.incoming.callback.payment;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Object that represents the total amount of a transaction for a
 * {@link Payment} callback.
 * 
 * @author Donato Rimenti
 * 
 */
public class PaymentAmount implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Currency of the amount.
	 */
	private String currency;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * Total amount.
	 */
	private BigDecimal amount;

	/**
	 * Gets the {@link #currency}.
	 *
	 * @return the {@link #currency}.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the {@link #currency}.
	 *
	 * @param currency the {@link #currency} to set.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the {@link #amount}.
	 *
	 * @return the {@link #amount}.
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the {@link #amount}.
	 *
	 * @param amount the {@link #amount} to set.
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
