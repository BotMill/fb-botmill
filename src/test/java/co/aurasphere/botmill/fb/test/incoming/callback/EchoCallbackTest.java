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

import org.junit.Assert;
import org.junit.Test;

import co.aurasphere.botmill.fb.internal.util.json.FbBotMillJsonUtils;
import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.MessengerCallback;
import co.aurasphere.botmill.fb.model.incoming.callback.EchoMessage;
import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.ListTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;


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
		String echoListTemplatejson = "{\"object\":\"page\",\"entry\":[{\"id\":\"1423903854504468\",\"time\":1483578465379,\"messaging\":[{\"sender\":{\"id\":\"****\"},\"recipient\":{\"id\":\"****\"},\"timestamp\":1483578464765,\"message\":{\"is_echo\":true,\"app_id\":****,\"mid\":\"mid.1483578464765:ed1fe23f35\",\"seq\":785209,\"attachments\":[{\"title\":\"Title1, Title2, Title3, Title4\",\"url\":\"https://www.facebook.com/commerce/update/\",\"type\":\"template\",\"payload\":{\"template_type\":\"list\",\"sharable\":false,\"elements\":[{\"title\":\"Title1\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}},{\"title\":\"Title2\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}},{\"title\":\"Title3\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}},{\"title\":\"Title4\",\"item_url\":\"http://www.alvinjayreyes.com/\",\"image_url\":\"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg\",\"subtitle\":\"This is a sample sub title for your product\",\"buttons\":[{\"type\":\"postback\",\"title\":\"View\",\"payload\":\"view\"}],\"default_action\":{\"type\":\"web_url\",\"url\":\"http://www.alvinjayreyes.com/\"}}],\"buttons\":[{\"type\":\"postback\",\"title\":\"Just Sample\",\"payload\":\"Yes\"}]}}]}}]}]}";
		MessengerCallback callback = FbBotMillJsonUtils.fromJson(echoListTemplatejson,
				MessengerCallback.class);

		MessageEnvelope messageEnvelope = checkCallbackWellFormed(callback);

		EchoMessage echoMessage = super.assertInstanceOf(
				messageEnvelope.getMessage(), EchoMessage.class);

		// Checks that individual fields are correctly parsed.
		Assert.assertTrue(echoMessage.isEcho());
		Assert.assertEquals("****", echoMessage.getAppId());
		Assert.assertEquals("mid.1483578464765:ed1fe23f35",
				echoMessage.getMid());
		Assert.assertEquals("785209", echoMessage.getSeq()); 

		super.assertListOfSize(1, echoMessage.getAttachments());

		// Checks the attachment.
		Attachment attachment = echoMessage.getAttachments().get(0);
		Assert.assertEquals("Title1, Title2, Title3, Title4",
				attachment.getTitle());
		Assert.assertEquals("https://www.facebook.com/commerce/update/",
				attachment.getUrl());
		Assert.assertEquals(AttachmentType.TEMPLATE, attachment.getType());

		// Checks the payload.
		ListTemplatePayload payload = super.assertInstanceOf(
				attachment.getPayload(), ListTemplatePayload.class);
		Assert.assertEquals(PayloadType.LIST, payload.getTemplateType());
		super.assertListOfSize(4, payload.getElements());

		for (int i = 0; i < 4; i++) {
			checkListTemplateElements(payload.getElements().get(i), i + 1);
		}

		// Checks the buttons.
		super.assertListOfSize(1, payload.getButtons());
		checkPostbackButtonWellFormed(payload.getButtons().get(0),
				"Just Sample", "Yes");
	}

	/**
	 * Test that checks that each element of the List Template is correctly
	 * parsed.
	 *
	 * @param element the element
	 * @param position the position
	 */
	private void checkListTemplateElements(ListTemplateElement element,
			int position) {

		Assert.assertEquals("Title" + position, element.getTitle());
		Assert.assertEquals(
				"http://blog.domainmonkee.com/wp-content/uploads/2014/05/url.jpg",
				element.getImageUrl());
		Assert.assertEquals("This is a sample sub title for your product",
				element.getSubtitle());

		// Checks the buttons.
		super.assertListOfSize(1, element.getButtons());
		checkPostbackButtonWellFormed(element.getButtons().get(0), "View",
				"view");

		// Checks the default action.
		Assert.assertNotNull(element.getDefaultAction());
		Assert.assertEquals(ButtonType.WEB_URL, element.getDefaultAction()
				.getType());
		Assert.assertEquals("http://www.alvinjayreyes.com/", element
				.getDefaultAction().getUrl());
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
