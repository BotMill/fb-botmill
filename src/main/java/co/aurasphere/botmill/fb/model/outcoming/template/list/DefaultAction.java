/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.model.outcoming.template.list;

import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;

import com.google.gson.annotations.SerializedName;

/**
 * The Class DefaultAction.
 * 
 * @author Alvin Reyes
 * 
 * 
 */
public class DefaultAction extends Button {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

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

	/**
	 * Instantiates a new default action.
	 *
	 * @param url
	 *            the url
	 * @param messengerExtensions
	 *            the messenger extensions
	 * @param webviewHeightRatio
	 *            the webview height ratio
	 * @param fallbackUrl
	 *            the fallback url
	 */
	public DefaultAction(String url, String messengerExtensions,
			String webviewHeightRatio, String fallbackUrl) {
		this(url);
		this.messengerExtensions = messengerExtensions;
		this.webviewHeightRatio = webviewHeightRatio;
		this.fallbackUrl = fallbackUrl;
	}

	/**
	 * Instantiates a new default action.
	 *
	 * @param url
	 *            the url
	 */
	public DefaultAction(String url) {
		this.type = ButtonType.WEB_URL;
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
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @param messengerExtensions
	 *            the new messenger extensions
	 */
	public void setMessengerExtensions(String messengerExtensions) {
		this.messengerExtensions = messengerExtensions;
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
	 * @param webviewHeightRatio
	 *            the new webview height ratio
	 */
	public void setWebviewHeightRatio(String webviewHeightRatio) {
		this.webviewHeightRatio = webviewHeightRatio;
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
	 * @param fallbackUrl
	 *            the new fallback url
	 */
	public void setFallbackUrl(String fallbackUrl) {
		this.fallbackUrl = fallbackUrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.template.button.Button#hashCode
	 * ()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((fallbackUrl == null) ? 0 : fallbackUrl.hashCode());
		result = prime
				* result
				+ ((messengerExtensions == null) ? 0 : messengerExtensions
						.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime
				* result
				+ ((webviewHeightRatio == null) ? 0 : webviewHeightRatio
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.template.button.Button#equals
	 * (java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultAction other = (DefaultAction) obj;
		if (fallbackUrl == null) {
			if (other.fallbackUrl != null)
				return false;
		} else if (!fallbackUrl.equals(other.fallbackUrl))
			return false;
		if (messengerExtensions == null) {
			if (other.messengerExtensions != null)
				return false;
		} else if (!messengerExtensions.equals(other.messengerExtensions))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (webviewHeightRatio == null) {
			if (other.webviewHeightRatio != null)
				return false;
		} else if (!webviewHeightRatio.equals(other.webviewHeightRatio))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.template.button.Button#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "DefaultAction [url=" + url + ", messengerExtensions="
				+ messengerExtensions + ", webviewHeightRatio="
				+ webviewHeightRatio + ", fallbackUrl=" + fallbackUrl
				+ ", type=" + type + "]";
	}

}
