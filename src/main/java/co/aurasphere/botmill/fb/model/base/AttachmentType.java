package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;


/**
 * Enum for attachment types.
 * 
 * @author Donato Rimenti
 * 
 */
public enum AttachmentType implements Serializable {

	/**
	 * Image file attachment.
	 */
	@SerializedName("image")
	IMAGE,

	/**
	 * Audio file attachment.
	 */
	@SerializedName("audio")
	AUDIO,

	/**
	 * Video file attachment.
	 */
	@SerializedName("video")
	VIDEO,

	/**
	 * Generic file attachment.
	 */
	@SerializedName("file")
	FILE,

	/**
	 * Location object attachment.
	 */
	@SerializedName("location")
	LOCATION,

	/**
	 * Template attachment. Only used in replies.
	 */
	@SerializedName("template")
	TEMPLATE,

	/**
	 * Legacy attachment. This attachment type should not be used. Only used in
	 * incoming messages.
	 */
	@SerializedName("fallback")
	FALLBACK;
}
