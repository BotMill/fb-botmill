package co.aurasphere.facebot.model.outcoming.payload.template.airline;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.facebot.model.outcoming.payload.PayloadType;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.UpdateType;

import com.google.gson.annotations.SerializedName;

public class AirlineFlightUpdateTemplatePayload extends AirlineBasePnrNumberTemplatePayload{

	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull
	@SerializedName("update_flight_info")
	private FlightInfo updateFlightInfo;
	
	@NotNull
	@SerializedName("update_type")
	private UpdateType updateType;
	
	public AirlineFlightUpdateTemplatePayload(String introMessage, String locale, String pnrNumber, UpdateType updateType){
		super(introMessage, locale, pnrNumber);
		this.updateType = updateType;
		this.templateType = PayloadType.AIRLINE_UPDATE;
	}

	public FlightInfo getUpdateFlightInfo() {
		return updateFlightInfo;
	}

	public void setUpdateFlightInfo(FlightInfo updateFlightInfo) {
		this.updateFlightInfo = updateFlightInfo;
	}
}
