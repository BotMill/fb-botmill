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
package co.aurasphere.botmill.fb.test;

import co.aurasphere.botmill.fb.internal.util.json.JsonUtils;
import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;

/**
 * @author Donato Rimenti
 * 
 */
public class TestDeserialization {

	public static void main(String[] args) {
		String json = "{\"sender\":{\"id\":\"USER_ID\"},\"recipient\":{\"id\":\"PAGE_ID\"},\"timestamp\":1458692752478,\"message\":{\"mid\":\"mid.1458696618141:b4ef9d19ec21086067\",\"seq\":51,\"attachments\":[{\"type\":\"image\",\"payload\":{\"url\":\"IMAGE_URL\"}}]}}";
		String json2 = "{\"sender\":{\"id\":\"1152902104831488\"},\"recipient\":{\"id\":\"1209810882431614\"},\"timestamp\":1482953812997,\"message\":{\"mid\":\"mid.1482953812997:6c6e910961\",\"seq\":778909,\"attachments\":[{\"title\":\"Alvin's Location\",\"url\":\"https:\\/\\/www.facebook.com\\/l.php?u=https\u00253A\u00252F\u00252Fwww.bing.com\u00252Fmaps\u00252Fdefault.aspx\u00253Fv\u00253D2\u002526pc\u00253DFACEBK\u002526mid\u00253D8100\u002526where1\u00253D43.899746\u0025252C\u00252B-79.269825\u002526FORM\u00253DFBKPL1\u002526mkt\u00253Den-US&h=ATNzUb8qaIa5x61TRftUfE7RxWJE_E-5XeshoVeDOeGprLWnutTFxlENgC7vFhYuD3pB02N6PpzsEgcOiofJShlqT7a-lesSHScIzrLQVGPg-_22e6CETCbNhXeo57KTKsXLQU8&s=1&enc=AZNukLEVHCKFse_g9I7aBKSSgHbB3odYCw_9Do4rhrUXbJvjz_okfOP0gGwjSJ9Cd5PRpkxhT9kiCBrGBbXQCqPejz98NXzD6V6WVIEB4ZaDqA\",\"type\":\"location\",\"payload\":{\"coordinates\":{\"lat\":43.899746,\"long\":-79.269825}}}]}}";
		MessageEnvelope envelope = JsonUtils.fromJson(json2, MessageEnvelope.class);
		Payload payload = envelope.getMessage().getAttachments().get(0).getPayload();

		UrlPayload actualPayload = (UrlPayload) payload;

		System.out.println(actualPayload.getUrl());
	}

}
