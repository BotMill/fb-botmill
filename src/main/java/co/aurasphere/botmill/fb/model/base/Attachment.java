package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.outcoming.payload.Payload;

/**
 * Represents a Facebook Messenger Platform attachment. It may be a file or a
 * template.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class Attachment implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The title. */
	private String title;

	/** The url. */
	private String url;

	/**
	 * The attachment type.
	 */
	@NotNull
	private AttachmentType type;

	/**
	 * The payload of the attachment.
	 */
	@Valid
	@NotNull
	private Payload payload;

	/**
	 * Instantiates a new attachment.
	 */
	public Attachment() {
	}

	/**
	 * Instantiates a new attachment.
	 *
	 * @param type
	 *            the {@link #type}.
	 * @param payload
	 *            the {@link #payload}.
	 */
	public Attachment(AttachmentType type, Payload payload) {
		this.type = type;
		this.payload = payload;
	}

	/**
	 * Gets the {@link #type}.
	 *
	 * @return the {@link #type}.
	 */
	public AttachmentType getType() {
		return type;
	}

	/**
	 * Sets the {@link #type}.
	 *
	 * @param type
	 *            the {@link #type} to set.
	 */
	public void setType(AttachmentType type) {
		this.type = type;
	}

	/**
	 * Gets the {@link #payload}.
	 *
	 * @return the {@link #payload}.
	 */
	public Payload getPayload() {
		return payload;
	}

	/**
	 * Sets the {@link #payload}.
	 *
	 * @param payload
	 *            the {@link #payload} to set.
	 */
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
