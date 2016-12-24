package co.aurasphere.botmill.fb.test.support;

import java.util.List;
import java.util.Scanner;

import co.aurasphere.botmill.fb.FbBot;
import co.aurasphere.botmill.fb.FbBotDefinition;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.callback.Postback;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;

/**
 * Testing facility for FaceBot framework.
 * 
 * @author Donato Rimenti
 * @date Aug 27, 2016
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
	 * ="https://github.com/Aurasphere/facebot/wiki/Unit-Testing"> official
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
	 * and a list of FaceBotDefinition.
	 * 
	 * @param facebookMockId
	 *            the {@link #facebookMockId}.
	 * @param faceBotDefinitions
	 *            a list of {@link FbBotDefinition} to register.
	 */
	public static FbBotMillMockMediator getInstance(String facebookMockId,
			FbBotDefinition... faceBotDefinitions) {
		if (instance == null) {
			instance = new FbBotMillMockMediator();
		}
		FbBotMillMockMediator.mockEnabled = true;
		FbBotMillMockMediator.facebookMockId = facebookMockId;

		if (faceBotDefinitions != null) {
			for (FbBotDefinition f : faceBotDefinitions) {
				f.defineBehavior();
			}
		}
		return instance;
	}

	/**
	 * Constructor that registers a mocked page-scoped user ID as a recipient
	 * and instantiates and registers a list of FaceBotDefinition classes.
	 * 
	 * @param facebookMockId
	 *            the {@link #facebookMockId}.
	 * @param faceBotDefinitions
	 *            a list of classes implementing {@link FaceBotDefinition}.
	 */
	@SafeVarargs
	public static FbBotMillMockMediator getInstance(String facebookMockId,
			Class<? extends FbBotDefinition>... faceBotDefinitions) {
		if (instance == null) {
			instance = new FbBotMillMockMediator();
		}
		FbBotMillMockMediator.mockEnabled = true;
		FbBotMillMockMediator.facebookMockId = facebookMockId;

		if (faceBotDefinitions != null) {
			for (Class<? extends FbBotDefinition> f : faceBotDefinitions) {
				FbBotDefinition definition = instantiateClass(f);
				definition.defineBehavior();
			}
		}
		return instance;
	}

	/**
	 * Utility method that instantiates a FaceBotDefinition class.
	 * 
	 * @param klass
	 *            the class to instantiate.
	 * @return a FaceBotDefinition.
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
	 * Sends a text message to all the registered FaceBots. Used to simulate a
	 * user typing in chat with your bot.
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
	 * Sends a payload to all the registered FaceBots. Used to simulate a user
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
	 * Forwards an envelope to the registered FaceBots.
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
	 * Starts an interactive test that simulates the behavior of the FaceBot
	 * according to the chat inputs. You can send messages to the registered
	 * FaceBot typing in your IDE console. To send a message, just type it. To
	 * send a payload, type {@value #PAYLOAD_MARKER} followed by your payload.
	 * To end the test, type {@value #STOP_MARKER}.
	 */
	public void interactiveTest() {
		// Prints instructions.
		System.out.println("Starting interactive test...");
		System.out
				.printf("Type your message or '%s<YOUR_PAYLOAD>' to send a message or a payload to the FaceBot. Type '%s' to stop the interactive test.\n",
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

}
