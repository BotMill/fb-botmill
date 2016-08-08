package co.aurasphere.facebot.model.outcoming.quickreply;

import java.util.List;

import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.outcoming.message.Message;

import com.google.gson.annotations.SerializedName;

public class QuickReplyMessage extends Message {

	private static final long serialVersionUID = 1L;

	private String text;
	
	private Attachment attachment;
	
	@SerializedName("quick_replies")
	private List<QuickReply> quickReplies;

	public QuickReplyMessage(String text, List<QuickReply> quickReplies){
		this.text = text;
		this.quickReplies = quickReplies;
	}
	
	public QuickReplyMessage(Attachment attachment, List<QuickReply> quickReplies){
		this.attachment = attachment;
		this.quickReplies = quickReplies;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public List<QuickReply> getQuickReplies() {
		return quickReplies;
	}

	public void setQuickReplies(List<QuickReply> quickReplies) {
		this.quickReplies = quickReplies;
	}
	
}
