package co.aurasphere.botmill.fb.model.outcoming.template.button;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;

import com.google.gson.annotations.SerializedName;

/**
 * The WebUrlButton Class/Object.
 *
 * @author Alvin Reyes
 * 
 */
public class WebUrlButton extends Button {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The url. */
	@NotBlank
	private String url;

	/** The webview height ratio. */
	@SerializedName("webview_height_ratio")
	private WebViewHeightRatioType webviewHeightRatio;

	/** The fall back url. */
	@SerializedName("fallback_url")
	private String fallBackUrl;

	/** The messenger extension. */
	@SerializedName("messenger_extensions")
	private boolean messengerExtension;
	
	/**
	 * The button title.
	 */
	@Size(max=20)
	@NotBlank
	protected String title;

	/**
	 * Default constructor. Can instantiate this object only through
	 * {@link ButtonFactory}. It checks that the title is not null, not empty
	 * and shorter than 20 characters and that the URL is not empty. The button
	 * type is set to {@link ButtonType#WEB_URL}.
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

	/**
	 * Instantiates a new web url button.
	 *
	 * @param title
	 *            the title
	 * @param url
	 *            the url
	 * @param ratioType
	 *            the ratio type
	 */
	public WebUrlButton(String title, String url, WebViewHeightRatioType ratioType) {
		this.title = title;
		this.url = url;
		this.type = ButtonType.WEB_URL;
		this.webviewHeightRatio = ratioType;
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
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
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
