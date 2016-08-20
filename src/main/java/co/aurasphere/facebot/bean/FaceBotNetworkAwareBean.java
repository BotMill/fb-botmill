package co.aurasphere.facebot.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.util.HttpDeleteWithBody;
import co.aurasphere.facebot.util.JsonUtils;
import co.aurasphere.facebot.util.StringUtils;

/**
 * Class that represents a FaceBot bean which can communicate through the
 * network.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class FaceBotNetworkAwareBean extends FaceBotBean {

	private static final Logger logger = LoggerFactory
			.getLogger(FaceBotNetworkAwareBean.class);

	/**
	 * POSTs a message as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	protected static void postMessage(StringEntity input) {
		HttpPost post = new HttpPost(FaceBotConstants.FACEBOOK_BASE_URL
				+ FaceBotConstants.FACEBOOK_MESSAGES_URL
				+ FaceBotContext.getInstance().getPageToken());
		post.setEntity(input);
		post(post);
	}

	/**
	 * POSTs a thread setting as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	protected static void postThreadSetting(StringEntity input) {
		HttpPost post = new HttpPost(FaceBotConstants.FACEBOOK_BASE_URL
				+ FaceBotConstants.FACEBOOK_THREAD_SETTINGS_URL
				+ FaceBotContext.getInstance().getPageToken());
		post.setEntity(input);
		post(post);
	}

	private static void post(HttpPost post) {
		logger.trace("POST to Facebook...");
		logger.debug(post.getRequestLine().toString());
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpResponse response = httpClient.execute(post);
			// TODO : better handling, model server response.
			// If an error happens, it logs the server response.
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 400) {
				logger.error("POST failed with HTTP error code {}.", response
						.getStatusLine().getStatusCode());
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));
				String output;
				while ((output = br.readLine()) != null) {
					logger.error(output);
				}
			}
		} catch (Exception e) {
			logger.error("Error during HTTP POST to Facebook: ", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("Error while closing HTTP connection: ", e);
			}
		}

	}

	/**
	 * DELETEs a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	protected static void delete(StringEntity input) {
		logger.trace("DELETE to Facebook...");
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpDeleteWithBody delete = new HttpDeleteWithBody(
				FaceBotConstants.FACEBOOK_BASE_URL
						+ FaceBotConstants.FACEBOOK_THREAD_SETTINGS_URL
						+ FaceBotContext.getInstance().getPageToken());
		delete.setEntity(input);
		logger.debug(delete.getRequestLine().toString());
		try {
			HttpResponse response = httpClient.execute(delete);
			// TODO : better handling, model server response.
			// If an error happens, it logs the server response.
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 400) {
				logger.error("DELETE failed with HTTP error code {}.", response
						.getStatusLine().getStatusCode());
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(response.getEntity().getContent())));
				String output;
				while ((output = br.readLine()) != null) {
					logger.error(output);
				}
			}
		} catch (Exception e) {
			logger.error("Error during HTTP DELETE to Facebook: ", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("Error while closing HTTP connection: ", e);
			}
		}
	}

	/**
	 * Utility method that converts an object to its JSON representation.
	 * 
	 * @param object
	 *            the object to convert to JSON.
	 * @return a StringEntity object containing the object JSON.
	 */
	protected static StringEntity toJson(Object object) {
		logger.trace("Starting Json conversion...");
		StringEntity input = null;
		try {
			input = new StringEntity((JsonUtils.getGson().toJson(object)));
			input.setContentType("application/json");
			logger.debug("Request: {}",
					StringUtils.inputStreamToString(input.getContent()));
		} catch (Exception e) {
			logger.error("Error during JSON message creation: ", e);
		}
		return input;
	}

}
