package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class PriceInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String title;
	
	private double amount;
	
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;

	public PriceInfo(String title, double amount) {
		this.title = title;
		this.amount = amount;
	}

	public PriceInfo(String title, double amount, String currency) {
		this(title, amount);
		this.currency = currency;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
