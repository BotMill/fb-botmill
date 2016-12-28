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
public class AirlineCheckinTemplatePayload extends AirlineBasePnrNumberTemplatePayload{

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
	 * @param introMessage the intro message
	 * @param locale the locale
	 * @param pnrNumber the pnr number
	 * @param checkinUrl the checkin url
	 */
	public AirlineCheckinTemplatePayload(String introMessage, String locale, String pnrNumber, String checkinUrl){
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
	 * @param checkinUrl the new checkin url
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
	 * @param flightInfo the new flight info
	 */
	public void setFlightInfo(List<FlightInfo> flightInfo) {
		this.flightInfo = flightInfo;
	}
	
	/**
	 * Adds the flight info.
	 *
	 * @param flightInfo the flight info
	 */
	public void addFlightInfo(FlightInfo flightInfo){
		this.flightInfo.add(flightInfo);
	}
}
