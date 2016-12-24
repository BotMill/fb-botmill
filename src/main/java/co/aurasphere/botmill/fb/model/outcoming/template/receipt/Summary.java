package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

// TODO: change double with BigDecimal?
// TODO: notEmpty should be changed with notBlank
// TODO: two decimal digits with "." as separator
public class Summary implements Serializable {

	private static final long serialVersionUID = 1L;

	private double subtotal;

	@SerializedName("shipping_cost")
	private double shippingCost;

	@SerializedName("total_tax")
	private double totalTax;

	@SerializedName("total_cost")
	private double totalCost;

	public Summary() {
	}

	public Summary(double subtotal, double shippingCost, double totalTax,
			double totalCost) {
		this.subtotal = subtotal;
		this.shippingCost = shippingCost;
		this.totalTax = totalTax;
		this.totalCost = totalCost;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
