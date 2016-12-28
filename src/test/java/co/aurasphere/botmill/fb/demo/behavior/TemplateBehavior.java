package co.aurasphere.botmill.fb.demo.behavior;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.autoreply.MessageAutoReply;
import co.aurasphere.botmill.fb.event.message.LocationEvent;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.event.message.MessagePatternEvent;
import co.aurasphere.botmill.fb.event.postback.PostbackEvent;
import co.aurasphere.botmill.fb.internal.util.json.JsonUtils;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebViewHeightRatioType;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;
import co.aurasphere.botmill.fb.model.outcoming.template.list.TopElementStyle;
import co.aurasphere.botmill.fb.threadsettings.FbBotMillThreadSettingsConfiguration;

/**
 * The Class TemplateBehavior.
 */
public class TemplateBehavior extends BaseBehavior {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.FbBotDefinition#defineBehavior()
	 */
	public void defineBehavior() {

		addActionFrame(new MessageEvent("text message"), new MessageAutoReply("simple text message"));

		// Returns a button template when message "button template" is received.
		addActionFrame(new MessageEvent("button template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addButtonTemplate("Test button template")
						.addPostbackButton("postback button", "postback button payload")
						.addPhoneNumberButton("phone number button", "+393541247844")
						.addUrlButton("web url button", "https://github.com/BotMill/fb-botmill").build(envelope);
			}
		});

		// Returns a generic template when message "generic template" is
		// received.
		addActionFrame(new MessageEvent("generic template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addGenericTemplate().addElement("Generic Template Element 1")
						.addPostbackButton("postback button", "postback button payload")
						.addPhoneNumberButton("phone number button", "+393541247844")
						.addUrlButton("web url button", "https://github.com/BotMill/fb-botmill")
						.setSubtitle("Subtitle of element 1").setRedirectUrl("www.aurasphere.co")
						.addLoginButton("https://github.com/BotMill/fb-botmill").addLogoutButton().addShareButton()
						.endElement().addQuickReply("Quick Reply 1", "Payload of Quick Reply 1").build(envelope);
			}
		});

		// Returns a list template when message "list template" is
		// received. (links are based on facebook's examples).
		addActionFrame(new MessageEvent("list template"), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addListTemplate()
						.addElement(
								new ListTemplateElement("Classic T-Shirt Collection").setSubtitle("See all our colors")
										.addButton(ButtonFactory.createUrlButton("View",
												"https://peterssendreceiveapp.ngrok.io/collection"))
										.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/collection.png")
										.setDefaultAction(ButtonFactory.createDefaultActionButton(
												"https://peterssendreceiveapp.ngrok.io/shop_collection")))
						.addElement(new ListTemplateElement("Classic White T-Shirt")
								.setSubtitle("100% Cotton, 200% Comfortable")
								.addButton(ButtonFactory.createUrlButton("Shop Now",
										"https://peterssendreceiveapp.ngrok.io/shop?item=100"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/white-t-shirt.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton(
										"https://peterssendreceiveapp.ngrok.io/view?item=100")))
						.addElement(new ListTemplateElement("Classic Blue T-Shirt")
								.setSubtitle("100% Cotton, 200% Comfortable")
								.addButton(ButtonFactory.createUrlButton("Shop Now",
										"https://peterssendreceiveapp.ngrok.io/shop?item=101"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/blue-t-shirt.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton(
										"https://peterssendreceiveapp.ngrok.io/view?item=101")))
						.addElement(new ListTemplateElement("Classic Black T-Shirt")
								.setSubtitle("100% Cotton, 200% Comfortable")
								.addButton(ButtonFactory.createUrlButton("Shop Now",
										"https://peterssendreceiveapp.ngrok.io/shop?item=102"))
								.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/black-t-shirt.png")
								.setDefaultAction(ButtonFactory.createDefaultActionButton(
										"https://peterssendreceiveapp.ngrok.io/view?item=102")))
						.addButton(ButtonFactory.createPostbackButton("View more", "view")).build(envelope);
			}
		});

		// Returns a text message with quick replies when message
		// "text message with quick replies" is received.
		addActionFrame(new MessageEvent("text message with quick replies"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Text message with quick replies")
						.addQuickReply("Quick reply 1", "Payload for quick reply 1").build(envelope);
			}
		});

		// Returns a receipt template when message "receipt template" is
		// received.
		addActionFrame(new MessageEvent("receipt template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addReceiptTemplate("Donato Rimenti", "15", "EUR", "Visa 1234")
						.setSummary(new BigDecimal(201), new BigDecimal(10), new BigDecimal(13), new BigDecimal(240)).setMerchantName("Aurasphere co").addElement("Element 1")
						.setCurrency("EUR").setQuantity(29).setPrice(new BigDecimal(200)).setSubtitle("Element 1 subtitle").endElement()
						.setTimestamp("1243").build(envelope);
			}
		});
		
		List<String> a = new ArrayList<String>();
		a.add("http://www.alvinjayreyes.com");
		FbBotMillThreadSettingsConfiguration.setWhiteListDomains(a);
		addActionFrame(new MessagePatternEvent(Pattern.compile("(?i:hi)|(?i:hello)|(?i:hey)|(?i:good day)")),
				new AutoReply() {
					@Override
					public FbBotMillResponse createResponse(MessageEnvelope envelope) {
						try {
							System.out.println(JsonUtils.toJson(envelope).toString());
							return ReplyFactory.addGenericTemplate().addElement("Welcome to TechnoWebHub")
									.addButton(ButtonFactory.createWebViewButton("Title",
											"https://www.alvinjayreyes.com", WebViewHeightRatioType.COMPACT))
									.setSubtitle("Tell us what you want (call, about, price list, products, services)")
									.endElement().build(envelope);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
				});

		addActionFrame(new MessagePatternEvent(Pattern.compile("(?i:hi)|(?i:hello)|(?i:hey)|(?i:good day)")),
				new AutoReply() {
					@Override
					public FbBotMillResponse createResponse(MessageEnvelope envelope) {
						ReplyFactory.addTypingAction(TypingAction.TYPING_ON);
						return ReplyFactory.addGenericTemplate().addElement("Welcome to TechnoWebHub")
								.addLoginButton("https://www.alvinjayreyes.com").endElement().build(envelope);
					}
				});

		addActionFrame(new MessagePatternEvent(Pattern.compile("(?:.*price list.*)|(?:.*list of prices.*)")),
				new AutoReply() {

					@Override
					public FbBotMillResponse createResponse(MessageEnvelope envelope) {
						return ReplyFactory
								.addFileAttachment(
										"http://www.oracle.com/us/corporate/pricing/exadata-pricelist-070598.pdf")
								.build(envelope);
					}
				});

		addActionFrame(new MessagePatternEvent(Pattern.compile("(?:.*listtemplate.*)")), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addListTemplate().setTopElementStyle(TopElementStyle.COMPACT)
						.addElement(new ListTemplateElement("Title1")
								.setSubtitle("This is a sample sub title for your product")
								.addButton(ButtonFactory.createPostbackButton("View", "view")).setImageUrl(
										"https://lh4.ggpht.com/mJDgTDUOtIyHcrb69WM0cpaxFwCNW6f0VQ2ExA7dMKpMDrZ0A6ta64OCX3H-NMdRd20=w300"))
						.addElement(new ListTemplateElement("Title2")
								.setSubtitle("This is a sample sub title for your product")
								.addButton(ButtonFactory.createPostbackButton("View", "view"))
								.setImageUrl("http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg"))
						.addElement(new ListTemplateElement("Title3")
								.setSubtitle("This is a sample sub title for your product")
								.addButton(ButtonFactory.createPostbackButton("View", "view"))
								.setImageUrl("http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg"))
						.addElement(new ListTemplateElement("Title4")
								.setSubtitle("This is a sample sub title for your product")
								.addButton(ButtonFactory.createPostbackButton("View", "view"))
								.setImageUrl("http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg"))
						.build(envelope);

			}
		});

		addActionFrame(new PostbackEvent("Back", false), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addGenericTemplate().addElement("Welcome to TechnoWebHub")
						.addPostbackButton("Our Products", "Our Products")
						.addPostbackButton("Our Services", "Our Services")
						.setSubtitle("Tell us what you want (call, about, price list, products, services)").endElement()
						.build(envelope);

			}
		});

		
		addActionFrame(new MessagePatternEvent(Pattern.compile("(?:.*buttonlist.*)")), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addButtonTemplate("I see that you are interested in our products, here they are")
						.addUrlButton("Real Estate App", "http://www.technowebhub.com/blog/fundamentals/binary-search/")
						.addUrlButton("School Management",
								"http://www.technowebhub.com/blog/java/install-jdk-8-windows/")
						.addUrlButton("Nurses Pod",
								"http://www.technowebhub.com/blog/mobile-dev/oracle-maf-development-quick-starter-setup/")
						.build(envelope);

			}
		});


		addActionFrame(new MessageEvent("Location", false), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Location").addQuickLocationReply("Location").build(envelope);
			}
		});

		addActionFrame(new LocationEvent(), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Location").build(envelope);
			}
		});

		addActionFrame(new MessagePatternEvent(Pattern.compile("(?:.*develop.*)")), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addTextMessageOnly(
								"It seems you're interested in our Software Development service, do you want to view our services?")
						.addQuickReply("Yes", "yes_service").addQuickReply("No", "no_service").build(envelope);
			}
		});


		addActionFrame(new MessageEvent("No", false), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addTextMessageOnly(
								"Is there any way I can help you with then? Type in (video, about, price list, products, services)")
						.build(envelope);

			}
		});

		addActionFrame(new MessagePatternEvent("(?:.*thanks.*)|(?:.*thank you.*)"), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addTextMessageOnly(
								"Always a pleasure! If you need further assistance, just use the following chat commands: (call, about, price list, products, services")
						.build(envelope);
			}
		});

		addActionFrame(new MessageEvent("text message", false), new MessageAutoReply("simple text message"));

		// Returns a button template when message "button template" is received.
		addActionFrame(new MessageEvent("button template", false), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addButtonTemplate("Test button template")
						.addPostbackButton("postback button", "postback button payload")
						.addPhoneNumberButton("phone number button", "+393541247844")
						.addUrlButton("web url button", "https://alvinjayreyes.com").build(envelope);
			}
		});

		// Returns a generic template when message "generic template" is
		// received.
		addActionFrame(new MessageEvent("generic template", false), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addGenericTemplate().addElement("Generic Template Element 1")
						.addPostbackButton("postback button", "postback button payload")
						.addPhoneNumberButton("phone number button", "+393541247844")
						.addUrlButton("web url button", "https://alvinjayreyes.com")
						.setSubtitle("Subtitle of element 1").setRedirectUrl("www.alvinjayreyes.com").endElement()
						.addQuickReply("Quick Reply 1", "Payload of Quick Reply 1").build(envelope);
			}
		});

		addActionFrame(new MessagePatternEvent(Pattern.compile(".*")), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addGenericTemplate().addElement("Generic Template Element 1")
						.addPostbackButton("postback button", "postback button payload")
						.addPhoneNumberButton("phone number button", "+393541247844")
						.addUrlButton("web url button", "https://alvinjayreyes.com")
						.setSubtitle("Subtitle of element 1").setRedirectUrl("www.alvinjayreyes.com").endElement()
						.addQuickReply("Quick Reply 1", "Payload of Quick Reply 1").build(envelope);
			}
		});

		// Returns a text message with quick replies when message
		// "text message with quick replies" is received.
		addActionFrame(new MessageEvent("text message with quick replies", false), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Pin")
						.addQuickReply("Quick reply 1", "Payload for quick reply 1").build(envelope);
			}
		});
	}
}
