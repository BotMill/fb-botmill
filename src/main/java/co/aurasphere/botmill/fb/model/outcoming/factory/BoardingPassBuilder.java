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
package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.BoardingPass;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.Field;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.TravelClass;

/**
 * Builder for a {@link BoardingPass} object.
 * 
 * @author Donato Rimenti
 * 
 */
public class BoardingPassBuilder extends FlightInfoBuilderDelegator {

	/**
	 * The parent builder of this one. Used to return to the parent once the
	 * build is finished calling {@link #endBoardingPass()}.
	 */
	private AirlineBoardingPassTemplateBuilder parentBuilder;

	/**
	 * The object managed by this builder.
	 */
	private BoardingPass boardingPass;

	/**
	 * Default constructor. Creates a builder for a {@link BoardingPass} object.
	 *
	 * @param parentBuilder
	 *            the parent builder of this one. It can't be null. * @param
	 *            passengerName the passenger name. It can't be empty.
	 * @param passengerName
	 *            the passenger name
	 * @param pnrNumber
	 *            the Passenger Name Record number (Booking Number). It can't be
	 *            empty.
	 * @param logoImageUrl
	 *            the URL of the logo. It can't be empty.
	 * @param aboveBarCodeImageUrl
	 *            the URL of the image to be shown above the bar code in the
	 *            center of the pass. It can't be empty.
	 */
	BoardingPassBuilder(AirlineBoardingPassTemplateBuilder parentBuilder,
			String passengerName, String pnrNumber, String logoImageUrl,
			String aboveBarCodeImageUrl) {
		this.boardingPass = new BoardingPass(passengerName, pnrNumber,
				logoImageUrl, aboveBarCodeImageUrl);
		this.parentBuilder = parentBuilder;
	}

	/**
	 * Sets the {@link TravelClass} for the current {@link BoardingPass} object.
	 * This field is optional.
	 * 
	 * @param travelClass
	 *            the travel class to set.
	 * @return this builder.
	 */
	public BoardingPassBuilder setTravelClass(TravelClass travelClass) {
		this.boardingPass.setTravelClass(travelClass);
		return this;
	}

	/**
	 * Sets the seat for the current {@link BoardingPass} object. This field is
	 * optional.
	 * 
	 * @param seat
	 *            the seat to set.
	 * @return this builder.
	 */
	public BoardingPassBuilder setSeat(String seat) {
		this.boardingPass.setSeat(seat);
		return this;
	}

	/**
	 * Adds an auxiliary field for the current {@link BoardingPass} object. This
	 * field is optional. There can be at most 5 auxiliary fields per boarding
	 * pass.
	 * 
	 * @param label
	 *            the label for the additional field. It can't be empty.
	 * @param value
	 *            the value for the additional field. It can't be empty.
	 * @return this builder.
	 */
	public BoardingPassBuilder addAuxiliaryField(String label, String value) {
		Field field = new Field(label, value);
		this.boardingPass.addAuxiliaryField(field);
		return this;
	}

	/**
	 * Adds an auxiliary field for the current {@link BoardingPass} object. This
	 * field is optional. There can be at most 5 auxiliary fields per boarding
	 * pass.
	 * 
	 * @param auxiliaryField
	 *            the field to add. It can't be null.
	 * @return this builder.
	 */
	public BoardingPassBuilder addAuxiliaryField(Field auxiliaryField) {
		this.boardingPass.addAuxiliaryField(auxiliaryField);
		return this;
	}

	/**
	 * Adds a secondary field for the current {@link BoardingPass} object. This
	 * field is optional. There can be at most 5 secondary fields per boarding
	 * pass.
	 * 
	 * @param label
	 *            the label for the additional field. It can't be empty.
	 * @param value
	 *            the value for the additional field. It can't be empty.
	 * @return this builder.
	 */
	public BoardingPassBuilder addSecondaryField(String label, String value) {
		Field field = new Field(label, value);
		this.boardingPass.addSecondaryField(field);
		return this;
	}

	/**
	 * Adds a secondary field for the current {@link BoardingPass} object. This
	 * field is optional. There can be at most 5 secondary fields per boarding
	 * pass.
	 * 
	 * @param secondaryField
	 *            the field to add. It can't be null.
	 * @return this builder.
	 */
	public BoardingPassBuilder addSecondaryField(Field secondaryField) {
		this.boardingPass.addAuxiliaryField(secondaryField);
		return this;
	}

	/**
	 * Sets the header image URL for the current {@link BoardingPass} object.
	 * This field is optional.
	 *
	 * @param headerImageUrl
	 *            the URL of the header image.
	 * @return the boarding pass builder
	 */
	public BoardingPassBuilder setHeaderImageUrl(String headerImageUrl) {
		this.boardingPass.setHeaderImageUrl(headerImageUrl);
		return this;
	}

	/**
	 * Sets the header text for the current {@link BoardingPass} object. This
	 * field is optional.
	 *
	 * @param headerTextField
	 *            the text of the header.
	 * @return the boarding pass builder
	 */
	public BoardingPassBuilder setHeaderTextField(String headerTextField) {
		this.boardingPass.setHeaderTextField(headerTextField);
		return this;
	}

	/**
	 * Sets the Aztec or QR code for the current {@link BoardingPass} object.
	 * This field or the barcode image URL must be set.
	 *
	 * @param qrCode
	 *            the Aztec or QR code. It can't be empty unless the barcode
	 *            image URL is set.
	 * @return the boarding pass builder
	 * @see #setBarcodeImageUrl(String)
	 */
	public BoardingPassBuilder setQrCode(String qrCode) {
		this.boardingPass.setQrCode(qrCode);
		return this;
	}

	/**
	 * Sets the URL of the barcode image for the current {@link BoardingPass}
	 * object. This field or the QR code must be set.
	 *
	 * @param barcodeImageUrl
	 *            the URL of the barcode image. It can't be empty unless the QR
	 *            code is set.
	 * @return the boarding pass builder
	 * @see #setQrCode(String)
	 */
	public BoardingPassBuilder setBarcodeImageUrl(String barcodeImageUrl) {
		this.boardingPass.setBarcodeImageUrl(barcodeImageUrl);
		return this;
	}

	/**
	 * Adds a {@link FlightInfo} object to this {@link BoardingPass}. This
	 * object is mandatory and can't be null for Airline templates.
	 * 
	 * @param flightNumber
	 *            the flight number. It can't be empty.
	 * @return a builder for the {@link FlightInfo} object.
	 */
	public FlightInfoBuilder<BoardingPassBuilder> addFlightInfo(
			String flightNumber) {
		return new FlightInfoBuilder<BoardingPassBuilder>(this, flightNumber);
	}

	/**
	 * Adds a {@link FlightInfo} object to this {@link BoardingPass}. This
	 * object is mandatory and can't be null for Airline templates. Used only by
	 * delegated classes. Should not be called directly. Use
	 * {@link #addFlightInfo(String)} instead.
	 * 
	 * @param flightInfo
	 *            the flight info to add. It can't be null.
	 */
	@Override
	void addFlightInfo(FlightInfo flightInfo) {
		this.boardingPass.setFlightInfo(flightInfo);
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public AirlineBoardingPassTemplateBuilder endBoardingPass() {
		parentBuilder.addBoardingPass(boardingPass);
		return parentBuilder;
	}

	/**
	 * {@inheritDoc} This method should not be called for this object. Use
	 * {@link #endBoardingPass()} instead.
	 */
	@Override
	@Deprecated
	FbBotMillResponse build(MessageEnvelope envelope) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.factory.AirlineBaseTemplateBuilder
	 * #toString()
	 */
	@Override
	public String toString() {
		return "BoardingPassBuilder [parentBuilder=" + parentBuilder
				+ ", boardingPass=" + boardingPass + ", messageBuilder="
				+ messageBuilder + "]";
	}

}
