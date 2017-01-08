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

import java.util.Calendar;

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Utility class for handling JSON serialization and deserialization.
 * 
 * @author Donato Rimenti
 */
public class JsonUtils {

	/**
	 * Gson which handles the JSON conversion.
	 */
	private static Gson gson;

	/**
	 * Instantiates a new JsonUtils.
	 */
	private JsonUtils() {
	}

	/**
	 * Initializes the current Gson object if null and returns it. The Gson
	 * object has custom adapters to manage datatypes according to Facebook
	 * formats.
	 * 
	 * @return the current instance of Gson.
	 */
	private static Gson getGson() {
		if (gson == null) {
			// Creates the Gson object which will manage the information
			// received
			GsonBuilder builder = new GsonBuilder();

			// Serializes enums as lower-case.
			builder.registerTypeHierarchyAdapter(Enum.class,
					new EnumLowercaseSerializer());

			// Serializes calendar in format YYYY-MM-DDThh:mm.
			builder.registerTypeHierarchyAdapter(Calendar.class,
					new CalendarSerializer());

			// Deserializes payloads from interface.
			builder.registerTypeAdapter(Attachment.class,
					new AttachmentDeserializer());

			// Deserializes buttons from interface.
			builder.registerTypeAdapter(Button.class, new ButtonDeserializer());

			// Deserializes incoming messages from interface.
			builder.registerTypeAdapter(IncomingMessage.class, new IncomingMessageDeserializer());

			gson = builder.create();
		}
		return gson;
	}

	/**
	 * From json.
	 *
	 * @param <T>
	 *            the generic type
	 * @param json
	 *            the string from which the object is to be deserialized.
	 * @param T
	 *            the type of the desired object.
	 * @return an object of type T from the string. Returns null if json is
	 *         null.
	 * @see Gson#fromJson(String, Class)
	 */
	public static <T> T fromJson(String json, Class<T> T) {
		return getGson().fromJson(json, T);
	}

	/**
	 * To json.
	 *
	 * @param src
	 *            the object for which Json representation is to be created
	 *            setting for Gson .
	 * @return Json representation of src.
	 * @see Gson#toJson(Object)
	 */
	public static String toJson(Object src) {
		return getGson().toJson(src);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonUtils []";
	}

}
