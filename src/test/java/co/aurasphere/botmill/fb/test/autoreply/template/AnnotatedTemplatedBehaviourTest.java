/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.test.autoreply.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.core.BotBeanState;
import co.aurasphere.botmill.core.annotation.Bot;
import co.aurasphere.botmill.fb.FbBot;
import co.aurasphere.botmill.fb.api.MessengerProfileApi;
import co.aurasphere.botmill.fb.api.UploadApi;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.autoreply.MessageAutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.model.annotation.FbBotMillController;
import co.aurasphere.botmill.fb.model.annotation.FbBotMillInit;
import co.aurasphere.botmill.fb.model.api.upload.UploadAttachmentResponse;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.RequestedUserInfo;

/**
 * The Class TemplateBehavior.
 */
@Bot(state=BotBeanState.PROTOTYPE)
public class AnnotatedTemplatedBehaviourTest extends FbBot {

	/**
	 * Initialize.
	 */
	@FbBotMillInit
	public void initialize() {

		List<Button> buttons = new ArrayList<Button>();
		buttons.add(ButtonFactory.createPostbackButton("Postback Button", "PPB Payload"));
		buttons.add(ButtonFactory.createUrlButton("URL Button", "http://www.aurasphere.co"));

		// Sets the thread settings.
		MessengerProfileApi.setGetStartedButton("get_started");
		MessengerProfileApi.setGreetingMessage("hello");

	}

	/**
	 * Gets the started.
	 *
	 * @return the started
	 */
	@FbBotMillController(eventType = FbBotMillEventType.POSTBACK, postback = "get_started")
	public void getStarted(MessageEnvelope envelope) {
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				botMillSession().buildSession(envelope.getRecipient().getId());
				return ReplyFactory.addTextMessageOnly("Hi!").build(envelope);
			}
		});		
	}
	
	@FbBotMillController(eventType = FbBotMillEventType.IMAGE)
	public void getImage(MessageEnvelope envelope) {
		reply(new MessageAutoReply("image received"));
	}
	/**
	 * Catch all post back.
	 */
	// This method catches all the postback, saves it to a variable and execute
	// the response.
	@FbBotMillController(eventType = FbBotMillEventType.POSTBACK_PATTERN, postbackPattern = ".*.")
	public void catchAllPostBack(MessageEnvelope envelope) {
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				botMillSession().addKeyValuePair("postback_option_value", envelope.getMessage().getText());
				return null;
			}
		});

	}

	/**
	 * Catch text and reply.
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "Hi!", caseSensitive = true)
	public void catchTextAndReply(MessageEnvelope envelope) {
			
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				String greetingMessage = "Hey There! Ahoy ";
				return ReplyFactory.addTextMessageOnly(greetingMessage).build(envelope);
			}
		});
	
	}
	
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "Hi with Image!", caseSensitive = true)
	public void catchTextAndReplyWithImage(MessageEnvelope envelope) {
		
//		
		UploadAttachmentResponse response = UploadApi
				.uploadAttachment(
						AttachmentType.IMAGE,
						"http://vignette2.wikia.nocookie.net/nickelodeon/images/2/27/Spongebob_PNG.png/revision/latest?cb=20120702055752");
		String attachmentId = response.getAttachmentId();
		
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				String greetingMessage = "Hey There! ";
				return ReplyFactory.addTextMessageOnly(greetingMessage).build(envelope);
			}
		});
	
	}

	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "reuse image", caseSensitive = true)
	public void replyWithImageAttachment(MessageEnvelope envelope) {
		UploadAttachmentResponse response = UploadApi
				.uploadAttachment(
						AttachmentType.IMAGE,
						"http://vignette2.wikia.nocookie.net/nickelodeon/images/2/27/Spongebob_PNG.png/revision/latest?cb=20120702055752");
		final String attachmentId = response.getAttachmentId();
		reply(new AutoReply() {
			
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.getReusableImageAttachment(attachmentId).build(envelope);
			}
		});
	}
	
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "reuse video", caseSensitive = true)
	public void replyWithVideoAttachment(MessageEnvelope envelope) {
		UploadAttachmentResponse response = UploadApi
				.uploadAttachment(
						AttachmentType.VIDEO,
						"http://www.engr.colostate.edu/me/facil/dynamics/files/drop.avi");
		final String attachmentId = response.getAttachmentId();
		reply(new AutoReply() {
			
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.getReusableVideoAttachment(attachmentId).build(envelope);
			}
		});
	}
	
	/**
	 * Reply text.
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "text message", caseSensitive = true)
	public void replyText(MessageEnvelope envelope) {
		reply(new MessageAutoReply("simple text message"));
	}

	/**
	 * Initial greeting.
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE_PATTERN, pattern = "(?i:hi)|(?i:hello)|(?i:hey)|(?i:good day)|(?i:home)")
	public void initialGreeting(MessageEnvelope envelope) {

		addReply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTypingAction(TypingAction.TYPING_ON).build(envelope);
			}
		});

		addReply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				String greetingMessage = "Hey There! ";
				return ReplyFactory.addTextMessageOnly(greetingMessage).build(envelope);
			}
		});

		addReply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				String greetingMessage = "Hey There Again! ";
				return ReplyFactory.addTextMessageOnly(greetingMessage).build(envelope);
			}
		});

		executeReplies();

	}

	/**
	 * Reply with button template.
	 *
	 * @param envelope
	 *            the envelope
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "button template", caseSensitive = false)
	public void replyWithButtonTemplate(MessageEnvelope envelope) {
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addButtonTemplate("Test button template")
						.addPostbackButton("postback button", "postback button payload")
						.addPhoneNumberButton("phone number button", "+393541247844")
						.addUrlButton("web url button", "https://github.com/BotMill/fb-botmill").build(envelope);
			}
		});
	}

	/**
	 * Reply with lis template.
	 *
	 * @param envelope
	 *            the envelope
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "list template", caseSensitive = false)
	public void replyWithLisTemplate(MessageEnvelope envelope) {

		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addListTemplate().addElement("Classic T-Shirt Collection")
						.setSubtitle("See all our colors")
						.addButton(ButtonFactory.createUrlButton("View",
								"https://peterssendreceiveapp.ngrok.io/collection"))
						.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/collection.png")
						.setDefaultAction(ButtonFactory
								.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/shop_collection"))
						.endElement().addElement("Classic White T-Shirt").setSubtitle("100% Cotton, 200% Comfortable")
						.addButton(ButtonFactory.createUrlButton("Shop Now",
								"https://peterssendreceiveapp.ngrok.io/shop?item=100"))
						.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/white-t-shirt.png")
						.setDefaultAction(ButtonFactory
								.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/view?item=100"))
						.endElement().addElement("Classic Blue T-Shirt").setSubtitle("100% Cotton, 200% Comfortable")
						.addButton(ButtonFactory.createUrlButton("Shop Now",
								"https://peterssendreceiveapp.ngrok.io/shop?item=101"))
						.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/blue-t-shirt.png")
						.setDefaultAction(ButtonFactory
								.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/view?item=101"))
						.endElement().addElement("Classic Black T-Shirt").setSubtitle("100% Cotton, 200% Comfortable")
						.addButton(ButtonFactory.createUrlButton("Shop Now",
								"https://peterssendreceiveapp.ngrok.io/shop?item=102"))
						.setImageUrl("https://peterssendreceiveapp.ngrok.io/img/black-t-shirt.png")
						.setDefaultAction(ButtonFactory
								.createDefaultActionButton("https://peterssendreceiveapp.ngrok.io/view?item=102"))
						.endElement().addButton(ButtonFactory.createPostbackButton("View more", "view"))
						.build(envelope);
			}
		});
	}

	/**
	 * Replywith quick replies.
	 *
	 * @param envelope
	 *            the envelope
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "quick replies", caseSensitive = false)
	public void replywithQuickReplies(MessageEnvelope envelope) {
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Text message with quick replies")
						.addQuickReply("Quick reply 1", "Payload for quick reply 1").build(envelope);
			}
		}, new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Text message with quick replies")
						.addQuickReply("Quick reply 2", "Payload for quick reply 1").build(envelope);
			}
		}, new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addTextMessageOnly("Text message with quick replies")
						.addQuickReply("Quick reply 3", "Payload for quick reply 1").build(envelope);
			}
		});
	}

	/**
	 * Reply with receipt template.
	 *
	 * @param envelope
	 *            the envelope
	 */
	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "receipt template", caseSensitive = true)
	public void replyWithReceiptTemplate(MessageEnvelope envelope) {
		reply(new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addReceiptTemplate("Donato Rimenti", "15", "EUR", "Visa 1234")
						.setSummary(new BigDecimal(201), new BigDecimal(10), new BigDecimal(13), new BigDecimal(240))
						.setMerchantName("Aurasphere co").addElement("Element 1").setCurrency("EUR").setQuantity(29)
						.setPrice(new BigDecimal(200)).setSubtitle("Element 1 subtitle").endElement()
						.setTimestamp("1243").build(envelope);
			}
		});
	}

	@FbBotMillController(eventType = FbBotMillEventType.MESSAGE, text = "buy button", caseSensitive = true)
	public void replyWithBuyButton(MessageEnvelope envelope) {
		reply(new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory.addGenericTemplate().addElement("A simple Button Template with a Buy Button")
						.addButton(ButtonFactory.createBuyButton("buy_button_payload")
								.setPaymentSummary("USD", PaymentType.FIXED_AMOUNT, "BotMill.io")
								.addPriceLabel("A price label", "2").setTestPayment(true)
								.addRequestedUserInfo(RequestedUserInfo.CONTACT_PHONE).build())
						.endElement().build(envelope);
			}
		});
	}

}
