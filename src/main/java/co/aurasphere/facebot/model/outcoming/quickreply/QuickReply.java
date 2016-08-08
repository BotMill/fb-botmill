package co.aurasphere.facebot.model.outcoming.quickreply;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class QuickReply implements Serializable{

	private static final long serialVersionUID = 1L;

	@SerializedName("content_type")
	private QuickReplyType contentType;
	
	// Max 20 char
	private String title;
	
	// Max 1000 char
	private String payload;

	public QuickReply(String title, String payload) {
		this.contentType = QuickReplyType.TEXT;
		this.title = title;
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public QuickReplyType getContentType() {
		return contentType;
	}

	public void setContentType(QuickReplyType contentType) {
		this.contentType = contentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
