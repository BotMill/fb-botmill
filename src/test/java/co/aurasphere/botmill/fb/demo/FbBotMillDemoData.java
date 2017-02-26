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
package co.aurasphere.botmill.fb.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.aurasphere.botmill.fb.exception.FbBotMillMissingConfigurationException;
import co.aurasphere.botmill.fb.internal.util.properties.PropertiesUtil;

/**
 * Put your data here to test the FBotMill Framework framework.
 * 
 * @author Alvin P. Reyes
 */
public class FbBotMillDemoData {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(FbBotMillDemoData.class);
	
	/** The Constant FB_BOTMILL_PROPERTIES_FILENAME. */
	//	Properties.
	private static final String FB_BOTMILL_PROPERTIES_FILENAME = "botmill.properties";
	
	/** The Constant FB_BOTMILL_MOCK_ID_PROP. */
	private static final String FB_BOTMILL_MOCK_ID_PROP = "fb.mock.id";
	
	/** The Constant FB_BOTMILL_PAGE_TOKEN_PROP. */
	private static final String FB_BOTMILL_PAGE_TOKEN_PROP = "fb.page.token";
	
	/** The Constant FB_BOTMILL_VALIDATION_TOKEN_PROP. */
	private static final String FB_BOTMILL_VALIDATION_TOKEN_PROP = "fb.validation.token";
	
	/** The Constant FB_BOTMILL_MOCK_ID_PROP_PHOLDER. */
	//	Property placeholder
	private static final String FB_BOTMILL_MOCK_ID_PROP_PHOLDER = "<MOCK_FACEBOOK_ID>";
	
	/** The Constant FB_BOTMILL_PAGE_TOKEN_PROP_PHOLDER. */
	private static final String FB_BOTMILL_PAGE_TOKEN_PROP_PHOLDER = "<PAGE_TOKEN>";
	
	/** The Constant FB_BOTMILL_VALIDATION_TOKEN_PROP_PHOLDER. */
	private static final String FB_BOTMILL_VALIDATION_TOKEN_PROP_PHOLDER = "<VALIDATION_TOKEN>";
	
	/** The Constant FB_BOTMILL_MOCK_ID_PROPERTY. */
	//	Environment variable
	private static final String FB_BOTMILL_MOCK_ID_PROPERTY = "MOCK_FACEBOOK_ID";
	
	/** The Constant FB_BOTMILL_PAGE_TOKEN_PROPERTY. */
	private static final String FB_BOTMILL_PAGE_TOKEN_PROPERTY = "PAGE_TOKEN";
	
	/** The Constant FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY. */
	private static final String FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY = "VALIDATION_TOKEN";

	/**
	 *  The method getFacebookMockId.
	 *
	 * @return the facebook mock id
	 */
	// 	Please check our wiki https://github.com/BotMill/fb-botmill/wiki/Unit-Testing 
	//	on how to get the mock_facebook_id
	public static String getFacebookMockId() {
		try {
			String mockId = PropertiesUtil.load(FB_BOTMILL_PROPERTIES_FILENAME).getProperty(FB_BOTMILL_MOCK_ID_PROP);
			logger.info(mockId);
			if(mockId.equals("") || mockId.contains(FB_BOTMILL_MOCK_ID_PROP_PHOLDER)) {
				return System.getProperty(FB_BOTMILL_MOCK_ID_PROPERTY);
			}
			return mockId;
		} catch (FbBotMillMissingConfigurationException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Gets the fb page token.
	 *
	 * @return the fb page token
	 */
	public static String getFbPageToken() {
		try {
			String pageToken = PropertiesUtil.load(FB_BOTMILL_PROPERTIES_FILENAME).getProperty(FB_BOTMILL_PAGE_TOKEN_PROP);
			logger.info(pageToken);
			if(pageToken.equals("") || pageToken.contains(FB_BOTMILL_PAGE_TOKEN_PROP_PHOLDER)) {
				return System.getProperty(FB_BOTMILL_PAGE_TOKEN_PROPERTY);
			}
			return pageToken;
		} catch (FbBotMillMissingConfigurationException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Gets the fb validation token.
	 *
	 * @return the fb validation token
	 */
	public static String getFbValidationToken() {
		try {
			String validationToken = PropertiesUtil.load(FB_BOTMILL_PROPERTIES_FILENAME).getProperty(FB_BOTMILL_VALIDATION_TOKEN_PROP);
			logger.info(validationToken);
			if(validationToken.equals("") || validationToken.contains(FB_BOTMILL_VALIDATION_TOKEN_PROP_PHOLDER)) {
				return System.getProperty(FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY);
			}
			return validationToken;
		} catch (FbBotMillMissingConfigurationException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
