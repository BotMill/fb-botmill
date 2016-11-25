package co.aurasphere.facebot;

/**
 * Enumeration that indicates which policy a {@link FaceBot} will use when
 * processing the callback handler chain.
 * 
 * @author Donato Rimenti
 * @date Aug 03, 2016
 */
public enum FaceBotPolicy {

	/**
	 * Runs the chain only until the first condition is met.
	 */
	FIRST_ONLY,

	/**
	 * Runs always all the chain.
	 */
	PROCESS_ALL;
}
