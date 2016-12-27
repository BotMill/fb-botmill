package co.aurasphere.botmill.fb.model.outcoming.payload.template.airline;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfoExtended;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PriceInfo;

import com.google.gson.annotations.SerializedName;


/**
 * The Class AirlineItineraryTemplatePayload.
 */
public class AirlineItineraryTemplatePayload extends AirlineBasePnrNumberTemplatePayload{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The flight info. */
	@Valid
	@NotEmpty
	@SerializedName("flight_info")
	private List<FlightInfoExtended> flightInfo;

	/** The passenger info. */
	@Valid
	@NotEmpty
	@SerializedName("passenger_info")
	private List<PassengerInfo> passengerInfo;

	/** The passenger segment info. */
	@Valid
	@NotEmpty
	@SerializedName("passenger_segment_info")
	private List<PassengerSegmentInfo> passengerSegmentInfo;
	
	/** The price info. */
	@Valid
	@Size(max=4)
	@SerializedName("price_info")
	private List<PriceInfo> priceInfo;
	
	/** The base price. */
	@SerializedName("base_price")
	private BigDecimal basePrice;
	
	/** The tax. */
	private BigDecimal tax;
	
	/** The total price. */
	@NotNull
	@SerializedName("total_price")
	private BigDecimal totalPrice;
	
	/** The currency. */
	@NotEmpty
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;
	
	/**
	 * Instantiates a new airline itinerary template payload.
	 *
	 * @param introMessage the intro message
	 * @param locale the locale
	 * @param pnrNumber the pnr number
	 * @param totalPrice the total price
	 * @param currency the currency
	 */
	public AirlineItineraryTemplatePayload(String introMessage, String locale, String pnrNumber, BigDecimal totalPrice, String currency){
		super(introMessage, locale, pnrNumber);
		this.totalPrice = totalPrice;
		this.currency = currency;
		this.passengerInfo = new ArrayList<PassengerInfo>();
		this.passengerSegmentInfo = new ArrayList<PassengerSegmentInfo>();
		this.priceInfo = new ArrayList<PriceInfo>();
		this.flightInfo = new ArrayList<FlightInfoExtended>();
		this.templateType = PayloadType.AIRLINE_ITINERARY;
	}

	/**
	 * Gets the passenger info.
	 *
	 * @return the passenger info
	 */
	public List<PassengerInfo> getPassengerInfo() {
		return passengerInfo;
	}

	/**
	 * Sets the passenger info.
	 *
	 * @param passengerInfo the new passenger info
	 */
	public void setPassengerInfo(List<PassengerInfo> passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	/**
	 * Gets the passenger segment info.
	 *
	 * @return the passenger segment info
	 */
	public List<PassengerSegmentInfo> getPassengerSegmentInfo() {
		return passengerSegmentInfo;
	}

	/**
	 * Sets the passenger segment info.
	 *
	 * @param passengerSegmentInfo the new passenger segment info
	 */
	public void setPassengerSegmentInfo(
			List<PassengerSegmentInfo> passengerSegmentInfo) {
		this.passengerSegmentInfo = passengerSegmentInfo;
	}

	/**
	 * Gets the price info.
	 *
	 * @return the price info
	 */
	public List<PriceInfo> getPriceInfo() {
		return priceInfo;
	}

	/**
	 * Sets the price info.
	 *
	 * @param priceInfo the new price info
	 */
	public void setPriceInfo(List<PriceInfo> priceInfo) {
		this.priceInfo = priceInfo;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Adds the passenger info.
	 *
	 * @param passengerInfo the passenger info
	 */
	public void addPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo.add(passengerInfo);
	}

	/**
	 * Adds the passenger segment info.
	 *
	 * @param segmentInfo the segment info
	 */
	public void addPassengerSegmentInfo(PassengerSegmentInfo segmentInfo) {
		this.passengerSegmentInfo.add(segmentInfo);
	}

	/**
	 * Adds the price info.
	 *
	 * @param priceInfo the price info
	 */
	public void addPriceInfo(PriceInfo priceInfo) {
		this.priceInfo.add(priceInfo);
	}
	
	/**
	 * Adds the flight info.
	 *
	 * @param flightInfo the flight info
	 */
	public void addFlightInfo(FlightInfoExtended flightInfo){
		this.flightInfo.add(flightInfo);
	}
}
