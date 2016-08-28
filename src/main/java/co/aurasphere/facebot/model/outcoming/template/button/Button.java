package co.aurasphere.facebot.model.outcoming.template.button;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class Button implements Serializable{

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

	public ButtonType getType() {
		return type;
	}

	public void setType(ButtonType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
