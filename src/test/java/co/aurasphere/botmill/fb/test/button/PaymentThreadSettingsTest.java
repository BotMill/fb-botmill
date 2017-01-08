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

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.fb.model.threadsettings.payment.PaymentDevModeAction;
import co.aurasphere.botmill.fb.model.threadsettings.payment.PaymentSettings;
import co.aurasphere.botmill.fb.test.BaseFbBotMillNetworkTest;
import co.aurasphere.botmill.fb.threadsettings.FbBotMillThreadSettingsConfiguration;

/**
 * Test class for the Payment Thread Settings.
 * 
 * @author Donato Rimenti
 * @date Jan 6, 2017
 */
public class PaymentThreadSettingsTest extends BaseFbBotMillNetworkTest {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.FbBotDefinition#defineBehavior()
	 */
	public void defineBehavior() {
		// Does nothing.

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#testImplementation()
	 */
	@Override
	protected void testImplementation() throws Exception {
		List<String> testers = new ArrayList<String>();
		testers.add(mockId);
		PaymentSettings settings = new PaymentSettings();
		settings.setPaymentTesters(testers);
		settings.setPaymentDevModeAction(PaymentDevModeAction.ADD);
		settings.setPublicKey("-----BEGIN PGP PUBLIC KEY BLOCK-----\nVersion: GnuPG v2\n\n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\nK6nOO3u8Mtf6rA==\n=KBrJ\n-----END PGP PUBLIC KEY BLOCK-----\n");
		FbBotMillThreadSettingsConfiguration.addPaymentSettings(settings);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#skipTest()
	 */
	@Override
	protected boolean skipTest() {
		return true;
	}

}
