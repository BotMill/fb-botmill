package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import co.aurasphere.botmill.fb.model.incoming.callback.LocationCoordinates;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

/**
 * Interface which represents a {@link FbBotMillResponse} payload.
 * 
 * @author Alvin Reyes
 * @date Dec 26, 2016
 */
public class GenericPayload implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	 For getting coordinates.
	@SerializedName("coordinates")
	private LocationCoordinates coordinate;

	public LocationCoordinates getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(LocationCoordinates coordinate) {
		this.coordinate = coordinate;
	}
}
