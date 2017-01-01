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
package co.aurasphere.botmill.fb.model.outcoming.payload.template.airline;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.outcoming.payload.template.TemplateBasePayload;

import com.google.gson.annotations.SerializedName;

/**
 * The Class AirlineBaseTemplatePayload.
 */
public class AirlineBaseTemplatePayload extends TemplateBasePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The intro message. */
	@NotBlank
	@SerializedName("intro_message")
	private String introMessage;

	/** The locale. */
	@NotBlank
	@Pattern(regexp = "[a-z]{2}_[A-Z]{2}", message = "{locale.pattern.message}")
	private String locale;

	/** The theme color. */
	@Pattern(regexp = "#\\d{6}", message = "{theme.color.pattern.message}")
	@SerializedName("theme_color")
	private String themeColor;

	/**
	 * Instantiates a new AirlineBaseTemplatePayload.
	 */
	public AirlineBaseTemplatePayload() {
	}

	/**
	 * Instantiates a new airline base template payload.
	 *
	 * @param introMessage
	 *            the intro message
	 * @param locale
	 *            the locale
	 */
	public AirlineBaseTemplatePayload(String introMessage, String locale) {
		this.introMessage = introMessage;
		this.locale = locale;
	}

	/**
	 * Gets the intro message.
	 *
	 * @return the intro message
	 */
	public String getIntroMessage() {
		return introMessage;
	}

	/**
	 * Sets the intro message.
	 *
	 * @param introMessage
	 *            the new intro message
	 */
	public void setIntroMessage(String introMessage) {
		this.introMessage = introMessage;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale
	 *            the new locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Gets the theme color.
	 *
	 * @return the theme color
	 */
	public String getThemeColor() {
		return themeColor;
	}

	/**
	 * Sets the theme color.
	 *
	 * @param themeColor
	 *            the new theme color
	 */
	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

}
