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
package co.aurasphere.botmill.fb.userprofile;

import co.aurasphere.botmill.fb.internal.util.network.NetworkUtils;
import co.aurasphere.botmill.fb.model.userprofile.FacebookUserProfile;

/**
 * Class for handling the retrieval of Facebook user info.
 * 
 * @author Donato Rimenti
 */
public class FbBotMillUserProfileRetriever {

	/**
	 * Instantiates a new FbBotMillUserProfileRetriever.
	 */
	private FbBotMillUserProfileRetriever() {
	}

	/**
	 * Retrieves a {@link FacebookUserProfile} object containing the info for
	 * the user with the ID passed.
	 * 
	 * @param userId
	 *            the id of the user whose profile to retrieve.
	 * @return the user profile.
	 */
	public static FacebookUserProfile getUser(String userId) {
		return NetworkUtils.getUserProfile(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillUserProfileRetriever []";
	}

}
