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

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;

import com.google.gson.annotations.SerializedName;

/**
 * The Class AirlineCheckinTemplatePayload.
 */
public class AirlineCheckinTemplatePayload extends
		AirlineBasePnrNumberTemplatePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The flight info. */
	@Valid
	@NotEmpty
	@SerializedName("flight_info")
	private List<FlightInfo> flightInfo;

	/** The checkin url. */
	@NotBlank
	@SerializedName("checkin_url")
	private String checkinUrl;

	/**
	 * Instantiates a new airline checkin template payload.
	 *
	 * @param introMessage
	 *            the intro message
	 * @param locale
	 *            the locale
	 * @param pnrNumber
	 *            the pnr number
	 * @param checkinUrl
	 *            the checkin url
	 */
	public AirlineCheckinTemplatePayload(String introMessage, String locale,
			String pnrNumber, String checkinUrl) {
		super(introMessage, locale, pnrNumber);
		this.flightInfo = new ArrayList<FlightInfo>();
		this.checkinUrl = checkinUrl;
		this.templateType = PayloadType.AIRLINE_CHECKIN;
	}

	/**
	 * Instantiates a new AirlineCheckinTemplatePayload.
	 */
	public AirlineCheckinTemplatePayload() {
	}

	/**
	 * Gets the checkin url.
	 *
	 * @return the checkin url
	 */
	public String getCheckinUrl() {
		return checkinUrl;
	}

	/**
	 * Sets the checkin url.
	 *
	 * @param checkinUrl
	 *            the new checkin url
	 */
	public void setCheckinUrl(String checkinUrl) {
		this.checkinUrl = checkinUrl;
	}

	/**
	 * Gets the flight info.
	 *
	 * @return the flight info
	 */
	public List<FlightInfo> getFlightInfo() {
		return flightInfo;
	}

	/**
	 * Sets the flight info.
	 *
	 * @param flightInfo
	 *            the new flight info
	 */
	public void setFlightInfo(List<FlightInfo> flightInfo) {
		this.flightInfo = flightInfo;
	}

	/**
	 * Adds the flight info.
	 *
	 * @param flightInfo
	 *            the flight info
	 */
	public void addFlightInfo(FlightInfo flightInfo) {
		this.flightInfo.add(flightInfo);
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
		result = prime * result
				+ ((checkinUrl == null) ? 0 : checkinUrl.hashCode());
		result = prime * result
				+ ((flightInfo == null) ? 0 : flightInfo.hashCode());
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
		AirlineCheckinTemplatePayload other = (AirlineCheckinTemplatePayload) obj;
		if (checkinUrl == null) {
			if (other.checkinUrl != null)
				return false;
		} else if (!checkinUrl.equals(other.checkinUrl))
			return false;
		if (flightInfo == null) {
			if (other.flightInfo != null)
				return false;
		} else if (!flightInfo.equals(other.flightInfo))
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
		return "AirlineCheckinTemplatePayload [flightInfo=" + flightInfo
				+ ", checkinUrl=" + checkinUrl + ", templateType="
				+ templateType + "]";
	}
}
