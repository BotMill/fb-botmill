package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.outcoming.template.airline.PassengerInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.ProductInfo;

/**
 * Builder for a {@link PassengerSegmentInfo} object.
 * 
 * @author Donato
 * @date 25/ago/2016
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

}
