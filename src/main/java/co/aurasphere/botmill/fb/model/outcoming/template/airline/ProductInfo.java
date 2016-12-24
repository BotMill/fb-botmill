package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The Class ProductInfo.
 */
public class ProductInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The title. */
	@NotEmpty
	private String title;
	
	/** The value. */
	@NotEmpty
	private String value;
	
	/**
	 * Instantiates a new product info.
	 *
	 * @param title the title
	 * @param value the value
	 */
	public ProductInfo(String title, String value){
		this.title = title;
		this.value = value;
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
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
