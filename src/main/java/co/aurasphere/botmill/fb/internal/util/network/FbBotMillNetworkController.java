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
package co.aurasphere.botmill.fb.internal.util.network;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.core.internal.util.network.BotMillNetworkResponse;
import co.aurasphere.botmill.core.internal.util.network.NetworkUtils;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.internal.util.json.FbBotMillJsonUtils;
import co.aurasphere.botmill.fb.model.api.messaginginsight.DailyUniqueActiveThreadCounts;
import co.aurasphere.botmill.fb.model.api.messaginginsight.DailyUniqueConversationCounts;
import co.aurasphere.botmill.fb.model.api.messengercode.MessengerCode;
import co.aurasphere.botmill.fb.model.api.upload.UploadAttachmentResponse;
import co.aurasphere.botmill.fb.model.api.userprofile.FacebookUserProfile;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.FacebookConfirmationMessage;
import co.aurasphere.botmill.fb.model.incoming.FacebookError;
import co.aurasphere.botmill.fb.model.incoming.FacebookErrorMessage;
import co.aurasphere.botmill.fb.support.FbBotMillMonitor;

/**
 * Class that contains methods that allows FbBotMill to communicate through the
 * network.
 * 
 * @author Donato Rimenti
 * @author Alvin Reyes
 */
public class FbBotMillNetworkController {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(FbBotMillNetworkController.class);

	/**
	 * The registered monitors to the {@link FbBotMillContext}.
	 */
	private static final List<FbBotMillMonitor> registeredMonitors = FbBotMillContext
			.getInstance().getRegisteredMonitors();

	/**
	 * Method used to retrieve a {@link FacebookUserProfile} from an ID using
	 * the GET method.
	 * 
	 * @param userId
	 *            the ID of the user to retrieve.
	 * @return the user profile info.
	 */
	public static FacebookUserProfile getUserProfile(String userId) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		BotMillNetworkResponse response = NetworkUtils
				.get(FbBotMillNetworkConstants.FACEBOOK_BASE_URL + userId
						+ FbBotMillNetworkConstants.USER_PROFILE_FIELDS
						+ pageToken);
		FacebookUserProfile user = FbBotMillJsonUtils.fromJson(
				response.getResponse(), FacebookUserProfile.class);
		return user;
	}

	/**
	 * GETs the daily unique active thread counts.
	 * 
	 * @return the daily unique active thread counts.
	 */
	public static DailyUniqueActiveThreadCounts getDailyUniqueActiveThreadCounts() {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		BotMillNetworkResponse response = NetworkUtils
				.get(FbBotMillNetworkConstants.FACEBOOK_BASE_URL
						+ FbBotMillNetworkConstants.FACEBOOK_MESSAGING_INSIGHT_ACTIVE_THREADS_URL
						+ pageToken);
		return FbBotMillJsonUtils.fromJson(response.getResponse(),
				DailyUniqueActiveThreadCounts.class);
	}

	/**
	 * GETs the daily unique conversation counts.
	 * 
	 * @return the daily unique conversation counts.
	 */
	public static DailyUniqueConversationCounts getDailyUniqueConversationCounts() {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		BotMillNetworkResponse response = NetworkUtils
				.get(FbBotMillNetworkConstants.FACEBOOK_BASE_URL
						+ FbBotMillNetworkConstants.FACEBOOK_MESSAGING_INSIGHT_CONVERSATION_URL
						+ pageToken);
		return FbBotMillJsonUtils.fromJson(response.getResponse(),
				DailyUniqueConversationCounts.class);
	}

	/**
	 * POSTs a message as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void postJsonMessage(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_MESSAGES_URL + pageToken;
		postInternal(url, input);
	}

	/**
	 * POSTs a message as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void postJsonMessage(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		postJsonMessage(stringEntity);
	}

	/**
	 * POSTs a thread setting as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void postThreadSetting(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_THREAD_SETTINGS_URL
				+ pageToken;
		postInternal(url, input);
	}

	/**
	 * Post messenger profile.
	 *
	 * @param input
	 *            the input
	 */
	public static void postMessengerProfile(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_MESSENGER_PROFILE
				+ pageToken;
		postInternal(url, input);
	}

	/**
	 * POSTs a thread setting as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void postThreadSetting(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		postThreadSetting(stringEntity);
	}

	/**
	 * POSTs a messenger profile as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void postMessengerProfile(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		postMessengerProfile(stringEntity);
	}

	/**
	 * POSTs an attachment as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 * @return the uploaded attachment ID.
	 */
	public static UploadAttachmentResponse postUploadAttachment(
			StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return null;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_UPLOAD_API_URL + pageToken;
		BotMillNetworkResponse response = postInternal(url, input);

		// Parses the response as a UploadAttachmentResponse and returns it.
		return FbBotMillJsonUtils.fromJson(response.getResponse(),
				UploadAttachmentResponse.class);
	}

	/**
	 * POSTs an attachment as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 * @return the uploaded attachment ID.
	 */
	public static UploadAttachmentResponse postUploadAttachment(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		return postUploadAttachment(stringEntity);
	}

	/**
	 * POSTs a messenger code as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 * @return the requested messenger code.
	 */
	public static MessengerCode postMessengerCode(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return null;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_MESSENGER_CODE_API_URL
				+ pageToken;
		BotMillNetworkResponse response = postInternal(url, input);

		// Parses the response as a MessengerCode and returns it.
		return FbBotMillJsonUtils.fromJson(response.getResponse(),
				MessengerCode.class);
	}

	/**
	 * POSTs a messenger code as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 * @return the uploaded attachment ID.
	 */
	public static MessengerCode postMessengerCode(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		return postMessengerCode(stringEntity);
	}

	/**
	 * Performs a POST and propagates it to the registered monitors.
	 * 
	 * @param url
	 *            the URL where to post.
	 * @param input
	 *            the object to send.
	 * @return the response.
	 */
	private static BotMillNetworkResponse postInternal(String url,
			StringEntity input) {
		BotMillNetworkResponse response = NetworkUtils.post(url, input);
		propagateResponse(response);
		return response;
	}

	/**
	 * Propagates the response to the registered {@link FbBotMillMonitor}.
	 *
	 * @param response
	 *            the response to propagate.
	 */
	private static void propagateResponse(BotMillNetworkResponse response) {

		String output = response.getResponse();
		if (response.isError()) {

			// Parses the error message and logs it.
			FacebookErrorMessage errorMessage = FbBotMillJsonUtils.fromJson(
					output, FacebookErrorMessage.class);
			FacebookError error = errorMessage.getError();
			logger.error(
					"Error message from Facebook. Message: [{}], Code: [{}], Type: [{}], FbTraceID: [{}].",
					error.getMessage(), error.getCode(), error.getType(),
					error.getFbTraceId());

			// Sends the callback to the registered network monitors.
			for (FbBotMillMonitor monitor : registeredMonitors) {
				monitor.onError(errorMessage);
			}
		} else {
			FacebookConfirmationMessage confirmationMessage = FbBotMillJsonUtils
					.fromJson(output, FacebookConfirmationMessage.class);
			logger.debug(
					"Confirmation from Facebook. Recipient ID: [{}], Message ID: [{}], Result Message: [{}]",
					confirmationMessage.getRecipientId(),
					confirmationMessage.getMessageId(),
					confirmationMessage.getResult());

			// Sends the callback to the registered network monitors.
			for (FbBotMillMonitor monitor : registeredMonitors) {
				monitor.onConfirmation(confirmationMessage);
			}
		}
	}

	/**
	 * DELETEs a JSON string as a Facebook's Thread Setting.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void deleteThreadSetting(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_THREAD_SETTINGS_URL
				+ pageToken;
		BotMillNetworkResponse response = NetworkUtils.delete(url, input);
		propagateResponse(response);
	}

	/**
	 * DELETEs a JSON string as a Facebook's Thread Setting.
	 * 
	 * @param input
	 *            the data to send.
	 */
	public static void deleteThreadSetting(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		deleteThreadSetting(stringEntity);
	}

	/**
	 * DELETEs a JSON string as a Facebook's Messenger Profile.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void deleteMessengerProfile(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		String url = FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ FbBotMillNetworkConstants.FACEBOOK_MESSENGER_PROFILE
				+ pageToken;
		BotMillNetworkResponse response = NetworkUtils.delete(url, input);
		propagateResponse(response);
	}

	/**
	 * DELETEs a JSON string as a Facebook's Messenger Profile.
	 * 
	 * @param input
	 *            the data to send.
	 */
	public static void deleteMessengerProfile(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		deleteMessengerProfile(stringEntity);
	}

	/**
	 * Validates a Facebook Page Token.
	 * 
	 * @param pageToken
	 *            the token to validate.
	 * @return true if the token is not null or empty, false otherwise.
	 */
	private static boolean validatePageToken(String pageToken) {
		if (pageToken == null || "".equals(pageToken)) {
			logger.error("FbBotMill validation error: Page token can't be null or empty! Have you called the method FbBotMillContext.getInstance().setup(String, String)?");
			return false;
		}
		return true;
	}

	/**
	 * Utility method that converts an object to its StringEntity
	 * representation.
	 * 
	 * @param object
	 *            the object to convert to a StringEntity.
	 * @return a {@link StringEntity} object containing the object JSON.
	 */
	private static StringEntity toStringEntity(Object object) {
		StringEntity input = null;
		try {
			String json = FbBotMillJsonUtils.toJson(object);
			input = new StringEntity(json, "UTF-8");
			input.setContentType("application/json");
			logger.debug("Request: {}", inputStreamToString(input.getContent()));
		} catch (Exception e) {
			logger.error("Error during JSON message creation: ", e);
		}
		return input;
	}

	/**
	 * Utility method which converts an InputStream to a String.
	 *
	 * @param stream
	 *            the InputStream to convert.
	 * @return a String with the InputStream content.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String inputStreamToString(InputStream stream)
			throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		String resultString = null;
		while ((length = stream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		resultString = result.toString("UTF-8");
		return resultString;
	}

	// TODO: used for attaching files but not working at the moment.
	/**
	 * POSTs a message as a JSON string to Facebook.
	 *
	 * @param recipient
	 *            the recipient
	 * @param type
	 *            the type
	 * @param file
	 *            the file
	 */
	public static void postFormDataMessage(String recipient,
			AttachmentType type, File file) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		// TODO: add checks for valid attachmentTypes (FILE, AUDIO or VIDEO)
		HttpPost post = new HttpPost(
				FbBotMillNetworkConstants.FACEBOOK_BASE_URL
						+ FbBotMillNetworkConstants.FACEBOOK_MESSAGES_URL
						+ pageToken);

		FileBody filedata = new FileBody(file);
		StringBody recipientPart = new StringBody("{\"id\":\"" + recipient
				+ "\"}", ContentType.MULTIPART_FORM_DATA);
		StringBody messagePart = new StringBody("{\"attachment\":{\"type\":\""
				+ type.name().toLowerCase() + "\", \"payload\":{}}}",
				ContentType.MULTIPART_FORM_DATA);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.STRICT);
		builder.addPart("recipient", recipientPart);
		builder.addPart("message", messagePart);
		// builder.addPart("filedata", filedata);
		builder.addBinaryBody("filedata", file);
		builder.setContentType(ContentType.MULTIPART_FORM_DATA);

		// builder.setBoundary("----WebKitFormBoundary7MA4YWxkTrZu0gW");
		HttpEntity entity = builder.build();
		post.setEntity(entity);

		// Logs the raw JSON for debug purposes.
		BufferedReader br;
		// post.addHeader("Content-Type", "multipart/form-data");
		try {
			// br = new BufferedReader(new InputStreamReader(
			// ())));

			Header[] allHeaders = post.getAllHeaders();
			for (Header h : allHeaders) {

				logger.debug("Header {} ->  {}", h.getName(), h.getValue());
			}
			// String output = br.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// postInternal(post);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillNetworkController []";
	}

}
