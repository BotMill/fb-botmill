package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

public class ReceiptTemplateElement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String title;
	
	private String subtitle;
	
	private int quantity;
	
	@NotNull
	private double price;
	
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;
	
	@SerializedName("image_url")
	private String imageUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
