package co.aurasphere.botmill.fb.model.outcoming.action;


/**
 * Enum that represents the non-message actions that a bot can perform. They are
 * used in conjunction with {@link FbBotMillActionResponse}.
 * 
 * @author Donato Rimenti
 * 
 */
public enum TypingAction {

	/**
	 * Marks the message as seen.
	 */
	MARK_SEEN,

	/**
	 * Brings up the "is writing..." label. This label is turned off
	 * automatically after 20 seconds or when a {@link #TYPING_OFF} action is
	 * sent.
	 */
	TYPING_ON,

	/**
	 * Removes the "is writing..." label if present.
	 */
	TYPING_OFF;

}