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

import co.aurasphere.botmill.fb.FbBot;
import co.aurasphere.botmill.fb.FbBotDefinition;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.callback.Postback;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

/**
 * Testing facility for FbBotMill framework.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillMockMediator {

	/**
	 * Indicates where the mock are enabled or not. The mocks are enabled as
	 * soon as one of the getInstance methods of this class is called.
	 */
	private static boolean mockEnabled;

	/**
	 * The mocked page-scoped user ID used as recipient. For more informations
	 * on how to find yours, read on the <a href
	 * ="https://github.com/BotMill/fb-botmill/wiki/Unit-Testing"> official
	 * GitHub wiki</a>.
	 */
	private static String facebookMockId;

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
	 * The instance.
	 */
	private static FbBotMillMockMediator instance;

	/**
	 * Instantiates a new face bot mock mediator.
	 */
	private FbBotMillMockMediator() {
	}

	/**
	 * Constructor that registers a mocked page-scoped user ID as a recipient
	 * and a list of {@link FbBotDefinition}.
	 *
	 * @param facebookMockId
	 *            the {@link #facebookMockId}.
	 * @param fbBotDefinitions
	 *            a list of {@link FbBotDefinition} to register.
	 * @return single instance of FbBotMillMockMediator
	 */
	public static FbBotMillMockMediator getInstance(String facebookMockId,
			FbBotDefinition... fbBotDefinitions) {
		if (instance == null) {
			instance = new FbBotMillMockMediator();
		}
		FbBotMillMockMediator.mockEnabled = true;
		FbBotMillMockMediator.facebookMockId = facebookMockId;

		if (fbBotDefinitions != null) {
			for (FbBotDefinition f : fbBotDefinitions) {
				f.defineBehavior();
			}
		}
		return instance;
	}

	/**
	 * Constructor that registers a mocked page-scoped user ID as a recipient
	 * and instantiates and registers a list of {@link FbBotDefinition} classes.
	 *
	 * @param facebookMockId
	 *            the {@link #facebookMockId}.
	 * @param fbBotDefinitions
	 *            a list of classes implementing {@link FbBotDefinition}.
	 * @return single instance of FbBotMillMockMediator
	 */
	@SafeVarargs
	public static FbBotMillMockMediator getInstance(String facebookMockId,
			Class<? extends FbBotDefinition>... fbBotDefinitions) {
		if (instance == null) {
			instance = new FbBotMillMockMediator();
		}
		FbBotMillMockMediator.mockEnabled = true;
		FbBotMillMockMediator.facebookMockId = facebookMockId;

		if (fbBotDefinitions != null) {
			for (Class<? extends FbBotDefinition> f : fbBotDefinitions) {
				FbBotDefinition definition = instantiateClass(f);
				definition.defineBehavior();
			}
		}
		return instance;
	}

	/**
	 * Utility method that instantiates a {@link FbBotDefinition} class.
	 * 
	 * @param klass
	 *            the class to instantiate.
	 * @return a {@link FbBotDefinition}.
	 */
	private static FbBotDefinition instantiateClass(
			Class<? extends FbBotDefinition> klass) {
		FbBotDefinition definition = null;
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

		System.out.println("Sending message: " + message);
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

		System.out.println("Sending payload: " + payload);
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

		System.out.println("Sending quickReply: " + payload);
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
	 * Checks if is mock enabled.
	 *
	 * @return the {@link #mockEnabled}.
	 */
	public static boolean isMockEnabled() {
		return mockEnabled;
	}

	/**
	 * Gets the {@link #facebookMockId}.
	 *
	 * @return the {@link #facebookMockId}.
	 */
	public static String getFacebookMockId() {
		return facebookMockId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillMockMediator []";
	}

}
