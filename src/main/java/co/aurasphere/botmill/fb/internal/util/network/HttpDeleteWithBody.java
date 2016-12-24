package co.aurasphere.botmill.fb.internal.util.network;

import org.apache.http.client.methods.HttpPost;

/**
 * Utility class used to represent a DELETE request with a body (like a POST
 * does).
 * 
 * @author Donato Rimenti
 * @date Dec 18, 2016
 */
public class HttpDeleteWithBody extends HttpPost {

	/**
	 * Instantiates a new http delete with body.
	 *
	 * @see HttpPost#HttpPost(String)
	 * @param url
	 *            the url which will receive the request.
	 */
	public HttpDeleteWithBody(String url) {
		super(url);
	}

	/**
	 * {@inheritDoc} Returns "DELETE".
	 */
	@Override
	public String getMethod() {
		return "DELETE";
	}

}
