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
package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Class BoardingPass.
 */
public class BoardingPass implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The passenger name. */
	@NotBlank
	@SerializedName("passenger_name")
	private String passengerName;

	/** The pnr number. */
	@NotBlank
	@SerializedName("pnr_number")
	private String pnrNumber;

	/** The travel class. */
	@SerializedName("travel_class")
	private TravelClass travelClass;

	/** The seat. */
	private String seat;

	/** The auxiliary fields. */
	@Size(max = 5)
	@SerializedName("auxiliary_fields")
	private List<Field> auxiliaryFields;

	/** The secondary fields. */
	@Size(max = 5)
	@SerializedName("secondary_fields")
	private List<Field> secondaryFields;

	/** The logo image url. */
	@NotBlank
	@SerializedName("logo_image_url")
	private String logoImageUrl;

	/** The header image url. */
	@SerializedName("header_image_url")
	private String headerImageUrl;

	/** The header text field. */
	@SerializedName("header_text_field")
	private String headerTextField;

	/** The qr code. */
	@SerializedName("qr_code")
	private String qrCode;

	/** The barcode image url. */
	@SerializedName("barcode_image_url")
	private String barcodeImageUrl;

	/** The above bar code image url. */
	@NotBlank
	@SerializedName("above_bar_code_image_url")
	private String aboveBarCodeImageUrl;

	/** The flight info. */
	@Valid
	@NotNull
	@SerializedName("flight_info")
	private FlightInfo flightInfo;

	/**
	 * Instantiates a new boarding pass.
	 *
	 * @param passengerName
	 *            the passenger name
	 * @param pnrNumber
	 *            the pnr number
	 * @param logoImageUrl
	 *            the logo image url
	 * @param aboveBarCodeImageUrl
	 *            the above bar code image url
	 */
	public BoardingPass(String passengerName, String pnrNumber,
			String logoImageUrl, String aboveBarCodeImageUrl) {
		this.passengerName = passengerName;
		this.pnrNumber = pnrNumber;
		this.logoImageUrl = logoImageUrl;
		this.aboveBarCodeImageUrl = aboveBarCodeImageUrl;
		this.auxiliaryFields = new ArrayList<Field>();
		this.secondaryFields = new ArrayList<Field>();
	}

	/**
	 * Gets the passenger name.
	 *
	 * @return the passenger name
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * Sets the passenger name.
	 *
	 * @param passengerName
	 *            the new passenger name
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
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

	/**
	 * Gets the travel class.
	 *
	 * @return the travel class
	 */
	public TravelClass getTravelClass() {
		return travelClass;
	}

	/**
	 * Sets the travel class.
	 *
	 * @param travelClass
	 *            the new travel class
	 */
	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}

	/**
	 * Gets the seat.
	 *
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * Sets the seat.
	 *
	 * @param seat
	 *            the new seat
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * Gets the auxiliary fields.
	 *
	 * @return the auxiliary fields
	 */
	public List<Field> getAuxiliaryFields() {
		return auxiliaryFields;
	}

	/**
	 * Sets the auxiliary fields.
	 *
	 * @param auxiliaryFields
	 *            the new auxiliary fields
	 */
	public void setAuxiliaryFields(List<Field> auxiliaryFields) {
		this.auxiliaryFields = auxiliaryFields;
	}

	/**
	 * Gets the secondary fields.
	 *
	 * @return the secondary fields
	 */
	public List<Field> getSecondaryFields() {
		return secondaryFields;
	}

	/**
	 * Sets the secondary fields.
	 *
	 * @param secondaryFields
	 *            the new secondary fields
	 */
	public void setSecondaryFields(List<Field> secondaryFields) {
		this.secondaryFields = secondaryFields;
	}

	/**
	 * Gets the logo image url.
	 *
	 * @return the logo image url
	 */
	public String getLogoImageUrl() {
		return logoImageUrl;
	}

	/**
	 * Sets the logo image url.
	 *
	 * @param logoImageUrl
	 *            the new logo image url
	 */
	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}

	/**
	 * Gets the header image url.
	 *
	 * @return the header image url
	 */
	public String getHeaderImageUrl() {
		return headerImageUrl;
	}

	/**
	 * Sets the header image url.
	 *
	 * @param headerImageUrl
	 *            the new header image url
	 */
	public void setHeaderImageUrl(String headerImageUrl) {
		this.headerImageUrl = headerImageUrl;
	}

	/**
	 * Gets the header text field.
	 *
	 * @return the header text field
	 */
	public String getHeaderTextField() {
		return headerTextField;
	}

	/**
	 * Sets the header text field.
	 *
	 * @param headerTextField
	 *            the new header text field
	 */
	public void setHeaderTextField(String headerTextField) {
		this.headerTextField = headerTextField;
	}

	/**
	 * Gets the qr code.
	 *
	 * @return the qr code
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * Sets the qr code.
	 *
	 * @param qrCode
	 *            the new qr code
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * Gets the barcode image url.
	 *
	 * @return the barcode image url
	 */
	public String getBarcodeImageUrl() {
		return barcodeImageUrl;
	}

	/**
	 * Sets the barcode image url.
	 *
	 * @param barcodeImageUrl
	 *            the new barcode image url
	 */
	public void setBarcodeImageUrl(String barcodeImageUrl) {
		this.barcodeImageUrl = barcodeImageUrl;
	}

	/**
	 * Gets the above bar code image url.
	 *
	 * @return the above bar code image url
	 */
	public String getAboveBarCodeImageUrl() {
		return aboveBarCodeImageUrl;
	}

	/**
	 * Sets the above bar code image url.
	 *
	 * @param aboveBarCodeImageUrl
	 *            the new above bar code image url
	 */
	public void setAboveBarCodeImageUrl(String aboveBarCodeImageUrl) {
		this.aboveBarCodeImageUrl = aboveBarCodeImageUrl;
	}

	/**
	 * Gets the flight info.
	 *
	 * @return the flight info
	 */
	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	/**
	 * Sets the flight info.
	 *
	 * @param flightInfo
	 *            the new flight info
	 */
	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	/**
	 * Adds the auxiliary field.
	 *
	 * @param field
	 *            the field
	 */
	public void addAuxiliaryField(Field field) {
		this.auxiliaryFields.add(field);
	}

	/**
	 * Adds the secondary field.
	 *
	 * @param field
	 *            the field
	 */
	public void addSecondaryField(Field field) {
		this.secondaryFields.add(field);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((aboveBarCodeImageUrl == null) ? 0 : aboveBarCodeImageUrl
						.hashCode());
		result = prime * result
				+ ((auxiliaryFields == null) ? 0 : auxiliaryFields.hashCode());
		result = prime * result
				+ ((barcodeImageUrl == null) ? 0 : barcodeImageUrl.hashCode());
		result = prime * result
				+ ((flightInfo == null) ? 0 : flightInfo.hashCode());
		result = prime * result
				+ ((headerImageUrl == null) ? 0 : headerImageUrl.hashCode());
		result = prime * result
				+ ((headerTextField == null) ? 0 : headerTextField.hashCode());
		result = prime * result
				+ ((logoImageUrl == null) ? 0 : logoImageUrl.hashCode());
		result = prime * result
				+ ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result
				+ ((pnrNumber == null) ? 0 : pnrNumber.hashCode());
		result = prime * result + ((qrCode == null) ? 0 : qrCode.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result
				+ ((secondaryFields == null) ? 0 : secondaryFields.hashCode());
		result = prime * result
				+ ((travelClass == null) ? 0 : travelClass.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardingPass other = (BoardingPass) obj;
		if (aboveBarCodeImageUrl == null) {
			if (other.aboveBarCodeImageUrl != null)
				return false;
		} else if (!aboveBarCodeImageUrl.equals(other.aboveBarCodeImageUrl))
			return false;
		if (auxiliaryFields == null) {
			if (other.auxiliaryFields != null)
				return false;
		} else if (!auxiliaryFields.equals(other.auxiliaryFields))
			return false;
		if (barcodeImageUrl == null) {
			if (other.barcodeImageUrl != null)
				return false;
		} else if (!barcodeImageUrl.equals(other.barcodeImageUrl))
			return false;
		if (flightInfo == null) {
			if (other.flightInfo != null)
				return false;
		} else if (!flightInfo.equals(other.flightInfo))
			return false;
		if (headerImageUrl == null) {
			if (other.headerImageUrl != null)
				return false;
		} else if (!headerImageUrl.equals(other.headerImageUrl))
			return false;
		if (headerTextField == null) {
			if (other.headerTextField != null)
				return false;
		} else if (!headerTextField.equals(other.headerTextField))
			return false;
		if (logoImageUrl == null) {
			if (other.logoImageUrl != null)
				return false;
		} else if (!logoImageUrl.equals(other.logoImageUrl))
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (pnrNumber == null) {
			if (other.pnrNumber != null)
				return false;
		} else if (!pnrNumber.equals(other.pnrNumber))
			return false;
		if (qrCode == null) {
			if (other.qrCode != null)
				return false;
		} else if (!qrCode.equals(other.qrCode))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (secondaryFields == null) {
			if (other.secondaryFields != null)
				return false;
		} else if (!secondaryFields.equals(other.secondaryFields))
			return false;
		if (travelClass != other.travelClass)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BoardingPass [passengerName=" + passengerName + ", pnrNumber="
				+ pnrNumber + ", travelClass=" + travelClass + ", seat=" + seat
				+ ", auxiliaryFields=" + auxiliaryFields + ", secondaryFields="
				+ secondaryFields + ", logoImageUrl=" + logoImageUrl
				+ ", headerImageUrl=" + headerImageUrl + ", headerTextField="
				+ headerTextField + ", qrCode=" + qrCode + ", barcodeImageUrl="
				+ barcodeImageUrl + ", aboveBarCodeImageUrl="
				+ aboveBarCodeImageUrl + ", flightInfo=" + flightInfo + "]";
	}
}
