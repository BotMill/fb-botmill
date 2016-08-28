package co.aurasphere.facebot.model.outcoming.payload.template.airline;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.payload.PayloadType;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightInfo;

import com.google.gson.annotations.SerializedName;

public class AirlineCheckinTemplatePayload extends AirlineBasePnrNumberTemplatePayload{

	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotEmpty
	@SerializedName("flight_info")
	private List<FlightInfo> flightInfo;

	@NotEmpty
	@SerializedName("checkin_url")
	private String checkinUrl;
	
	public AirlineCheckinTemplatePayload(String introMessage, String locale, String pnrNumber, String checkinUrl){
		super(introMessage, locale, pnrNumber);
		this.flightInfo = new ArrayList<FlightInfo>();
		this.checkinUrl = checkinUrl;
		this.templateType = PayloadType.AIRLINE_CHECKIN;
	}

	public String getCheckinUrl() {
		return checkinUrl;
	}

	public void setCheckinUrl(String checkinUrl) {
		this.checkinUrl = checkinUrl;
	}

	public List<FlightInfo> getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(List<FlightInfo> flightInfo) {
		this.flightInfo = flightInfo;
	}
	
	public void addFlightInfo(FlightInfo flightInfo){
		this.flightInfo.add(flightInfo);
	}
}
