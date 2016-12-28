package co.aurasphere.botmill.fb.model.base;

import co.aurasphere.botmill.fb.model.incoming.callback.LocationCoordinates;

/**
 * A {@link Payload} which contains a Location sent by a Quick Reply.
 * 
 * @author Alvin Reyes
 * @date Dec 26, 2016
 */
public class QuickReplyLocationPayload implements Payload {
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The coordinates.
	 */
	private LocationCoordinates coordinates;

	/**
	 * Gets the {@link #coordinates}.
	 *
	 * @return the {@link #coordinates}.
	 */
	public LocationCoordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * Sets the {@link #coordinates}.
	 *
	 * @param coordinates the {@link #coordinates} to set.
	 */
	public void setCoordinates(LocationCoordinates coordinates) {
		this.coordinates = coordinates;
	}
}
