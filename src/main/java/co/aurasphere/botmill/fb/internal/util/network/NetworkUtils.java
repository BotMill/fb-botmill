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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.internal.util.json.JsonUtils;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.FacebookConfirmationMessage;
import co.aurasphere.botmill.fb.model.incoming.FacebookError;
import co.aurasphere.botmill.fb.model.incoming.FacebookErrorMessage;
import co.aurasphere.botmill.fb.model.userprofile.FacebookUserProfile;
import co.aurasphere.botmill.fb.support.FbBotMillMonitor;

/**
 * Class that contains methods that allows FbBotMill to communicate through the
 * network.
 * 
 * @author Donato Rimenti
 * 
 */
public class NetworkUtils {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(NetworkUtils.class);

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
		HttpGet get = new HttpGet(FbBotMillNetworkConstants.FACEBOOK_BASE_URL
				+ userId + FbBotMillNetworkConstants.USER_PROFILE_FIELDS
				+ pageToken);
		String response = send(get);
		FacebookUserProfile user = JsonUtils.fromJson(response,
				FacebookUserProfile.class);
		return user;
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

		HttpPost post = new HttpPost(
				FbBotMillNetworkConstants.FACEBOOK_BASE_URL
						+ FbBotMillNetworkConstants.FACEBOOK_MESSAGES_URL
						+ pageToken);
		post.setEntity(input);
		send(post);
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

		HttpPost post = new HttpPost(
				FbBotMillNetworkConstants.FACEBOOK_BASE_URL
						+ FbBotMillNetworkConstants.FACEBOOK_THREAD_SETTINGS_URL
						+ pageToken);
		post.setEntity(input);
		send(post);
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
	 * Sends a request.
	 * 
	 * @param request
	 *            the request to send
	 * @return response the response.
	 */
	private static String send(HttpRequestBase request) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		logger.debug(request.getRequestLine().toString());
		HttpResponse httpResponse = null;
		String response = null;
		try {
			httpResponse = httpClient.execute(request);
			response = logResponse(httpResponse);
		} catch (Exception e) {
			logger.error("Error during HTTP connection to Facebook: ", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("Error while closing HTTP connection: ", e);
			}
		}
		return response;
	}

	/**
	 * Logs the response before returning it.
	 *
	 * @param response
	 *            the response to log.
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String logResponse(HttpResponse response) throws IOException {
		int statusCode = response.getStatusLine().getStatusCode();

		// Logs the raw JSON for debug purposes.
		String output = getResponseContent(response);
		logger.debug("HTTP Status Code: {}", statusCode);
		logger.trace("Raw response: {}", output);

		// If the status code is > 400 there was an error.
		if (statusCode >= 400) {
			logger.error("HTTP connection failed with error code {}.",
					statusCode);

			// Parses the error message and logs it.
			FacebookErrorMessage errorMessage = JsonUtils.fromJson(output,
					FacebookErrorMessage.class);
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
			FacebookConfirmationMessage confirmationMessage = JsonUtils
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
		return output;
	}

	/**
	 * Utility method that converts an HttpResponse to a String.
	 *
	 * @param response
	 *            the response to convert.
	 * @return a String with the response content.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String getResponseContent(HttpResponse response)
			throws IOException {
		InputStream inputStream = response.getEntity().getContent();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				inputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(
				bufferedInputStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		StringBuilder builder = new StringBuilder();
		String output = null;
		while ((output = br.readLine()) != null) {
			builder.append(output);
		}
		return builder.toString();
	}

	/**
	 * DELETEs a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void delete(StringEntity input) {
		String pageToken = FbBotMillContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		HttpDeleteWithBody delete = new HttpDeleteWithBody(
				FbBotMillNetworkConstants.FACEBOOK_BASE_URL
						+ FbBotMillNetworkConstants.FACEBOOK_THREAD_SETTINGS_URL
						+ pageToken);
		delete.setEntity(input);
		send(delete);
	}

	/**
	 * DELETEs a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void delete(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		delete(stringEntity);
	}

	/**
	 * Validates a Facebook Page Token.
	 * 
	 * @param pageToken
	 *            the token to validate.
	 * @return true if the token is not null or empty, false otherwise.
	 */
	private static boolean validatePageToken(String pageToken) {
		if (pageToken == null || pageToken.isEmpty()) {
			logger.error("FbBotMill validation error: Page token can't be null or empty! Have you called the method FbBotMillContext.getInstance().setup(String, String)?");
			return false;
		}
		return true;
	}

	/**
	 * Utility to send a POST request.
	 * 
	 * @param url
	 *            the url we need to send the post request to.
	 * @param entity
	 *            the entity that containts the object we need to pass as part
	 *            of the post request.
	 * @return {@link String}
	 */
	public static String post(String url, StringEntity entity) {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setEntity(entity);
		return send(post);
	}

	/**
	 * Utility to send a GET request.
	 * 
	 * @param url
	 *            the url we need to send the get request to.
	 * @return {@link String}
	 */
	public static String get(String url) {
		System.out.println(url);
		HttpGet get = new HttpGet(url);
		return send(get);
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
			String json = JsonUtils.toJson(object);
			input = new StringEntity(json, StandardCharsets.UTF_8);
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

		send(post);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetworkUtils []";
	}

}
