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
package co.aurasphere.botmill.fb.test.incoming.callback;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import co.aurasphere.botmill.fb.internal.util.json.JsonUtils;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.MessengerCallback;
import co.aurasphere.botmill.fb.model.incoming.callback.EchoMessage;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ListTemplatePayload;

/**
 * Test for an {@link EchoMessage} parsing.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class EchoCallbackTest extends BaseFbBotMillCallbackTest {

	/**
	 * Tests an {@link EchoMessage} containing a {@link ListTemplatePayload}.
	 */
	@Test
	public void testEchoWithListTemplate() {
		// Tests the echo with a List Template.
		String echoListTemplatejson = "{\"object\":\"page\",\"entry\":[{\"id\":\"1423903854504468\",\"time\":1483578465379,\"messaging\":[{\"sender\":{\"id\":\"****\"},\"recipient\":{\"id\":\"****\"},\"timestamp\":1483578464765,\"message\":{\"is_echo\":true,\"app_id\":****,\"mid\":\"mid.1483578464765:ed1fe23f35\",\"seq\":785209,\"attachments\":[{\"title\":\"Title2, Title1, Title3, Title4\",\"url\":\"https://www.facebook.com/commerce/update/\",\"type\":\"template\",\"payload\":{\"template_type\":\"list\",\"sharable\":false,\"elements\":[{\"title\":\"Title2\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}},{\"title\":\"Title1\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"https://lh4.ggpht.com/mJDgTDUOtIyHcrb69WM0cpaxFwCNW6f0VQ2ExA7dMKpMDrZ0A6ta64OCX3H-NMdRd20=w300\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}},{\"title\":\"Title3\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}},{\"title\":\"Title4\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}}],\"buttons\":[{\"type\":\"postback\",\"title\":\"Just Sample\",\"payload\":\"Yes\"}]}}]}}]}]}";
		MessengerCallback callback = JsonUtils.fromJson(echoListTemplatejson,
				MessengerCallback.class);

		MessageEnvelope messageEnvelope = checkCallbackWellFormed(callback);

		Assert.assertNotNull(messageEnvelope.getMessage());
		Assert.assertThat(messageEnvelope.getMessage(),
				IsInstanceOf.instanceOf(EchoMessage.class));

		EchoMessage echoMessage = (EchoMessage) messageEnvelope.getMessage();
		// TODO: check individual fields.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.test.incoming.callback.BaseFbBotMillCallbackTest
	 * #toString()
	 */
	@Override
	public String toString() {
		return "EchoCallbackTest []";
	}

}
