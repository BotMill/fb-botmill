package co.aurasphere.botmill.fb.model.outcoming.message;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

import com.google.gson.annotations.SerializedName;


/**
 * An object that represents the content of a {@link FbBotMillMessageResponse}.
 * 
 * @author Donato Rimenti
 * @date Dec 24, 2016
 */
public abstract class Message implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The quick replies of this message.
	 */
	@Valid
	@Size(max = FbBotMillValidationConstants.QUICK_REPLY_MAX_ELEMENTS)
	@SerializedName("quick_replies")
	protected List<QuickReply> quickReplies;

	/**
	 * Gets the {@link #quickReplies}.
	 *
	 * @return the {@link #quickReplies}.
	 */
	public List<QuickReply> getQuickReplies() {
		return quickReplies;
	}

	/**
	 * Sets the {@link #quickReplies}.
	 *
	 * @param quickReplies the {@link #quickReplies} to set.
	 */
	public void setQuickReplies(List<QuickReply> quickReplies) {
		this.quickReplies = quickReplies;
	}

}
