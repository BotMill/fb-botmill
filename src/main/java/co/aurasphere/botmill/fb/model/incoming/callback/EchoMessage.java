package co.aurasphere.botmill.fb.model.incoming.callback;

import java.util.List;

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.outcoming.message.Message;

import com.google.gson.annotations.SerializedName;


/**
 * Model for a message echo callback. <br/>
 * <br/>
 * This callback will occur when a message has been sent by your page. You may
 * receive text messsages or messages with attachments (image, video, audio,
 * template or fallback). The payload will also include an optional custom
 * metadata sent by the sender, and the corresponding app_id. You can subscribe
 * to this callback by selecting the message_echoes field when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook. <br/>
 * <br/>
 * Multiple types of messages are supported:
 * 
 * <pre>
 * - Text message 
 * - Message with image, audio, video or file attachment 
 * - Message with template attachment 
 * - Message with fallback attachment (any unrecognized or unsupported attachment)
 * </pre>
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-echo"
 *      >Facebook's Messenger Platform Message Echo Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * @date Aug 08, 2016
 */
public class EchoMessage extends Message {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Indicates the message sent from the page itself.
	 */
	@SerializedName("is_echo")
	private boolean isEcho;

	/**
	 * ID of the app from which the message was sent.
	 */
	@SerializedName("app_id")
	private String appId;

	/**
	 * Custom string passed to the Send API as the metadata field.
	 */
	private String metadata;

	/**
	 * Message ID.
	 */
	private String mid;

	/**
	 * Sequence number.
	 */
	private String seq;

	/**
	 * Text message.
	 */
	private String text;

	// TODO: custom JSON deserializer for legacy attachments and templates
	/**
	 * Attachments of the message.
	 */
	private List<Attachment> attachments;

	/**
	 * Checks if is echo.
	 *
	 * @return the {@link #isEcho}.
	 */
	public boolean isEcho() {
		return isEcho;
	}

	/**
	 * Sets the {@link #isEcho}.
	 *
	 * @param isEcho
	 *            the {@link #isEcho} to set.
	 */
	public void setIsEcho(boolean isEcho) {
		this.isEcho = isEcho;
	}

	/**
	 * Gets the {@link #appId}.
	 *
	 * @return the {@link #appId}.
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * Sets the {@link #appId}.
	 *
	 * @param appId
	 *            the {@link #appId} to set.
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * Gets the {@link #metadata}.
	 *
	 * @return the {@link #metadata}.
	 */
	public String getMetadata() {
		return metadata;
	}

	/**
	 * Sets the {@link #metadata}.
	 *
	 * @param metadata
	 *            the {@link #metadata} to set.
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * Gets the {@link #mid}.
	 *
	 * @return the {@link #mid}.
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * Sets the {@link #mid}.
	 *
	 * @param mid
	 *            the {@link #mid} to set.
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * Gets the {@link #seq}.
	 *
	 * @return the {@link #seq}.
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * Sets the {@link #seq}.
	 *
	 * @param seq
	 *            the {@link #seq} to set.
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * Gets the {@link #text}.
	 *
	 * @return the {@link #text}.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the {@link #text}.
	 *
	 * @param text
	 *            the {@link #text} to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the {@link #attachments}.
	 *
	 * @return the {@link #attachments}.
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * Sets the {@link #attachments}.
	 *
	 * @param attachments
	 *            the {@link #attachments} to set.
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
