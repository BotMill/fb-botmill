package co.aurasphere.botmill.fb.model.outcoming.payload;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.base.Payload;

/**
 * A {@link Payload} which contains an URL.
 * 
 * @author Donato Rimenti
 * 
 */
public class UrlPayload implements Payload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The URL associated with this payload.
	 */
	@NotBlank
	private String url;

	/**
	 * Instantiates a new UrlPayload.		
	 */
	public UrlPayload() {
	}

	/**
	 * Instantiates a new UrlPayload.
	 *
	 * @param url
	 *            the {@link #url}.
	 */
	public UrlPayload(String url) {
		this.url = url;
	}

	/**
	 * Gets the {@link #url}.
	 *
	 * @return the {@link #url}.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the {@link #url}.
	 *
	 * @param url
	 *            the {@link #url} to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
