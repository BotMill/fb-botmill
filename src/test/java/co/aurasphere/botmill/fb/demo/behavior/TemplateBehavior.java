package co.aurasphere.botmill.fb.demo.behavior;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.autoreply.MessageAutoReply;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;


/**
 * The Class TemplateBehavior.
 */
public class TemplateBehavior extends BaseBehavior {

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.FbBotDefinition#defineBehavior()
	 */
	public void defineBehavior() {

		addActionFrame(new MessageEvent("text message"), new MessageAutoReply(
				"simple text message"));

		// Returns a button template when message "button template" is received.
		addActionFrame(new MessageEvent("button template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
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
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
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
						.addLoginButton("https://github.com/Aurasphere/facebot")
						.addLogoutButton()
						.addShareButton()
						.endElement()
						.addQuickReply("Quick Reply 1",
								"Payload of Quick Reply 1").build(envelope);
			}
		});
		
		// Returns a list template when message "list template" is
		// received. (links are based on facebook's examples).
		addActionFrame(new MessageEvent("list template"), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addListTemplate()
						.addElement(new ListTemplateElement("Classic T-Shirt Collection")
								.setSubtitle("See all our colors")
								.addButton(ButtonFactory.createUrlButton("View", "https://peterssendreceiveapp.ngrok.io/collection"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/collection.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/shop_collection")))
						.addElement(new ListTemplateElement("Classic White T-Shirt")
								.setSubtitle("100% Cotton, 200% Comfortable")
								.addButton(ButtonFactory.createUrlButton("Shop Now", "https://peterssendreceiveapp.ngrok.io/shop?item=100"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/white-t-shirt.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/view?item=100")))
						.addElement(new ListTemplateElement("Classic Blue T-Shirt")
								.setSubtitle("100% Cotton, 200% Comfortable")
								.addButton(ButtonFactory.createUrlButton("Shop Now", "https://peterssendreceiveapp.ngrok.io/shop?item=101"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/blue-t-shirt.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/view?item=101")))
						.addElement(new ListTemplateElement("Classic Black T-Shirt")
								.setSubtitle("100% Cotton, 200% Comfortable")
								.addButton(ButtonFactory.createUrlButton("Shop Now", "https://peterssendreceiveapp.ngrok.io/shop?item=102"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/black-t-shirt.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/view?item=102")))
						.addButton(ButtonFactory.createPostbackButton("View more", "view"))
						.build(envelope);
			}
		});

		// Returns a text message with quick replies when message
		// "text message with quick replies" is received.
		addActionFrame(new MessageEvent("text message with quick replies"),
				new AutoReply() {

					@Override
					public FbBotMillResponse createResponse(
							MessageEnvelope envelope) {
						return ReplyFactory
								.addTextMessageOnly(
										"Text message with quick replies")
								.addQuickReply("Quick reply 1",
										"Payload for quick reply 1")
								.build(envelope);
					}
				});
		
		// Returns a receipt template when message "receipt template" is
		// received.
		addActionFrame(new MessageEvent("receipt template"), new AutoReply() {
			
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addReceiptTemplate("Donato Rimenti", "15", "EUR", "Visa 1234")
						.setSummary(201, 10, 13, 240)
						.setMerchantName("Aurasphere co")
						.addElement("Element 1")
						.setCurrency("EUR")
						.setQuantity(29)
						.setPrice(200)
						.setSubtitle("Element 1 subtitle")
						.endElement()
						.setTimestamp("1243").build(envelope);
			}
		});

	}
}
