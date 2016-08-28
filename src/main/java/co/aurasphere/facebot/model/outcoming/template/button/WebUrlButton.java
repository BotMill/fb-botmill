package co.aurasphere.facebot.model.outcoming.template.button;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.factory.ButtonFactory;


public class WebUrlButton extends Button {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String url;

	/**
	 * Default constructor. Can instantiate this object only through
	 * {@link ButtonFactory}. It checks that the title is not null, not empty
	 * and shorter than 20 characters and that the URL is not empty. The
	 * button type is set to {@link ButtonType#WEB_URL}.
	 * 
	 * @param title
	 *            the button title. It can't be null or empty and has to be
	 *            shorter than 20 characters.
	 * @param url
	 *            the button URL. It can't be null or empty.
	 * @throws IllegalArgumentException
	 *             if title is null, empty or longer than 1000 characters or if
	 *             URL is null or empty.
	 */
	public WebUrlButton(String title, String url) {
		this.title = title;
		this.url = url;
		this.type = ButtonType.WEB_URL;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
