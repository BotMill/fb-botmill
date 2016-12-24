package co.aurasphere.botmill.fb.model.outcoming.quickreply;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Class QuickReply.
 */
public class QuickReply implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content type. */
	@NotNull
	@SerializedName("content_type")
	private QuickReplyType contentType;
	
	/** The image url. */
	@SerializedName("image_url")
	private String imageUrl;
	
	/** The title. */
	@Size(max=20)
	@NotEmpty
	private String title;
	
	/** The payload. */
	@Size(max=1000)
	@NotEmpty
	private String payload;

	/**
	 * Instantiates a new quick reply.
	 *
	 * @param title the title
	 * @param payload the payload
	 */
	public QuickReply(String title, String payload) {
		this.contentType = QuickReplyType.TEXT;
		this.title = title;
		this.payload = payload;
	}

	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload the new payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public QuickReplyType getContentType() {
		return contentType;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the new content type
	 */
	public void setContentType(QuickReplyType contentType) {
		this.contentType = contentType;
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
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl the new image url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
