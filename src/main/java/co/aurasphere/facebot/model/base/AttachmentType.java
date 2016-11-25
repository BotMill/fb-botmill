package co.aurasphere.facebot.model.base;

import java.io.Serializable;

/**
 * Enum for attachment types.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public enum AttachmentType implements Serializable {

	IMAGE, AUDIO, VIDEO, FILE, 
	
	/**
	 * A location object.
	 */
	LOCATION,

	/**
	 * Only used in replies.
	 */
	TEMPLATE,

	/**
	 * Represents a Legacy attachment. This attachment type should not be used.
	 * It's only for incoming messages.
	 */
	FALLBACK;
}
