package co.aurasphere.facebot;

import static co.aurasphere.facebot.util.FaceBotConstants.HUB_CHALLENGE_PARAMETER;
import static co.aurasphere.facebot.util.FaceBotConstants.HUB_MODE_PARAMETER;
import static co.aurasphere.facebot.util.FaceBotConstants.HUB_MODE_SUBSCRIBE;
import static co.aurasphere.facebot.util.FaceBotConstants.HUB_VERIFY_TOKEN_PARAMETER;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.incoming.MessengerCallback;
import co.aurasphere.facebot.model.incoming.MessengerCallbackEntry;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.util.JsonUtils;
import co.aurasphere.facebot.util.StringUtils;

/**
 * Main Servlet for FaceBot framework. This servlet requires an init-param
 * containing the fully qualified name of a class implementing
 * {@link FaceBotDefinition} in which the initial configuration is done. If not
 * such class is found or can't be loaded, a ServletException is thrown during
 * initialization.
 * 
 * The FaceBotServlet supports GET requests only for the Subscribing phase and
 * POST requests for all the Facebook callbacks. For more information about how
 * the communication is handled, check the documentation for {@link #doGet},
 * {@link #doPost(HttpServletRequest, HttpServletResponse)} and Facebook's
 * documentation with the link below.
 * 
 * @see <a
 *      href="https://developers.facebook.com/docs/messenger-platform/quickstart">
 *      Facebook Subscription info</a>
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class FaceBotServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory
			.getLogger(FaceBotServlet.class);

	private static final long serialVersionUID = 1L;

	/**
	 * Initializes the FaceBotServlet. The initialization will try to load the
	 * class implementing {@link FaceBotDefinition} passed has an init-param in
	 * the web.xml. If the class is found and correctly loaded, the method
	 * {@link FaceBotDefinition#defineBehavior()} is called, otherwise a
	 * ServletException is thrown.
	 * 
	 * @throws ServletException
	 *             if the FaceBotDefinition class is not found in the servlet
	 *             init-param in web.xml or if can't be load.
	 */
	@Override
	public void init() throws ServletException {

		// Tries to get the botDefinitionClass name from the config defined in
		// web.xml.
		String botDefinitionClass = getServletConfig().getInitParameter(
				"bot-definition-class");
		if (botDefinitionClass == null || botDefinitionClass.isEmpty()) {
			logger.error("Bot definition class not found in web.xml. Make sure to add the fully qualified name of the a class implementing co.aurasphere.facebot.FaceBotDefinition as an init-param of the FaceBotServlet.");
			throw new ServletException(
					"Bot definition class not found in web.xml. Make sure to add the fully qualified name of the a class implementing co.aurasphere.facebot.FaceBotDefinition as an init-param of the FaceBotServlet.");
		}

		// Tries to load and instantiate the botDefinitionClass.
		FaceBotDefinition botDefinition = null;
		try {
			botDefinition = (FaceBotDefinition) this.getClass()
					.getClassLoader().loadClass(botDefinitionClass)
					.newInstance();
		} catch (ClassNotFoundException e) {
			logger.error("Error while loading FaceBot definition class [ "
					+ botDefinitionClass + " ]", e);
			throw new ServletException(
					"Error while loading FaceBot definition class [ "
							+ botDefinitionClass + " ]", e);
		} catch (ClassCastException e) {
			logger.error(
					"Class [ "
							+ botDefinitionClass
							+ " ] does not implement co.aurasphere.facebot.FaceBotDefinition",
					e);
			throw new ServletException(
					"Class [ "
							+ botDefinitionClass
							+ " ] does not implement co.aurasphere.facebot.FaceBotDefinition",
					e);
		} catch (Exception e) {
			logger.error("Error during instantiation of class [ "
					+ botDefinitionClass + " ]", e);
			throw new ServletException("Error during instantiation of class [ "
					+ botDefinitionClass + " ]", e);
		}

		// If everything is OK, calls the defineBehavior method of the
		// botDefinitionClass.
		botDefinition.defineBehavior();
		logger.info("FaceBotServlet configuration OK.");
	}

	/**
	 * Specifies how to handle a GET request. GET requests are used by Facebook
	 * only during the WebHook registration. During this phase, the
	 * FaceBotServlet checks that the
	 * {@link FaceBotConstants#HUB_MODE_PARAMETER} value received equals to
	 * {@link FaceBotConstants#HUB_MODE_SUBSCRIBE} and that the
	 * {@link FaceBotConstants#HUB_VERIFY_TOKEN_PARAMETER} value received equals
	 * to the {@link FaceBotContext#getValidationToken()}. If that's true, then
	 * the FaceBotServlet will reply sending back the value of the
	 * {@link FaceBotConstants#HUB_CHALLENGE_PARAMETER} received, in order to
	 * confirm the registration, otherwise it will return an error 403.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Retrieves GET parameters.
		String validationToken = FaceBotContext.getInstance()
				.getValidationToken();
		Map<String, String[]> parameters = req.getParameterMap();
		String hubMode = safeUnwrapGetParameters(parameters
				.get(HUB_MODE_PARAMETER));
		String hubToken = safeUnwrapGetParameters(parameters
				.get(HUB_VERIFY_TOKEN_PARAMETER));
		String hubChallenge = safeUnwrapGetParameters(parameters
				.get(HUB_CHALLENGE_PARAMETER));

		// Checks parameters and responds according to that.
		if (hubMode.equals(HUB_MODE_SUBSCRIBE)
				&& hubToken.equals(validationToken)) {
			logger.info("Subscription OK.");
			resp.setStatus(200);
			resp.setContentType("text/plain");
			resp.getWriter().write(hubChallenge);
		} else {
			logger.warn("GET received is not a subscription or wrong validation token. Ensure you have set the correct validation token using FaceBotContext.getContext().setValidationToken(String yourToken).");
			resp.sendError(403);
		}
	}

	/**
	 * Specifies how to handle a POST request. It parses the request as a
	 * {@link MessengerCallback} object. If the request is not a
	 * MessengerCallback, then the FaceBotServlet logs an error and does
	 * nothing, otherwise it will forward the request to all registered FaceBots
	 * in order to let them process the callbacks.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.trace("POST received!");
		MessengerCallback callback = null;

		// Extrapolates and logs the JSON for debugging.
		String json = StringUtils.readerToString(req.getReader());
		logger.debug("JSON input: " + json);

		// Parses the request as a MessengerCallback.
		try {
			callback = JsonUtils.getGson().fromJson(json,
					MessengerCallback.class);
		} catch (Exception e) {
			logger.error("Error during MessengerCallback parsing: ", e);
			return;
		}

		// If the received POST is a MessengerCallback, it forwards the last
		// envelope of all the callbacks received to the registered FaceBots.
		List<MessengerCallbackEntry> callbackEntries = callback.getEntry();
		if (callbackEntries != null) {
			for (MessengerCallbackEntry entry : callbackEntries) {
				List<MessageEnvelope> envelopes = entry.getMessaging();
				if (envelopes != null) {
					MessageEnvelope lastEnvelope = envelopes.get(envelopes
							.size() - 1);
					for (FaceBot bot : FaceBotContext.getInstance()
							.getRegisteredBots()) {
						bot.processMessage(lastEnvelope);
					}
				}
			}
		}
	}

	/**
	 * Method which returns the first String in a String array if present or the
	 * empty String otherwise. Used to unwrap the GET arguments from an
	 * {@link HttpServletRequest#getParameterMap()} which returns a String array
	 * for each GET parameter.
	 * 
	 * @param parameter
	 *            the String array to unwrap.
	 * @return the first String of the array if found or the empty String
	 *         otherwise.
	 */
	private static String safeUnwrapGetParameters(String[] parameter) {
		if (parameter == null || parameter[0] == null) {
			return "";
		}
		return parameter[0];
	}

}