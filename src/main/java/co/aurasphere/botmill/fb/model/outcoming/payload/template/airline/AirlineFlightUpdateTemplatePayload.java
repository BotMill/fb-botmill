package co.aurasphere.botmill.fb.model.outcoming.payload.template.airline;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.UpdateType;

import com.google.gson.annotations.SerializedName;


/**
 * The Class AirlineFlightUpdateTemplatePayload.
 */
public class AirlineFlightUpdateTemplatePayload extends AirlineBasePnrNumberTemplatePayload{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The update flight info. */
	@Valid
	@NotNull
	@SerializedName("update_flight_info")
	private FlightInfo updateFlightInfo;
	
	/** The update type. */
	@NotNull
	@SerializedName("update_type")
	private UpdateType updateType;
	
	/**
	 * Instantiates a new airline flight update template payload.
	 *
	 * @param introMessage the intro message
	 * @param locale the locale
	 * @param pnrNumber the pnr number
	 * @param updateType the update type
	 */
	public AirlineFlightUpdateTemplatePayload(String introMessage, String locale, String pnrNumber, UpdateType updateType){
		super(introMessage, locale, pnrNumber);
		this.updateType = updateType;
		this.templateType = PayloadType.AIRLINE_UPDATE;
	}

	/**
	 * Gets the update flight info.
	 *
	 * @return the update flight info
	 */
	public FlightInfo getUpdateFlightInfo() {
		return updateFlightInfo;
	}

	/**
	 * Sets the update flight info.
	 *
	 * @param updateFlightInfo the new update flight info
	 */
	public void setUpdateFlightInfo(FlightInfo updateFlightInfo) {
		this.updateFlightInfo = updateFlightInfo;
	}
}
