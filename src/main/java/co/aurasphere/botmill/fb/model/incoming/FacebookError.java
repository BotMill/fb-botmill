package co.aurasphere.botmill.fb.model.incoming;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Object that represents an error from Facebook.
 * 
 * @author Donato Rimenti
 * @date Dec 18, 2016
 */
public class FacebookError implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The error message.
	 */
	private String message;

	/**
	 * The error type.
	 */
	private String type;

	/**
	 * The error code.
	 */
	private String code;

	/**
	 * The error Facebook's trace ID.
	 */
	@SerializedName("fbtrace_id")
	private String fbTraceId;

	/**
	 * Gets the {@link #message}.
	 *
	 * @return the {@link #message}.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message
	 *            the {@link #message} to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the {@link #type}.
	 *
	 * @return the {@link #type}.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the {@link #type}.
	 *
	 * @param type
	 *            the {@link #type} to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the {@link #code}.
	 *
	 * @return the {@link #code}.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the {@link #code}.
	 *
	 * @param code
	 *            the {@link #code} to set.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the {@link #fbTraceId}.
	 *
	 * @return the {@link #fbTraceId}.
	 */
	public String getFbTraceId() {
		return fbTraceId;
	}

	/**
	 * Sets the {@link #fbTraceId}.
	 *
	 * @param fbTraceId
	 *            the {@link #fbTraceId} to set.
	 */
	public void setFbTraceId(String fbTraceId) {
		this.fbTraceId = fbTraceId;
	}

}
