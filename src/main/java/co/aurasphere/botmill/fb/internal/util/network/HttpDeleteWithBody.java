package co.aurasphere.botmill.fb.internal.util.network;

import org.apache.http.client.methods.HttpPost;


/**
 * Utility class used to represent a DELETE request with a body (like a POST
 * does).
 * 
 * @author Donato Rimenti
 * 
 */
public class HttpDeleteWithBody extends HttpPost {

	/**
	 * Instantiates a new http delete with body.
	 *
	 * @param url            the url which will receive the request.
	 * @see HttpPost#HttpPost(String)
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
