package co.aurasphere.facebot.model.outcoming.template.airline;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class FlightInfoExtended extends FlightInfo{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("connection_id")
	private String connectionId;

	@NotEmpty
	@SerializedName("segment_id")
	private String segmentId;
	
	@SerializedName("aircraft_type")
	private String aircraftType;

	@NotNull
	@SerializedName("travel_class")
	private TravelClass travelClass;
	
	public FlightInfoExtended(String flightNumber, String connectionId, String segmentId, TravelClass travelClass){
		super(flightNumber);
		this.connectionId = connectionId;
		this.segmentId = segmentId;
		this.travelClass = travelClass;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public TravelClass getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}
}
