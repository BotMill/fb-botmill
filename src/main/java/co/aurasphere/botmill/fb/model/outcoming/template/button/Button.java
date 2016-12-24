package co.aurasphere.botmill.fb.model.outcoming.template.button;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The Class Button.
 */
public abstract class Button implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The button type.
	 */
	@NotNull
	protected ButtonType type;
	
	/**
	 * The button title.
	 */
	@Size(max=20)
	@NotEmpty
	protected String title;

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
}
