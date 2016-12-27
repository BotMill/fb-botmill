package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

// TODO: notEmpty should be changed with notBlank
// TODO: two decimal digits with "." as separator
public class Summary implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal subtotal;

	@SerializedName("shipping_cost")
	private BigDecimal shippingCost;

	@SerializedName("total_tax")
	private BigDecimal totalTax;

	@SerializedName("total_cost")
	private BigDecimal totalCost;

	public Summary() {
	}

	public Summary(BigDecimal subtotal, BigDecimal shippingCost, BigDecimal totalTax,
			BigDecimal totalCost) {
		this.subtotal = subtotal;
		this.shippingCost = shippingCost;
		this.totalTax = totalTax;
		this.totalCost = totalCost;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

}
