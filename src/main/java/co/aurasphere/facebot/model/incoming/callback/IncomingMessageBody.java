package co.aurasphere.facebot.model.incoming.callback;

import java.util.List;

import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.outcoming.message.Message;
import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;

import com.google.gson.annotations.SerializedName;

public class IncomingMessageBody extends Message{
// message callback
	private static final long serialVersionUID = 1L;

	private String mid;
	
	private String seq;
	
	private String text;
	
	@SerializedName("quick_reply")
	private QuickReply quickReply;
	
	private List<Attachment> attachments;
	
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

	public QuickReply getQuickReply() {
		return quickReply;
	}

	public void setQuickReply(QuickReply quickReply) {
		this.quickReply = quickReply;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
}
