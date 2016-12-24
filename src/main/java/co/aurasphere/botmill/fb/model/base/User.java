package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * An object that contains a Facebook's user ID.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class User implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Facebook's user ID.
	 */
	@NotEmpty
	private String id;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id the {@link #id}.
	 */
	public User(String id) {
		this.id = id;
	}

	/**
	 * Gets the {@link #id}.
	 *
	 * @return the {@link #id}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the {@link #id}.
	 *
	 * @param id the {@link #id} to set.
	 */
	public void setId(String id) {
		this.id = id;
	}
}
