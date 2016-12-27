package co.aurasphere.botmill.fb.model.outcoming.template.airline;


/**
 * Enum that represents the kinds of updates of a flight.
 * 
 * @author Donato Rimenti
 * @date Aug 25, 2016
 */
public enum UpdateType {

	/**
	 * Flight delay update.
	 */
	DELAY, 
	
	/**
	 * Flight gate change update.
	 */
	GATE_CHANGE, 
	
	/**
	 * Flight cancellation update.
	 */
	CANCELLATION;

}
