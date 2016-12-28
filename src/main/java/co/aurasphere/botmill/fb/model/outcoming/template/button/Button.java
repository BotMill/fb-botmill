package co.aurasphere.botmill.fb.model.outcoming.template.button;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
 * The Class Button.
 */
public abstract class Button implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The button type.
	 */
	@NotNull
	protected ButtonType type;	
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ButtonType getType() {
		return type;
	}
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(ButtonType type) {
		this.type = type;
	}
}
