package co.aurasphere.botmill.fb.model.outcoming.payload;

/**
 * Enum that represents the all available payloads.
 * 
 * @author Donato Rimenti
 * 
 */
public enum PayloadType {

	/**
	 * The button.
	 */
	BUTTON, 
	
	/**
	 * The generic.
	 */
	GENERIC, 
	
	/**
	 * The list.
	 */
	LIST, 
	
	/**
	 * The receipt.
	 */
	RECEIPT,

	/**
	 * The airline itinerary.
	 */
	AIRLINE_ITINERARY,

	/**
	 * The airline boardingpass.
	 */
	AIRLINE_BOARDINGPASS,
	
	/**
	 * The airline update.
	 */
	AIRLINE_UPDATE,
	
	/**
	 * The airline checkin.
	 */
	AIRLINE_CHECKIN;
}
