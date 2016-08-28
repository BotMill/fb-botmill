package co.aurasphere.facebot.model.threadsettings;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Object which represents a Greeting Text for Thread Settings.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class Greeting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(max=160)
	@NotEmpty
	private String text;

	public Greeting(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
