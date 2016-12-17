package co.aurasphere.facebot.model.incoming.callback.payment;

import java.math.BigDecimal;

/**
 * Object that represents the total amount of a transaction for a
 * {@link Payment} callback.
 * 
 * @author Donato Rimenti
 * @date Dec 4, 2016
 */
public class PaymentAmount {

	/**
	 * Currency of the amount.
	 */
	private String currency;

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
