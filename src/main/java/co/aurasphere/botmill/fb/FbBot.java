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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.core.BotMillPolicy;
import co.aurasphere.botmill.core.BotMillSession;
import co.aurasphere.botmill.fb.actionframe.ActionFrame;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.annotation.FbBotMillInit;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * Base {@link BotDefinition} implementation.
 * 
 * @author Donato Rimenti
 * @author Alvin Reyes
 * 
 */
public abstract class FbBot implements BotDefinition {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(FbBot.class);

	/**
	 * A list of registered {@link FbBotMillEvent} for the current bot.
	 */
	private List<ActionFrame> actionFrameList;
	/**
	 * The policy this bot follows when processing the callback handler list.
	 */
	private BotMillPolicy botMillPolicy;
	/**
	 * The bot mill session.
	 */
	private BotMillSession botMillSession;
	/**
	 * The {@link FbBotMillEvent} object created by this class for each
	 * annotated method.
	 */
	private volatile FbBotMillEvent event;
	
	/** The envelope. */
	private volatile MessageEnvelope envelope;
	
	/** The action frame. */
	private volatile ActionFrame actionFrame;
	
	/**
	 * Sets the event.
	 *
	 * @param event the new event
	 */
	public synchronized void setEvent(FbBotMillEvent event) {this.event = event;}
	public synchronized FbBotMillEvent getEvent() {return this.event;}
	
	/**
	 * Sets the envelope.
	 *
	 * @param envelope the new envelope
	 */
	public synchronized void setEnvelope(MessageEnvelope envelope) {this.envelope = envelope;}
	public synchronized MessageEnvelope getEnvelope() {return this.envelope;}

	/**
	 * Base constructor. Instantiates a bot and registers it to the context.
	 * 
	 * @param botmillPolicy
	 *            the policy this bot should follow.
	 */
	public FbBot(BotMillPolicy botmillPolicy) {
		logger.debug("AbstractFbot - Start Initialize");
		
		this.botMillPolicy = botmillPolicy;
		this.actionFrameList = new ArrayList<ActionFrame>();
		this.buildAnnotatedInitBehaviour();
		
		
		// Create the botmill session.
		
		FbBotMillContext.getInstance().register(this);

		logger.debug("AbstractFbot - End Initialize");
	}
	

	/**
	 * Base constructor. Instantiates a bot and registers it to the context.
	 */
	public FbBot() {
		this(BotMillPolicy.FIRST_ONLY);
	}

	/**
	 * This is the method to define the behaviour of the bot. As of the
	 * introduction of the Annotation based configuration, this is overriden on
	 * the supertype level.
	 * 
	 * The method can still be overriden by a concrete Bot class and use to
	 * define behaviour.
	 */
	public void defineBehaviour() {
	};

	/**
	 * Adds an {@link ActionFrame} to this bot.
	 * 
	 * @param actionFrame
	 *            the actionFrame to add.
	 */
	public void addActionFrame(ActionFrame actionFrame) {
		this.actionFrameList.add(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to this bot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} to handle.
	 * @param reply
	 *            the {@link AutoReply} which should handle the event.
	 */
	public void addActionFrame(FbBotMillEvent event, AutoReply reply) {
		ActionFrame frame = new ActionFrame(event, reply);
		this.actionFrameList.add(frame);
	}

	/**
	 * Adds an {@link ActionFrame} to this bot with multiple reply.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} to handle.
	 * @param replies
	 *            the collection of {@link AutoReply} which should handle the
	 *            event.
	 */
	public void addActionFrame(FbBotMillEvent event, AutoReply... replies) {
		ActionFrame frame = new ActionFrame(event, replies);
		this.actionFrameList.add(frame);
	}

	/**
	 * Builds the annotated init behaviour.
	 */
	private void buildAnnotatedInitBehaviour() {
		Method[] methods = this.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(FbBotMillInit.class)) {
				try {
					method.invoke(this);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * This method is used to create multiple replies.
	 *
	 * @param replies
	 *            the set of replies in a form of a var-args
	 */
	protected void reply(AutoReply... replies) {
		for(AutoReply autoReply: replies) {
			autoReply.reply(this.getEnvelope());
		}
	}

	/**
	 * Bot mill session.
	 *
	 * @return the bot mill session
	 */
	protected final synchronized BotMillSession botMillSession() {
		return this.botMillSession;
	}
	
	/**
	 * This method is used to create a reply.
	 *
	 * @param reply
	 *            the reply
	 */
	protected void reply(AutoReply reply) {
		reply.reply(this.getEnvelope());
	}
	
	/**
	 * Adds the reply.
	 *
	 * @param reply the reply
	 */
	protected void addReply(AutoReply reply) {
		if(actionFrame == null) {
			actionFrame = new ActionFrame(this.getEvent());
		}
		actionFrame.addReply(reply);
	}
	
	/**
	 * Execute replies.
	 */
	protected void executeReplies() {
		if(actionFrame.getEvent().verifyEventCondition(this.getEnvelope())) {
			if (actionFrame.getReplies() != null && actionFrame.getReplies().size() > 0) {
				if (actionFrame.processMultipleReply(envelope)
						&& this.botMillPolicy.equals(BotMillPolicy.FIRST_ONLY)) {
				}
			} else {
				if (actionFrame.process(envelope)
						&& this.botMillPolicy.equals(BotMillPolicy.FIRST_ONLY)) {
				}
			}
		}
		actionFrame = null;
	}

	
	/**
	 * Checks if there's any registered {@link FbBotMillEvent} for the incoming
	 * callback. If there's any, then the callback is handled. The chain will be
	 * processed according to the {@link BotMillPolicy} followed by this bot. If
	 * the policy is {@link BotMillPolicy#FIRST_ONLY}, the chain will be
	 * processed until the first callback matches. Otherwise, if the policy is
	 * {@link BotMillPolicy#PROCESS_ALL}, all the chain will always be
	 * processed.
	 * 
	 * @param envelope
	 *            the incoming message.
	 */
	public void processMessage(MessageEnvelope envelope) {
		
		for (ActionFrame f : this.actionFrameList) {
			// If the policy is FIRST_ONLY stop processing the chain at the
			// first trigger.
			this.envelope = new MessageEnvelope();
			if (f.getReplies() != null && f.getReplies().size() > 0) {
				if (f.processMultipleReply(envelope)
						&& this.botMillPolicy.equals(BotMillPolicy.FIRST_ONLY)) {
					break;
				}
			} else {
				if (f.process(envelope)
						&& this.botMillPolicy.equals(BotMillPolicy.FIRST_ONLY)) {
					break;
				}
			}
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
		result = prime * result
				+ ((actionFrameList == null) ? 0 : actionFrameList.hashCode());
		result = prime * result
				+ ((botMillPolicy == null) ? 0 : botMillPolicy.hashCode());
		result = prime * result
				+ ((botMillSession == null) ? 0 : botMillSession.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
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
		FbBot other = (FbBot) obj;
		if (actionFrameList == null) {
			if (other.actionFrameList != null)
				return false;
		} else if (!actionFrameList.equals(other.actionFrameList))
			return false;
		if (botMillPolicy != other.botMillPolicy)
			return false;
		if (botMillSession == null) {
			if (other.botMillSession != null)
				return false;
		} else if (!botMillSession.equals(other.botMillSession))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "AbstractFbBot [actionFrameList=" + actionFrameList
//				+ ", botMillPolicy=" + botMillPolicy + ", botMillSession="
//				+ botMillSession + ", event=" + event + "]";
//	}

}
