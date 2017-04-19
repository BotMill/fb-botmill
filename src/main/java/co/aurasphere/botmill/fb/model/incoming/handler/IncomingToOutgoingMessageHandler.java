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
package co.aurasphere.botmill.fb.model.incoming.handler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import co.aurasphere.botmill.core.BotBeanState;
import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.core.annotation.Bot;
import co.aurasphere.botmill.core.internal.exception.BotMillEventMismatchException;
import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;
import co.aurasphere.botmill.fb.FbBotApi;
import co.aurasphere.botmill.fb.autoreply.MessageAutoReply;
import co.aurasphere.botmill.fb.event.AnyEvent;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.event.media.AudioEvent;
import co.aurasphere.botmill.fb.event.media.FileEvent;
import co.aurasphere.botmill.fb.event.media.ImageEvent;
import co.aurasphere.botmill.fb.event.media.VideoEvent;
import co.aurasphere.botmill.fb.event.message.LocationEvent;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.event.message.MessagePatternEvent;
import co.aurasphere.botmill.fb.event.message.QuickReplyMessageEvent;
import co.aurasphere.botmill.fb.event.message.QuickReplyMessagePatternEvent;
import co.aurasphere.botmill.fb.event.postback.PostbackEvent;
import co.aurasphere.botmill.fb.event.postback.PostbackPatternEvent;
import co.aurasphere.botmill.fb.model.annotation.FbBotMillController;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * The Class IncomingToOutgoingMessageHandler.
 * 
 * This is the main incoming to outgoing handler that handles the catching
 * and responses from Facebook. 
 * 
 * @author Alvin Reyes
 */
public class IncomingToOutgoingMessageHandler {
	
	/** The instance. */
	private static IncomingToOutgoingMessageHandler instance;
	
	/** The Constant CONST_INCOMING_MSG_SETNAME. */
	private static final String CONST_INCOMING_MSG_SETNAME = "setEnvelope";
	
	/** The Constant CONST_EVENT_SETNAME. */
	private static final String CONST_EVENT_SETNAME = "setEvent";

	private List<Method> methodMapCatchAll = new ArrayList<Method>();
	
	/**
	 * Creates the handler.
	 *
	 * @return the incoming to outgoing message handler
	 */
	public static IncomingToOutgoingMessageHandler getInstance() {
		if (instance == null) {
			instance = new IncomingToOutgoingMessageHandler();
		}
		return instance;
	}
	
	
	/**
	 * Process.
	 *
	 * @param message the message
	 * @return the incoming to outgoing message handler
	 */
	public IncomingToOutgoingMessageHandler process(MessageEnvelope message) {
		this.handleOutgoingMessage(message);
		return this;
	}
	
	/**
	 * Handle outgoing message.
	 *
	 * @param message the message
	 */
	private void handleOutgoingMessage(MessageEnvelope message) {
		methodMapCatchAll = new ArrayList<Method>();
		for (BotDefinition defClass : ConfigurationUtils.getBotDefinitionInstance()) {
			if (defClass.getClass().isAnnotationPresent(Bot.class)) {
				Bot botClass = defClass.getClass().getAnnotation(Bot.class);
				if(botClass.state().equals(BotBeanState.PROTOTYPE)) {
					try {
						defClass.getClass().newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				
				for (Method method : defClass.getClass().getMethods()) {
					if (method.isAnnotationPresent(FbBotMillController.class)) {
						FbBotMillController botMillController = method.getAnnotation(FbBotMillController.class);
						
						try {
							if(botMillController.text().equals(".*.") || botMillController.eventType().equals(FbBotMillEventType.ANY)) {
								methodMapCatchAll.add(method);
							}else {
								FbBotMillEvent event = toEventActionFrame(botMillController);
								if (event.verifyEventCondition(message)) {

									defClass.getClass().getSuperclass()
											.getDeclaredMethod(CONST_INCOMING_MSG_SETNAME, MessageEnvelope.class)
											.invoke(defClass, message);

									defClass.getClass().getSuperclass()
											.getDeclaredMethod(CONST_EVENT_SETNAME, FbBotMillEvent.class)
											.invoke(defClass, event);
									
									FbBotApi.setFbBot(defClass);
			
									method.invoke(defClass, message);
									return;

								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							return;
						}
					}
				}
				
				//	if none passed then check the catch all methods.
				for(Method catchAllMethod: methodMapCatchAll) {
					if (catchAllMethod.isAnnotationPresent(FbBotMillController.class)) {
						FbBotMillController botMillController = catchAllMethod.getAnnotation(FbBotMillController.class);
						try {
							
							FbBotMillEvent event = toEventActionFrame(botMillController);			
							if (event.verifyEventCondition(message)) {
								
								defClass.getClass().getSuperclass()
										.getDeclaredMethod(CONST_INCOMING_MSG_SETNAME, MessageEnvelope.class)
										.invoke(defClass, message); 
								
								defClass.getClass().getSuperclass()
										.getDeclaredMethod(CONST_EVENT_SETNAME, FbBotMillEvent.class)
										.invoke(defClass, event);
								
								FbBotApi.setFbBot(defClass);
								catchAllMethod.invoke(defClass, message);
								return;

							}
						} catch (Exception e) {
							e.printStackTrace();
							return;
						}
					}
				}
			}
		}
	}

	/**
	 * To event action frame.
	 *
	 * @param botMillController the bot mill controller
	 * @return the fb bot mill event
	 * @throws BotMillEventMismatchException the bot mill event mismatch exception
	 */
	private FbBotMillEvent toEventActionFrame(FbBotMillController botMillController)
			throws BotMillEventMismatchException {
		boolean caseSensitive = botMillController.caseSensitive();

		switch (botMillController.eventType()) {
		case MESSAGE:
			if (!botMillController.text().equals("")) {
				return new MessageEvent(botMillController.text(), caseSensitive);
			} else {
				throw new BotMillEventMismatchException("text attribute missing");
			}
		case MESSAGE_PATTERN:
			if (!botMillController.pattern().equals("")) {
				return new MessagePatternEvent(Pattern.compile(botMillController.pattern()));
			} else {
				throw new BotMillEventMismatchException("pattern attribute missing");
			}
		case POSTBACK:
			if (!botMillController.postback().equals("")) {
				return new PostbackEvent(botMillController.postback());
			} else {
				throw new BotMillEventMismatchException("postback attribute missing");
			}
		case POSTBACK_PATTERN:
			if (!botMillController.postbackPattern().equals("")) {
				return new PostbackPatternEvent(Pattern.compile(botMillController.postbackPattern()));
			} else {
				throw new BotMillEventMismatchException("postback pattern attribute missing");
			}
		case QUICK_REPLY_MESSAGE:
			if (!botMillController.quickReplyPayload().equals("")) {
				return new QuickReplyMessageEvent(botMillController.quickReplyPayload());
			} else {
				throw new BotMillEventMismatchException("quickpayload attribute missing");
			}
		case QUICK_REPLY_MESSAGE_PATTERN:
			if (!botMillController.quickReplyPayloadPattern().equals("")) {
				return new QuickReplyMessagePatternEvent(Pattern.compile(botMillController.quickReplyPayloadPattern()));
			} else {
				throw new BotMillEventMismatchException("quickpayload pattern attribute missing");
			}
		case LOCATION:
			return new LocationEvent();
		case IMAGE:
			return new ImageEvent();
		case VIDEO:
			return new VideoEvent();
		case AUDIO:
			return new AudioEvent();
		case FILE:
			return new FileEvent();
		case ANY:
			return new AnyEvent();
		default:
			throw new BotMillEventMismatchException("Unsupported Event Type: " + botMillController.eventType());
		}
	}
}
