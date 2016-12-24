package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The Class PriceInfo.
 */
public class PriceInfo implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The title. */
	@NotEmpty
	private String title;
	
	/** The amount. */
	private double amount;
	
	/** The currency. */
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;

	/**
	 * Instantiates a new price info.
	 *
	 * @param title the title
	 * @param amount the amount
	 */
	public PriceInfo(String title, double amount) {
		this.title = title;
		this.amount = amount;
	}

	/**
	 * Instantiates a new price info.
	 *
	 * @param title the title
	 * @param amount the amount
	 * @param currency the currency
	 */
	public PriceInfo(String title, double amount, String currency) {
		this(title, amount);
		this.currency = currency;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
