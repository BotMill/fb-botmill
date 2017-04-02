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
package co.aurasphere.botmill.fb.support;

import java.util.List;
import java.util.Scanner;

import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.fb.FbBot;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.callback.Postback;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;


/**
 * Testing facility for FbBotMill framework. Since this object is intended only
 * for testing, it is NOT Thread safe.
 * 
 * @author Donato Rimenti
 */
public class FbBotMillMockMediator {

	/**
	 * The mocked page-scoped user ID used as recipient. For more informations
	 * on how to find yours, read on the <a href
	 * ="https://github.com/BotMill/fb-botmill/wiki/Unit-Testing"> official
	 * GitHub wiki</a>.
	 */
	private String facebookMockId;

	/**
	 * The string that should be matched at the beginning of an input in order
	 * to send a payload during {@link #interactiveTest()}.
	 */
	private static final String PAYLOAD_MARKER = "payload:";

	/**
	 * The string that should be matched at the beginning of an input in order
	 * to send a quickreply during {@link #interactiveTest()}.
	 */
	private static final String QUICK_REPLY_MARKER = "quickreply:";

	/**
	 * The string that should be matched at the beginning of an input in order
	 * to stop during {@link #interactiveTest()}.
	 */
	private static final String STOP_MARKER = "stop";

	/**
	 * Constructor that registers a mocked page-scoped user ID as a recipient
	 * and a list of {@link BotDefinition}.
	 *
	 * @param facebookMockId
	 *            the {@link #facebookMockId}.
	 * @param botDefinitions
	 *            a list of {@link BotDefinition} to register.
	 */
	public FbBotMillMockMediator(String facebookMockId,
			BotDefinition... botDefinitions) {
		this.facebookMockId = facebookMockId;

		if (botDefinitions != null) {
			for (BotDefinition f : botDefinitions) {
				f.defineBehaviour();
			}
		}
	}

	/**
	 * Constructor that registers a mocked page-scoped user ID as a recipient
	 * and instantiates and registers a list of {@link BotDefinition} classes.
	 *
	 * @param facebookMockId
	 *            the {@link #facebookMockId}.
	 * @param botDefinitions
	 *            a list of classes implementing {@link BotDefinition}.
	 */
	public FbBotMillMockMediator(String facebookMockId,
			Class<? extends BotDefinition>... botDefinitions) {
		this.facebookMockId = facebookMockId;

		if (botDefinitions != null) {
			for (Class<? extends BotDefinition> f : botDefinitions) {
				BotDefinition definition = instantiateClass(f);
				definition.defineBehaviour();
			}
		}
	}

	/**
	 * Utility method that instantiates a {@link BotDefinition} class.
	 * 
	 * @param klass
	 *            the class to instantiate.
	 * @return a {@link BotDefinition}.
	 */
	private static BotDefinition instantiateClass(
			Class<? extends BotDefinition> klass) {
		BotDefinition definition = null;
		try {
			definition = klass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return definition;
	}

	/**
	 * Sends a text message to all the registered bots. Used to simulate a user
	 * typing in chat with your bot.
	 * 
	 * @param message
	 *            the message to send.
	 */
	public void sendTextMessage(String message) {
		MessageEnvelope envelope = new MessageEnvelope();
		ReceivedMessage body = new ReceivedMessage();

		body.setText(message);
		envelope.setMessage(body);
		envelope.setSender(new User(facebookMockId));

		System.out.println("Sending message: [" + message + "] as user : ["
				+ facebookMockId + "].");
		forward(envelope);
		System.out.println("Sent!");
	}

	/**
	 * Sends a payload to all the registered bots. Used to simulate a user
	 * interacting with buttons.
	 * 
	 * @param payload
	 *            the payload to send.
	 */
	public void sendPayload(String payload) {
		MessageEnvelope envelope = new MessageEnvelope();
		Postback postback = new Postback();

		postback.setPayload(payload);
		envelope.setPostback(postback);
		envelope.setSender(new User(facebookMockId));

		System.out.println("Sending payload: [" + payload + "] as user : ["
				+ facebookMockId + "].");
		forward(envelope);
		System.out.println("Sent!");
	}

	/**
	 * Sends a quickreply to all the registered bots. Used to simulate a user
	 * interacting with buttons.
	 * 
	 * @param payload
	 *            the payload to send.
	 */
	public void sendQuickReplyPayload(String payload) {
		MessageEnvelope envelope = new MessageEnvelope();
		QuickReply quickReply = new QuickReply("Sample", payload);

		ReceivedMessage message = new ReceivedMessage();
		message.setQuickReply(quickReply);
		envelope.setMessage(message);
		envelope.setSender(new User(facebookMockId));

		System.out.println("Sending quick reply: [" + message + "] as user : ["
				+ facebookMockId + "].");
		forward(envelope);
		System.out.println("Sent!");
	}

	/**
	 * Forwards an envelope to the registered bots.
	 * 
	 * @param envelope
	 *            the envelope to forward.
	 */
	public void forward(MessageEnvelope envelope) {
		List<FbBot> bots = FbBotMillContext.getInstance().getRegisteredBots();
		for (FbBot b : bots) {
			b.processMessage(envelope);
		}
	}

	/**
	 * Starts an interactive test that simulates the behavior of the bot
	 * according to the chat inputs. You can send messages to the registered
	 * bots typing in your IDE console. To send a message, just type it. To send
	 * a payload, type {@value #PAYLOAD_MARKER} followed by your payload. To end
	 * the test, type {@value #STOP_MARKER}.
	 */
	public void interactiveTest() {
		// Prints instructions.
		System.out.println("Starting interactive test...");
		System.out
				.printf("Type your message or '%s<YOUR_PAYLOAD>' to send a message or a payload to the bot. Type '%s' to stop the interactive test.\n",
						PAYLOAD_MARKER, STOP_MARKER);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Your input: ");
			String line = scanner.nextLine();

			// If line starts with STOP_MARKER stops the interactive test.
			if (line.startsWith(STOP_MARKER)) {
				break;
			}
			// If line starts with PAYLOAD_MARKER sends a payload, otherwise
			// sends a message.
			if (line.startsWith(PAYLOAD_MARKER)) {
				line = line.replaceFirst(PAYLOAD_MARKER, "");
				sendPayload(line);
			} else if (line.startsWith(QUICK_REPLY_MARKER)) {
				line = line.replaceFirst(QUICK_REPLY_MARKER, "");
				sendQuickReplyPayload(line);
			} else {
				sendTextMessage(line);
			}
		}
		// Ends the test.
		System.out.println("Stopping interactive test...");
		scanner.close();
		System.out.println("Done!");
	}

	/**
	 * Gets the {@link #facebookMockId}.
	 *
	 * @return the {@link #facebookMockId}.
	 */
	public String getFacebookMockId() {
		return facebookMockId;
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
				+ ((facebookMockId == null) ? 0 : facebookMockId.hashCode());
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
		FbBotMillMockMediator other = (FbBotMillMockMediator) obj;
		if (facebookMockId == null) {
			if (other.facebookMockId != null)
				return false;
		} else if (!facebookMockId.equals(other.facebookMockId))
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
		return "FbBotMillMockMediator [facebookMockId=" + facebookMockId + "]";
	}

}
