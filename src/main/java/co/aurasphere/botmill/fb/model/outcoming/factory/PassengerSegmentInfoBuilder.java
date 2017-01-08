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

import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.ProductInfo;

/**
 * Builder for a {@link PassengerSegmentInfo} object.
 * 
 * @author Donato Rimenti
 * 
 */
public class PassengerSegmentInfoBuilder {

	/**
	 * The parent builder of this one. Used to return to the parent once the
	 * build is finished calling {@link #endFlightInfo()}.
	 */
	private AirlineItineraryTemplateBuilder parentBuilder;

	/**
	 * The object managed by this builder.
	 */
	private PassengerSegmentInfo segmentInfo;

	/**
	 * Default constructor. Creates a builder for a {@link PassengerInfo}
	 * object.
	 * 
	 * @param parentBuilder
	 *            the parent builder of this one. It can't be null.
	 * @param segmentId
	 *            used to identify a flight segment. It can't be empty and must
	 *            be unique within the itinerary.
	 * @param passengerId
	 *            the passengerId of {@link PassengerInfo} object. It can't be
	 *            empty.
	 * @param seat
	 *            the seat number for the passenger. It can't be empty.
	 * @param seatType
	 *            the seat type for the passenger (e.g. Economy comfort). It
	 *            can't be empty.
	 */
	PassengerSegmentInfoBuilder(AirlineItineraryTemplateBuilder parentBuilder,
			String segmentId, String passengerId, String seat, String seatType) {
		this.segmentInfo = new PassengerSegmentInfo(segmentId, passengerId,
				seat, seatType);
		this.parentBuilder = parentBuilder;
	}

	/**
	 * Adds a {@link ProductInfo} object to the list of products the passenger
	 * purchased in the current {@link PassengerSegmentInfo}. This field is
	 * mandatory and there must be at least one element.
	 * 
	 * @param title
	 *            the product title. It can't be empty.
	 * @param value
	 *            the product description. It can't be empty.
	 * @return this builder.
	 */
	public PassengerSegmentInfoBuilder addProductInfo(String title, String value) {
		ProductInfo productInfo = new ProductInfo(title, value);
		segmentInfo.addProductInfo(productInfo);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public AirlineItineraryTemplateBuilder endPassengerSegmentInfo() {
		parentBuilder.addPassengerSegmentInfo(segmentInfo);
		return parentBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PassengerSegmentInfoBuilder [parentBuilder=" + parentBuilder
				+ ", segmentInfo=" + segmentInfo + "]";
	}

}
