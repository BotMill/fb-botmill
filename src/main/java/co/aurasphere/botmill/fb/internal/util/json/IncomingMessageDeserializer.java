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
package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;

import co.aurasphere.botmill.fb.model.incoming.callback.EchoMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Custom deserializer for an {@link IncomingMessage}. Instantiates the correct
 * message from interface.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class IncomingMessageDeserializer implements
		JsonDeserializer<IncomingMessage> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public IncomingMessage deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		boolean isEcho = json.getAsJsonObject().get("is_echo").getAsBoolean();
		Class<? extends IncomingMessage> incomingMessageClass = null;
		if (isEcho == true) {
			incomingMessageClass = EchoMessage.class;
		} else {
			incomingMessageClass = ReceivedMessage.class;
		}
		return context.deserialize(json, incomingMessageClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncomingMessageDeserializer []";
	}

}
