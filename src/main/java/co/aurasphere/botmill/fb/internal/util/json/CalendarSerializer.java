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
import java.text.DecimalFormat;
import java.util.Calendar;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Class that handles the serialization of a Calendar using the Facebook date
 * format (YYYY-MM-DDThh:mm).
 * 
 * @author Donato Rimenti
 * 
 */
public class CalendarSerializer implements JsonSerializer<Calendar> {

	/**
	 * The formatter for the calendar.
	 */
	private final DecimalFormat formatter;

	/**
	 * Instantiates a new calendar serializer.
	 */
	public CalendarSerializer() {
		this.formatter = new DecimalFormat("00");
	}

	/**
	 * Serializes a Calendar using the Facebook date format (YYYY-MM-DDThh:mm).
	 *
	 * @param src
	 *            the src
	 * @param typeOfSrc
	 *            the type of src
	 * @param context
	 *            the context
	 * @return the json element
	 */
	public JsonElement serialize(Calendar src, Type typeOfSrc,
			JsonSerializationContext context) {
		int year = src.get(Calendar.YEAR);
		String month = this.formatter.format(Double.valueOf(src
				.get(Calendar.MONTH) + 1));
		String day = this.formatter.format(Double.valueOf(src
				.get(Calendar.DAY_OF_MONTH)));
		String hour = this.formatter.format(Double.valueOf(src
				.get(Calendar.HOUR_OF_DAY)));
		String minute = this.formatter.format(Double.valueOf(src
				.get(Calendar.MINUTE)));
		String formattedDate = year + "-" + month + "-" + day + "T" + hour
				+ ":" + minute;

		return context.serialize(formattedDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CalendarSerializer [formatter=" + formatter + "]";
	}
}
