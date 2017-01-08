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
	 * @param url
	 *            the url which will receive the request.
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.http.client.methods.HttpRequestBase#toString()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "HttpDeleteWithBody [headergroup=" + headergroup + ", params="
				+ params + "]";
	}

}
