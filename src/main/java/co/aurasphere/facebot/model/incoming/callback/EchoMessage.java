package co.aurasphere.facebot.model.incoming.callback;

import java.util.List;

import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.outcoming.message.Message;

import com.google.gson.annotations.SerializedName;

/**
 * An object that represents a message_echoes callback.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class EchoMessage extends Message {

	private static final long serialVersionUID = 1L;

	/**
	 * Indicates the message sent from the page itself
	 */
	@SerializedName("is_echo")
	private boolean isEcho;

	/**
	 * ID of the app from which the message was sent
	 */
	@SerializedName("app_id")
	private String appId;

	/**
	 * Custom string passed to the Send API as the metadata field
	 */
	private String metadata;

	/**
	 * Message ID
	 */
	private String mid;

	/**
	 * Sequence number
	 */
	private String seq;

	/**
	 * Text message
	 */
	private String text;

	/**
	 * Attachments of the message
	 */
	// TODO: custom JSON deserializer for legacy attachments and templates
	private List<Attachment> attachments;

	public boolean isEcho() {
		return isEcho;
	}

	public void setIsEcho(boolean isEcho) {
		this.isEcho = isEcho;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
