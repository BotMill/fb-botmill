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

import co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu.CallToActionNested;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.LoginButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.LogoutButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PostbackButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ShareButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebUrlButton;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


/**
 * Custom serializer/deserializer for an {@link Button}. Instantiates the
 * correct button from interface.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class ButtonSerializer implements JsonSerializer<Button>,
		JsonDeserializer<Button> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
	 * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public JsonElement serialize(Button src, Type typeOfSrc,
			JsonSerializationContext context) {
		ButtonType buttonType = src.getType();
		Class<?> buttonClass = getButtonClass(buttonType);
		return context.serialize(src, buttonClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public Button deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		String buttonTypeString = json.getAsJsonObject().get("type")
				.getAsString();
		ButtonType buttonType = ButtonType.valueOf(buttonTypeString
				.toUpperCase());
		Class<?> buttonClass = getButtonClass(buttonType);
		return context.deserialize(json, buttonClass);
	}

	/**
	 * Utility method for getting a button class from the {@link ButtonType}.
	 * 
	 * @param type
	 *            the button type.
	 * @return the button class for that type.
	 */
	private Class<?> getButtonClass(ButtonType type) {
		switch (type) {
		case ACCOUNT_LINK:
			return LoginButton.class;
		case ACCOUNT_UNLINK:
			return LogoutButton.class;
		case ELEMENT_SHARE:
			return ShareButton.class;
		case PAYMENT:
			return BuyButton.class;
		case PHONE_NUMBER:
			return PostbackButton.class;
		case POSTBACK:
			return PostbackButton.class;
		case WEB_URL:
			return WebUrlButton.class;
		case NESTED:
			return CallToActionNested.class;
		}
		// This will never happen.
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ButtonSerializer []";
	}

}
