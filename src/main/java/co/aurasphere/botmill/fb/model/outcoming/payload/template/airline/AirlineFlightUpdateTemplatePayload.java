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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.UpdateType;

import com.google.gson.annotations.SerializedName;

/**
 * The Class AirlineFlightUpdateTemplatePayload.
 */
public class AirlineFlightUpdateTemplatePayload extends
		AirlineBasePnrNumberTemplatePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The update flight info. */
	@Valid
	@NotNull
	@SerializedName("update_flight_info")
	private FlightInfo updateFlightInfo;

	/** The update type. */
	@NotNull
	@SerializedName("update_type")
	private UpdateType updateType;

	/**
	 * Instantiates a new airline flight update template payload.
	 *
	 * @param introMessage
	 *            the intro message
	 * @param locale
	 *            the locale
	 * @param pnrNumber
	 *            the pnr number
	 * @param updateType
	 *            the update type
	 */
	public AirlineFlightUpdateTemplatePayload(String introMessage,
			String locale, String pnrNumber, UpdateType updateType) {
		super(introMessage, locale, pnrNumber);
		this.updateType = updateType;
		this.templateType = PayloadType.AIRLINE_UPDATE;
	}

	/**
	 * Instantiates a new AirlineFlightUpdateTemplatePayload.
	 */
	public AirlineFlightUpdateTemplatePayload() {
	}

	/**
	 * Gets the update flight info.
	 *
	 * @return the update flight info
	 */
	public FlightInfo getUpdateFlightInfo() {
		return updateFlightInfo;
	}

	/**
	 * Sets the update flight info.
	 *
	 * @param updateFlightInfo
	 *            the new update flight info
	 */
	public void setUpdateFlightInfo(FlightInfo updateFlightInfo) {
		this.updateFlightInfo = updateFlightInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBasePnrNumberTemplatePayload#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((updateFlightInfo == null) ? 0 : updateFlightInfo.hashCode());
		result = prime * result
				+ ((updateType == null) ? 0 : updateType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBasePnrNumberTemplatePayload#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineFlightUpdateTemplatePayload other = (AirlineFlightUpdateTemplatePayload) obj;
		if (updateFlightInfo == null) {
			if (other.updateFlightInfo != null)
				return false;
		} else if (!updateFlightInfo.equals(other.updateFlightInfo))
			return false;
		if (updateType != other.updateType)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBasePnrNumberTemplatePayload#toString()
	 */
	@Override
	public String toString() {
		return "AirlineFlightUpdateTemplatePayload [updateFlightInfo="
				+ updateFlightInfo + ", updateType=" + updateType
				+ ", templateType=" + templateType + "]";
	}
}
