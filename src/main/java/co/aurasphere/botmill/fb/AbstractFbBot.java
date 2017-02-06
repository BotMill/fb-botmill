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
package co.aurasphere.botmill.fb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.actionframe.ActionFrame;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.AnyEvent;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.message.LocationEvent;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.event.message.MessagePatternEvent;
import co.aurasphere.botmill.fb.event.message.QuickReplyMessageEvent;
import co.aurasphere.botmill.fb.event.message.QuickReplyMessagePatternEvent;
import co.aurasphere.botmill.fb.event.postback.PostbackEvent;
import co.aurasphere.botmill.fb.event.postback.PostbackPatternEvent;
import co.aurasphere.botmill.fb.exception.FbBotMillControllerEventMisMatchException;
import co.aurasphere.botmill.fb.model.annotation.BotMillController;

/**
 * Base {@link FbBotDefinition} implementation that takes care of the
 * {@link FbBot} handling.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class AbstractFbBot implements FbBotDefinition {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(AbstractFbBot.class);
	
	/**
	 * The {@link FbBot} object handled by this class.
	 */
	protected FbBot fbBot;

	/**
	 * The {@link FbBotMillEvent} object created by this class for each annotated method.
	 */
	protected FbBotMillEvent event;

	/**
	 * Base constructor. Instantiates a {@link FbBot} and registers it to the
	 * context.
	 */
	public AbstractFbBot() {
		this.fbBot = new FbBot();
		this.buildAnnotatedBehaviour();
	}
	
	/**
	 * This is the method to define the behaviour of the bot.
	 * As of the introduction of the Annotation based configuration, 
	 * this is overriden on the supertype level. 
	 * 
	 * The method can still be overriden by a concrete Bot class and use
	 * to define behaviour.
	 */
	@Override
	public void defineBehavior() {} 

	/**
	 * Adds an {@link ActionFrame} to the current bot.
	 * 
	 * @param actionFrame
	 *            the ActionFrame to add.
	 */
	protected void addActionFrame(ActionFrame actionFrame) {
		fbBot.addActionFrame(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to the current bot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param reply
	 *            the {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, AutoReply reply) {
		fbBot.addActionFrame(event, reply);
	}

	/**
	 * Adds an {@link ActionFrame} to the current bot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param replies
	 *            the list of {@link AutoReply} to return when the event is
	 *            triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, AutoReply... replies) {
		fbBot.addActionFrame(event, replies);
	}

	/**
	 * This is the private method that gets called to
	 * invoke the annotated methods to build the behaviours
	 */
	private void buildAnnotatedBehaviour() {
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(BotMillController.class)) {
				try {
					BotMillController botMillController = method.getAnnotation(BotMillController.class);
					event = toEventActionFrame(botMillController);
					method.invoke(this);
				} catch (FbBotMillControllerEventMisMatchException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * This method is used to create a reply.
	 *
	 * @param reply the reply
	 */
	protected void reply(AutoReply reply) {
		fbBot.addActionFrame(event, reply);
	}
	
	/**
	 * This method is used to create multiple replies.
	 *
	 * @param replies the set of replies in a form of a var-args
	 */
	protected void reply(AutoReply... replies) {
		fbBot.addActionFrame(event, replies);
	}

	/**
	 * To event action frame.
	 *
	 * @param botMillController the bot mill controller
	 * @return the fb bot mill event
	 * @throws FbBotMillControllerEventMisMatchException the fb bot mill controller event mis match exception
	 */
	private FbBotMillEvent toEventActionFrame(BotMillController botMillController)
			throws FbBotMillControllerEventMisMatchException {
		boolean caseSensitive = botMillController.casesensitive();
		switch (botMillController.eventType()) {
		case MESSAGE:
			if (!botMillController.text().equals("")) {
				return new MessageEvent(botMillController.text(), caseSensitive);
			} else {
				throw new FbBotMillControllerEventMisMatchException("text attribute missing");
			}
		case MESSAGE_PATTERN:
			if (!botMillController.pattern().equals("")) {
				return new MessagePatternEvent(botMillController.pattern());
			}else {
				throw new FbBotMillControllerEventMisMatchException("pattern attribute missing");
			}
		case POSTBACK:
			if (!botMillController.postback().equals("")) {
				return new PostbackEvent(botMillController.postback());
			}else {
				throw new FbBotMillControllerEventMisMatchException("postback attribute missing");
			}
		case POSTBACK_PATTERN:
			if (!botMillController.postbackpattern().equals("")) {
				return new PostbackPatternEvent(botMillController.postbackpattern());
			}else {
				throw new FbBotMillControllerEventMisMatchException("postback pattern attribute missing");
			}
		case QUICK_REPLY_MESSAGE:
			if (!botMillController.quickpayload().equals("")) {
				return new QuickReplyMessageEvent(botMillController.quickpayload());
			}else {
				throw new FbBotMillControllerEventMisMatchException("quickpayload attribute missing");
			}
		case QUICK_REPLY_MESSAGE_PATTERN:
			if (!botMillController.quickpayloadpattern().equals("")) {
				return new QuickReplyMessagePatternEvent(botMillController.quickpayloadpattern());
			}else {
				throw new FbBotMillControllerEventMisMatchException("quickpayload pattern attribute missing");
			}
		case LOCATION:
			return new LocationEvent();
		case ANY:
			return new AnyEvent();
		default:
			throw new FbBotMillControllerEventMisMatchException("Unsupported Event Type: " + botMillController.eventType());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fbBot == null) ? 0 : fbBot.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractFbBot other = (AbstractFbBot) obj;
		if (fbBot == null) {
			if (other.fbBot != null)
				return false;
		} else if (!fbBot.equals(other.fbBot))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractFbBot [fbBot=" + fbBot + "]";
	}

}
