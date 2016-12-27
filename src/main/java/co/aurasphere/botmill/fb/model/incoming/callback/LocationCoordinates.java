package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class LocationCoordinates implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("lat")
	private String latitude;
	
	@SerializedName("long")
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}