package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class PriceInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String title;
	
	private BigDecimal amount;
	
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;

	public PriceInfo(String title, BigDecimal amount) {
		this.title = title;
		this.amount = amount;
	}

	public PriceInfo(String title, BigDecimal amount, String currency) {
		this(title, amount);
		this.currency = currency;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
