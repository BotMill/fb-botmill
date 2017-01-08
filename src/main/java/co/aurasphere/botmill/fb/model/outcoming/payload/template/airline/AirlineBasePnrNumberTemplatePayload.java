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

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Class AirlineBasePnrNumberTemplatePayload.
 */
public abstract class AirlineBasePnrNumberTemplatePayload extends
		AirlineBaseTemplatePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pnr number. */
	@NotBlank
	@SerializedName("pnr_number")
	private String pnrNumber;

	/**
	 * Instantiates a new airline base pnr number template payload.
	 *
	 * @param introMessage
	 *            the intro message
	 * @param locale
	 *            the locale
	 * @param pnrNumber
	 *            the pnr number
	 */
	public AirlineBasePnrNumberTemplatePayload(String introMessage,
			String locale, String pnrNumber) {
		super(introMessage, locale);
		this.pnrNumber = pnrNumber;
	}

	/**
	 * Instantiates a new AirlineBasePnrNumberTemplatePayload.
	 */
	public AirlineBasePnrNumberTemplatePayload() {
	}

	/**
	 * Gets the pnr number.
	 *
	 * @return the pnr number
	 */
	public String getPnrNumber() {
		return pnrNumber;
	}

	/**
	 * Sets the pnr number.
	 *
	 * @param pnrNumber
	 *            the new pnr number
	 */
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBaseTemplatePayload#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((pnrNumber == null) ? 0 : pnrNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBaseTemplatePayload#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineBasePnrNumberTemplatePayload other = (AirlineBasePnrNumberTemplatePayload) obj;
		if (pnrNumber == null) {
			if (other.pnrNumber != null)
				return false;
		} else if (!pnrNumber.equals(other.pnrNumber))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBaseTemplatePayload#toString()
	 */
	@Override
	public String toString() {
		return "AirlineBasePnrNumberTemplatePayload [pnrNumber=" + pnrNumber
				+ ", templateType=" + templateType + "]";
	}

}
