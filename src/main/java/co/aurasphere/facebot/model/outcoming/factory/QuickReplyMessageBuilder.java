package co.aurasphere.facebot.model.outcoming.factory;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.message.FaceBotMessageResponse;
import co.aurasphere.facebot.model.outcoming.message.Message;
import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;
import co.aurasphere.facebot.model.outcoming.quickreply.QuickReplyMessage;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.validator.FaceBotValidator;

/**
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class QuickReplyMessageBuilder extends PayloadDelegatorBuilder {

	private List<QuickReply> quickReplies;
	
	private String textMessage;
	
	private Attachment attachment;

	QuickReplyMessageBuilder(){
		this.quickReplies = new ArrayList<QuickReply>();
	}

	public QuickReplyMessageBuilder addTextMessage(String textMessage){
		FaceBotValidator.notEmpty(textMessage, "Text message");
		this.textMessage = textMessage;
		return this;
	}
	
	public QuickReplyMessageBuilder addQuickReply(String title, String payload) {
		FaceBotValidator.shorterThanNotEmpty(title,
				FaceBotConstants.BUTTON_TITLE_MAX_LENGTH, "Quick Reply title");
		FaceBotValidator.shorterThanNotEmpty(payload,
				FaceBotConstants.PAYLOAD_MAX_LENGTH, "Quick Reply payload");
		FaceBotValidator.lessElementsThan(quickReplies,
				FaceBotConstants.QUICK_REPLY_MAX_ELEMENTS, "Quick Reply list");
		
		quickReplies.add(new QuickReply(title, payload));
		
		return this;
	}
	
	public QuickReplyMessageBuilder addImageAttachment(String url){
		this.attachment = new AttachmentBuilder(AttachmentType.IMAGE, url).build();
		return this;
	}
	
	public QuickReplyMessageBuilder addAudioAttachment(String url){
		this.attachment = new AttachmentBuilder(AttachmentType.AUDIO, url).build();
		return this;
	}
	
	public QuickReplyMessageBuilder addVideoAttachment(String url){
		this.attachment = new AttachmentBuilder(AttachmentType.VIDEO, url).build();
		return this;
	}
	
	public QuickReplyMessageBuilder addFileAttachment(String url){
		this.attachment = new AttachmentBuilder(AttachmentType.FILE, url).build();
		return this;
	}
	
	public ButtonTemplateBuilder<QuickReplyMessageBuilder> addButtonTemplate(String text){
		return new ButtonTemplateBuilder<QuickReplyMessageBuilder>(text, this);
	}
	
	public GenericTemplateBuilder<QuickReplyMessageBuilder> addGenericTemplate(){
		return new GenericTemplateBuilder<QuickReplyMessageBuilder>(this);
	}
	
	public FaceBotResponse build(MessageEnvelope envelope) {
		FaceBotValidator.onlyOneNotNull("Text Message, Attachment, Template", textMessage, attachment, payload);
		User recipient = getRecipient(envelope);
		Message message = null;
		if(textMessage != null){
			message = new QuickReplyMessage(textMessage, quickReplies);
		} 
		if(attachment != null){
			message = new QuickReplyMessage(attachment, quickReplies);
		}
		if(payload != null){
			Attachment attachment = new AttachmentBuilder(AttachmentType.TEMPLATE, this.payload).build();
			message = new QuickReplyMessage(attachment, quickReplies);
		}
		return new FaceBotMessageResponse(recipient, message);
	}
}
