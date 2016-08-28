package co.aurasphere.facebot.model.outcoming.message;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;

import com.google.gson.annotations.SerializedName;

public abstract class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Valid
	@Size(max=10)
	@SerializedName("quick_replies")
	protected List<QuickReply> quickReplies;

	public List<QuickReply> getQuickReplies() {
		return quickReplies;
	}

	public void setQuickReplies(List<QuickReply> quickReplies) {
		this.quickReplies = quickReplies;
	}

}
