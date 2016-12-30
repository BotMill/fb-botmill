package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.internal.util.json.SkipDeserialization;

/**
 * Represents a Facebook Messenger Platform attachment. It may be a file or a
 * template.
 * 
 * @author Donato Rimenti
 * 
 */
public class Attachment implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The title.
	 */
	private String title;

	/**
	 *  The url. 
	 */
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
	@SkipDeserialization
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
	 * @param type the {@link #type} to set.
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
	 * @param payload the {@link #payload} to set.
	 */
	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	/**
	 * Gets the {@link #title}.
	 *
	 * @return the {@link #title}.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the {@link #title}.
	 *
	 * @param title the {@link #title} to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the {@link #url}.
	 *
	 * @return the {@link #url}.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the {@link #url}.
	 *
	 * @param url the {@link #url} to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
