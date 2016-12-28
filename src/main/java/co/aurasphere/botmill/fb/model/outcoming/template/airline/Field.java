package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;


/**
 * The Class Field.
 */
public class Field implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The label. */
	@NotBlank
	private String label;
	
	/** The value. */
	@NotBlank
	private String value;
	
	/**
	 * Instantiates a new field.
	 *
	 * @param label the label
	 * @param value the value
	 */
	public Field(String label, String value){
		this.label = label;
		this.value = value;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
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
