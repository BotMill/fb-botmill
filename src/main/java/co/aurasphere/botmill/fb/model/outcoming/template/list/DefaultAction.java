package co.aurasphere.botmill.fb.model.outcoming.template.list;

import java.io.Serializable;

import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;

import com.google.gson.annotations.SerializedName;

/**
 * The Class DefaultAction.
 * 
 * @author Alvin Reyes
 * @date 22/Nov/2016
 * 
 */
public class DefaultAction implements Serializable {

	private static final long serialVersionUID = 1L;
	/** The type. */
	private ButtonType type;
	
	/** The url. */
	private String url;
	
	/** The messenger extensions. */
	@SerializedName("messenger_extensions")
	private String messengerExtensions;
	
	/** The webview height ratio. */
	@SerializedName("webview_height_ratio")
	private String webviewHeightRatio;
	
	/** The fallback url. */
	@SerializedName("fallback_url")
	private String fallbackUrl;
	
	public DefaultAction(ButtonType type, String url, String messengerExtensions, String webviewHeightRatio, String fallbackUrl) {
		this.type = type;
		this.url = url;
		this.messengerExtensions = messengerExtensions;
		this.webviewHeightRatio = webviewHeightRatio;
		this.fallbackUrl = fallbackUrl;
	}
	
	public DefaultAction(ButtonType type, String url) {
		this.type = type;
		this.url = url;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ButtonType getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public DefaultAction setType(ButtonType type) {
		this.type = type;
		return this;
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
	public DefaultAction setUrl(String url) {
		this.url = url;
		return this;
	}
	
	/**
	 * Gets the messenger extensions.
	 *
	 * @return the messenger extensions
	 */
	public String getMessengerExtensions() {
		return messengerExtensions;
	}
	
	/**
	 * Sets the messenger extensions.
	 *
	 * @param messengerExtensions the new messenger extensions
	 */
	public DefaultAction setMessengerExtensions(String messengerExtensions) {
		this.messengerExtensions = messengerExtensions;
		return this;
	}
	
	/**
	 * Gets the webview height ratio.
	 *
	 * @return the webview height ratio
	 */
	public String getWebviewHeightRatio() {
		return webviewHeightRatio;
	}
	
	/**
	 * Sets the webview height ratio.
	 *
	 * @param webviewHeightRatio the new webview height ratio
	 */
	public DefaultAction setWebviewHeightRatio(String webviewHeightRatio) {
		this.webviewHeightRatio = webviewHeightRatio;
		return this;
	}
	
	/**
	 * Gets the fallback url.
	 *
	 * @return the fallback url
	 */
	public String getFallbackUrl() {
		return fallbackUrl;
	}
	
	/**
	 * Sets the fallback url.
	 *
	 * @param fallbackUrl the new fallback url
	 */
	public DefaultAction setFallbackUrl(String fallbackUrl) {
		this.fallbackUrl = fallbackUrl;
		return this;
	}
	
}
