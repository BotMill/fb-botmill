package co.aurasphere.botmill.fb.model.outcoming.template.button;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The Login Class/Object.
 *
 * @author Alvin Reyes
 * @date 27/Nov/2016
 */
public class LoginButton extends Button {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The url. */
	@NotEmpty
	private String url;
	
	
	/**
	 * Instantiates a new login button.
	 *
	 * @param type the type
	 * @param url the url
	 */
	public LoginButton(ButtonType type, String url) {
		this.type = type;
		this.url = url;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
