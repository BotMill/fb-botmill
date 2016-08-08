package co.aurasphere.facebot.model.outcoming.template.button;

import java.io.Serializable;

public abstract class Button implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * The button type.
	 */
	protected ButtonType type;
	
	/**
	 * The button title. This field has a limit of 20 character.
	 */
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
