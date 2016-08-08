package co.aurasphere.facebot.model.configuration;

import java.io.Serializable;

/**
 * Object which represents a Greeting Text for Thread Settings.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class Greeting implements Serializable {

	private static final long serialVersionUID = 1L;

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
