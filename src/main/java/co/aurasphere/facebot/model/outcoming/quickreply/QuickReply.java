package co.aurasphere.facebot.model.outcoming.quickreply;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class QuickReply implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	@SerializedName("content_type")
	private QuickReplyType contentType;
	
	@Size(max=20)
	@NotEmpty
	private String title;
	
	@Size(max=1000)
	@NotEmpty
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
