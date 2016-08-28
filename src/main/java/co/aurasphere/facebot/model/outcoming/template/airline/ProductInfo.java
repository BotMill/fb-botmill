package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String title;
	
	@NotEmpty
	private String value;
	
	public ProductInfo(String title, String value){
		this.title = title;
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
