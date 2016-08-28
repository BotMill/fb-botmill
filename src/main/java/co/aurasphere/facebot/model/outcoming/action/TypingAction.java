package co.aurasphere.facebot.model.outcoming.action;

/**
 * Enum that represents the non-message actions that a bot can perform. They are
 * used in conjunction with {@link FaceBotActionResponse}.
 * 
 * @author Donato
 * @date 25/ago/2016
 */
public enum TypingAction {

	/**
	 * Marks the message as seen.
	 */
	MARK_SEEN,

	/**
	 * Brings up the "<bot-name> is writing..." label. This label is turned off
	 * automatically after 20 seconds or when a {@link #TYPING_OFF} action is
	 * sent.
	 */
	TYPING_ON,

	/**
	 * Removes the "<bot-name> is writing..." label if present.
	 */
	TYPING_OFF;

}