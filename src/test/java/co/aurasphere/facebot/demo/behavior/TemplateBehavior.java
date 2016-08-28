package co.aurasphere.facebot.demo.behavior;

import co.aurasphere.facebot.autoreply.AutoReply;
import co.aurasphere.facebot.autoreply.MessageAutoReply;
import co.aurasphere.facebot.event.message.MessageEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.factory.ReplyFactory;

public class TemplateBehavior extends BaseBehavior {

	public void defineBehavior() {

		addActionFrame(new MessageEvent("text message"), new MessageAutoReply(
				"simple text message"));

		// Returns a button template when message "button template" is received.
		addActionFrame(new MessageEvent("button template"), new AutoReply() {

			@Override
			public FaceBotResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addButtonTemplate("Test button template")
						.addPostbackButton("postback button",
								"postback button payload")
						.addPhoneNumberButton("phone number button",
								"+393541247844")
						.addUrlButton("web url button",
								"https://github.com/Aurasphere/facebot")
						.build(envelope);
			}
		});

		// Returns a generic template when message "generic template" is
		// received.
		addActionFrame(new MessageEvent("generic template"), new AutoReply() {

			@Override
			public FaceBotResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addGenericTemplate()
						.addElement("Generic Template Element 1")
						.addPostbackButton("postback button",
								"postback button payload")
						.addPhoneNumberButton("phone number button",
								"+393541247844")
						.addUrlButton("web url button",
								"https://github.com/Aurasphere/facebot")
						.setSubtitle("Subtitle of element 1")
						.setRedirectUrl("www.aurasphere.co")
						.endElement()
						.addQuickReply("Quick Reply 1",
								"Payload of Quick Reply 1").build(envelope);
			}
		});

		// Returns a text message with quick replies when message
		// "text message with quick replies" is received.
		addActionFrame(new MessageEvent("text message with quick replies"),
				new AutoReply() {

					@Override
					public FaceBotResponse createResponse(
							MessageEnvelope envelope) {
						return ReplyFactory
								.addTextMessageOnly(
										"Text message with quick replies")
								.addQuickReply("Quick reply 1",
										"Payload for quick reply 1")
								.build(envelope);
					}
				});

	}
}
