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
	@Size(max = 20)
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
	public WebUrlButton(String title, String url,
			WebViewHeightRatioType ratioType) {
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
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
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
				+ ((fallBackUrl == null) ? 0 : fallBackUrl.hashCode());
		result = prime * result + (messengerExtension ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		WebUrlButton other = (WebUrlButton) obj;
		if (fallBackUrl == null) {
			if (other.fallBackUrl != null)
				return false;
		} else if (!fallBackUrl.equals(other.fallBackUrl))
			return false;
		if (messengerExtension != other.messengerExtension)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (webviewHeightRatio != other.webviewHeightRatio)
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
		return "WebUrlButton [url=" + url + ", webviewHeightRatio="
				+ webviewHeightRatio + ", fallBackUrl=" + fallBackUrl
				+ ", messengerExtension=" + messengerExtension + ", title="
				+ title + ", type=" + type + "]";
	}

}
