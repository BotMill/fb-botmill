package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

/**
 * Enum for attachment types.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public enum AttachmentType implements Serializable {

	/**
	 * Image file attachment.
	 */
	IMAGE,

	/**
	 * Audio file attachment.
	 */
	AUDIO,

	/**
	 * Video file attachment.
	 */
	VIDEO,

	/**
	 * Generic file attachment.
	 */
	FILE,

	/**
	 * Location object attachment.
	 */
	LOCATION,

	/**
	 * Template attachment. Only used in replies.
	 */
	TEMPLATE,

	/**
	 * Legacy attachment. This attachment type should not be used. Only used in
	 * incoming messages.
	 */
	FALLBACK;
}
