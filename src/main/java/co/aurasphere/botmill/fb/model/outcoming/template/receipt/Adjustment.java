package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;


/**
 * The Class Adjustment.
 */
public class Adjustment implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;
	
	/** The amount. */
	private double amount;
	
	/**
	 * Instantiates a new adjustment.
	 */
	public Adjustment(){}
	
	/**
	 * Instantiates a new adjustment.
	 *
	 * @param name the name
	 * @param amount the amount
	 */
	public Adjustment(String name, double amount){
		this.name = name;
		this.amount = amount;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	
}
