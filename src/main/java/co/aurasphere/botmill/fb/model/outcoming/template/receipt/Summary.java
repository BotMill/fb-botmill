package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;


// TODO: change double with BigDecimal?
// TODO: notEmpty should be changed with notBlank
/**
 * The Class Summary.
 */
// TODO: two decimal digits with "." as separator
public class Summary implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The subtotal. */
	private double subtotal;

	/** The shipping cost. */
	@SerializedName("shipping_cost")
	private double shippingCost;

	/** The total tax. */
	@SerializedName("total_tax")
	private double totalTax;

	/** The total cost. */
	@SerializedName("total_cost")
	private double totalCost;

	/**
	 * Instantiates a new summary.
	 */
	public Summary() {
	}

	/**
	 * Instantiates a new summary.
	 *
	 * @param subtotal the subtotal
	 * @param shippingCost the shipping cost
	 * @param totalTax the total tax
	 * @param totalCost the total cost
	 */
	public Summary(double subtotal, double shippingCost, double totalTax,
			double totalCost) {
		this.subtotal = subtotal;
		this.shippingCost = shippingCost;
		this.totalTax = totalTax;
		this.totalCost = totalCost;
	}

	/**
	 * Gets the subtotal.
	 *
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}

	/**
	 * Sets the subtotal.
	 *
	 * @param subtotal the new subtotal
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * Gets the shipping cost.
	 *
	 * @return the shipping cost
	 */
	public double getShippingCost() {
		return shippingCost;
	}

	/**
	 * Sets the shipping cost.
	 *
	 * @param shippingCost the new shipping cost
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * Gets the total tax.
	 *
	 * @return the total tax
	 */
	public double getTotalTax() {
		return totalTax;
	}

	/**
	 * Sets the total tax.
	 *
	 * @param totalTax the new total tax
	 */
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the total cost.
	 *
	 * @param totalCost the new total cost
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
