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
package co.aurasphere.botmill.fb.test.button;

import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.RequestedUserInfo;
import co.aurasphere.botmill.fb.test.BaseFbBotMillMessageTest;

/**
 * Unit test for a {@link BuyButton}.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class BuyButtonTest extends BaseFbBotMillMessageTest {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.FbBotDefinition#defineBehavior()
	 */
	public void defineBehavior() {

		addActionFrame(new MessageEvent("test_buy_button"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addGenericTemplate()
						.addElement(
								"A simple Button Template with a Buy Button")
						.addButton(
								ButtonFactory
										.createBuyButton("buy_button_payload")
										.setPaymentSummary("USD",
												PaymentType.FIXED_AMOUNT,
												"BotMill.io")
										.addPriceLabel("A price label", "2")
										.setTestPayment(true)
										.addRequestedUserInfo(
												RequestedUserInfo.CONTACT_PHONE)
										.build()).endElement().build(envelope);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#getMessagesToSend()
	 */
	@Override
	public String[] getMessagesToSend() {
		return new String[] { "test_buy_button" };
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#skipTest()
	 */
	@Override
	protected boolean skipTest() {
		return true;
	}

}
