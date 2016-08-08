package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.outcoming.action.TypingAction;

/**
 * Static class that allows the creation of a {@link FaceBotResponse}.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class ReplyFactory {

	/**
	 * Adds a {@link TypingAction} to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/sender-actions"
	 *      > Facebook's Messenger Platform Sender Actions Documentation</a>
	 * 
	 * @param action
	 *            the action to add. Can't be null.
	 * @return a builder for that action.
	 */
	public static ActionResponseBuilder addTypingAction(TypingAction action) {
		return new ActionResponseBuilder(action);
	}

	/**
	 * Adds a Button Template to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/button-template"
	 *      > Facebook's Messenger Platform Button Template Documentation</a>
	 * 
	 * @param message
	 *            the message of the Button Template.
	 * @return a builder for the template.
	 */
	public static ButtonTemplateMessageBuilder addButtonTemplate(String message) {
		return new ButtonTemplateMessageBuilder(message);
	}

	/**
	 * Adds a Generic Template to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/generic-template"
	 *      > Facebook's Messenger Platform Generic Template Documentation</a>
	 * 
	 * @return a builder for the template.
	 */
	public static GenericTemplateMessageBuilder addGenericTemplate() {
		return new GenericTemplateMessageBuilder();
	}

	/**
	 * Creates a response which contains only a text message.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/text-message"
	 *      > Facebook's Messenger Platform Text Message Documentation</a>
	 * 
	 * @param message
	 *            the message to create.
	 * @return a builder for the response.
	 */
	public static TextMessageBuilder addTextMessageOnly(String message) {
		return new TextMessageBuilder(message);
	}

	/**
	 * Adds a Quick Reply Template to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @return a builder for the template.
	 */
	public static QuickReplyMessageBuilder addQuickReplyMessage() {
		return new QuickReplyMessageBuilder();
	}

	/**
	 * Adds an image attachment to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/image-attachment"
	 *      > Facebook's Messenger Platform Image Attachment Documentation</a>
	 * 
	 * @param url
	 *            the url of the image to attach.
	 * @return a builder for the response.
	 */
	public static AttachmentMessageBuilder addImageAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.IMAGE, url);
	}

	/**
	 * Adds an audio attachment to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/audio-attachment"
	 *      > Facebook's Messenger Platform Audio Attachment Documentation</a>
	 * 
	 * @param url
	 *            the url of the audio to attach.
	 * @return a builder for the response.
	 */
	public static AttachmentMessageBuilder addAudioAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.AUDIO, url);
	}

	/**
	 * Adds a video attachment to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/video-attachment"
	 *      > Facebook's Messenger Platform Video Attachment Documentation</a>
	 * 
	 * @param url
	 *            the url of the video to attach.
	 * @return a builder for the response.
	 */
	public static AttachmentMessageBuilder addVideoAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.VIDEO, url);
	}

	/**
	 * Adds a file attachment to the response.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/file-attachment"
	 *      > Facebook's Messenger Platform File Attachment Documentation</a>
	 * 
	 * @param url
	 *            the url of the file to attach.
	 * @return a builder for the response.
	 */
	public static AttachmentMessageBuilder addFileAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.FILE, url);
	}

}
