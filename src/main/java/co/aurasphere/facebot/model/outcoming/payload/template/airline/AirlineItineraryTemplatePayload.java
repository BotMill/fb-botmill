package co.aurasphere.facebot.model.outcoming.payload.template.airline;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.payload.PayloadType;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightInfoExtended;
import co.aurasphere.facebot.model.outcoming.template.airline.PassengerInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.PriceInfo;

import com.google.gson.annotations.SerializedName;

public class AirlineItineraryTemplatePayload extends AirlineBasePnrNumberTemplatePayload{

	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotEmpty
	@SerializedName("flight_info")
	private List<FlightInfoExtended> flightInfo;

	@Valid
	@NotEmpty
	@SerializedName("passenger_info")
	private List<PassengerInfo> passengerInfo;

	@Valid
	@NotEmpty
	@SerializedName("passenger_segment_info")
	private List<PassengerSegmentInfo> passengerSegmentInfo;
	
	@Valid
	@Size(max=4)
	@SerializedName("price_info")
	private List<PriceInfo> priceInfo;
	
	@SerializedName("base_price")
	private double basePrice;
	
	private double tax;
	
	@NotNull
	@SerializedName("total_price")
	private double totalPrice;
	
	@NotEmpty
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;
	
	public AirlineItineraryTemplatePayload(String introMessage, String locale, String pnrNumber, double totalPrice, String currency){
		super(introMessage, locale, pnrNumber);
		this.totalPrice = totalPrice;
		this.currency = currency;
		this.passengerInfo = new ArrayList<PassengerInfo>();
		this.passengerSegmentInfo = new ArrayList<PassengerSegmentInfo>();
		this.priceInfo = new ArrayList<PriceInfo>();
		this.flightInfo = new ArrayList<FlightInfoExtended>();
		this.templateType = PayloadType.AIRLINE_ITINERARY;
	}

	public List<PassengerInfo> getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(List<PassengerInfo> passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	public List<PassengerSegmentInfo> getPassengerSegmentInfo() {
		return passengerSegmentInfo;
	}

	public void setPassengerSegmentInfo(
			List<PassengerSegmentInfo> passengerSegmentInfo) {
		this.passengerSegmentInfo = passengerSegmentInfo;
	}

	public List<PriceInfo> getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(List<PriceInfo> priceInfo) {
		this.priceInfo = priceInfo;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void addPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo.add(passengerInfo);
	}

	public void addPassengerSegmentInfo(PassengerSegmentInfo segmentInfo) {
		this.passengerSegmentInfo.add(segmentInfo);
	}

	public void addPriceInfo(PriceInfo priceInfo) {
		this.priceInfo.add(priceInfo);
	}
	
	public void addFlightInfo(FlightInfoExtended flightInfo){
		this.flightInfo.add(flightInfo);
	}
}
