package co.aurasphere.facebot.model.base;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * An object that contains a Facebook's user ID.
 * @author Donato
 * @date 31/lug/2016
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * The Facebook's user ID.
	 */
	@NotEmpty
	private String id;
	
	public User(){}

	public User(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
