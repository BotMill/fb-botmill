package co.aurasphere.facebot.bean;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.FacebookError;
import co.aurasphere.facebot.model.incoming.FacebookErrorMessage;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.userprofile.FacebookUserProfile;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.util.HttpDeleteWithBody;
import co.aurasphere.facebot.util.JsonUtils;
import co.aurasphere.facebot.util.StringUtils;

/**
 * Class that represents a FaceBot bean which can communicate through the
 * network.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class FaceBotNetworkAwareBean extends FaceBotBean {

	private static final Logger logger = LoggerFactory
			.getLogger(FaceBotNetworkAwareBean.class);
	
	protected static FacebookUserProfile getUserProfile(String userId){
		String pageToken = FaceBotContext.getInstance().getPageToken();
		HttpGet get = new HttpGet(FaceBotConstants.FACEBOOK_BASE_URL + userId + FaceBotConstants.USER_PROFILE_FIELDS + pageToken);
		String response = send(get);
		FacebookUserProfile user = JsonUtils.getGson().fromJson(response, FacebookUserProfile.class);
		return user;
	} 

	/**
	 * POSTs a message as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	protected static void postJsonMessage(StringEntity input) {
		String pageToken = FaceBotContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		HttpPost post = new HttpPost(FaceBotConstants.FACEBOOK_BASE_URL
				+ FaceBotConstants.FACEBOOK_MESSAGES_URL + pageToken);
		post.setEntity(input);
		send(post);
	}

	/**
	 * POSTs a thread setting as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	protected static void postThreadSetting(StringEntity input) {
		String pageToken = FaceBotContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		HttpPost post = new HttpPost(FaceBotConstants.FACEBOOK_BASE_URL
				+ FaceBotConstants.FACEBOOK_THREAD_SETTINGS_URL + pageToken);
		post.setEntity(input);
		send(post);
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
	 * @throws IOException
	 */
	private static String logResponse(HttpResponse response) throws IOException {
		int statusCode = response.getStatusLine().getStatusCode();

		// Logs the raw JSON for debug purposes.
		String output = getResponseContent(response);
		logger.debug("HTTP Status Code: {}", statusCode);
		logger.debug("Response: {}", output);

		if (statusCode >= 400) {
			logger.error("HTTP connection failed with error code {}.", statusCode);

			// Parses the error message and logs it.
			FacebookErrorMessage errorMessage = JsonUtils.getGson().fromJson(
					output, FacebookErrorMessage.class);
			FacebookError error = errorMessage.getError();
			logger.error(
					"Error message from Facebook. Message: [{}], Code: [{}], Type: [{}], FbTraceID: [{}].",
					error.getMessage(), error.getCode(), error.getType(),
					error.getFbTraceId());
		}
		return output;
	}
	
	private static String getResponseContent(HttpResponse response) throws IOException{
		InputStream inputStream = response.getEntity().getContent();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//		bufferedInputStream.mark(1000000);
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		br.mark(Short.MAX_VALUE);
		String output = br.readLine();
		br.reset();
//		bufferedInputStream.reset();
		return output;
	}
	
	/**
	 * DELETEs a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	protected static void delete(StringEntity input) {
		String pageToken = FaceBotContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		HttpDeleteWithBody delete = new HttpDeleteWithBody(
				FaceBotConstants.FACEBOOK_BASE_URL
						+ FaceBotConstants.FACEBOOK_THREAD_SETTINGS_URL
						+ pageToken);
		delete.setEntity(input);
		send(delete);
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
			logger.error("FaceBot validation error: Page token can't be null or empty! Have you called the method FaceBotContext.getInstance().setup(String, String)?");
			return false;
		}
		return true;
	}

	/**
	 * Utility method that converts an object to its JSON representation.
	 * 
	 * @param object
	 *            the object to convert to JSON.
	 * @return a StringEntity object containing the object JSON.
	 */
	protected static StringEntity toJson(Object object) {
		StringEntity input = null;
		try {
			input = new StringEntity(JsonUtils.getGson().toJson(object));
			input.setContentType("application/json");
			logger.debug("Request: {}",
					StringUtils.inputStreamToString(input.getContent()));
		} catch (Exception e) {
			logger.error("Error during JSON message creation: ", e);
		}
		return input;
	}

	/**
	 * Validates the {@link FaceBotResponse} before sending it.
	 * 
	 * @return true if the response is valid, false otherwise.
	 */
	protected boolean validate(FaceBotResponse response) {
		// If validations are not enabled, returns true.
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return true;
		}

		boolean valid = true;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<FaceBotResponse>> violations = validator
				.validate(response);
		for (ConstraintViolation<FaceBotResponse> v : violations) {
			valid = false;
			logger.error(
					"FaceBotResponse validation error. Message: [{}] Value: [{}], Class: [{}], Field: [{}]",
					v.getMessage(), v.getInvalidValue(), v.getRootBean(),
					v.getPropertyPath());
		}
		return valid;
	}

	/**
	 * POSTs a message as a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void postFormDataMessage(String recipient,
			AttachmentType type, File file) {
		String pageToken = FaceBotContext.getInstance().getPageToken();
		// If the page token is invalid, returns.
		if (!validatePageToken(pageToken)) {
			return;
		}

		// TODO: add checks for valid attachmentTypes (FILE, AUDIO or VIDEO)
		HttpPost post = new HttpPost(FaceBotConstants.FACEBOOK_BASE_URL
				+ FaceBotConstants.FACEBOOK_MESSAGES_URL + pageToken);

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
//		builder.addPart("filedata", filedata);
		builder.addBinaryBody("filedata", file);
		builder.setContentType(ContentType.MULTIPART_FORM_DATA);

//		builder.setBoundary("----WebKitFormBoundary7MA4YWxkTrZu0gW");
		HttpEntity entity = builder.build();
		post.setEntity(entity);

		// Logs the raw JSON for debug purposes.
		BufferedReader br;
//		post.addHeader("Content-Type", "multipart/form-data");
		try {
//			br = new BufferedReader(new InputStreamReader(
//					())));
		
			Header[] allHeaders = post.getAllHeaders();
			for(Header h : allHeaders){
				
				logger.debug("Header {} ->  {}", h.getName(), h.getValue());
			}
//		String output = br.readLine();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		send(post);
	}

}
