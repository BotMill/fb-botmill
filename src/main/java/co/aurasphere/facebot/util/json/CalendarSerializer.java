package co.aurasphere.facebot.util.json;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.Calendar;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CalendarSerializer implements JsonSerializer<Calendar> {
	
	private final DecimalFormat formatter;

	public CalendarSerializer() {
		this.formatter = new DecimalFormat("00");
		;
	}

	public JsonElement serialize(Calendar src, Type typeOfSrc,
			JsonSerializationContext context) {
		int year = src.get(Calendar.YEAR);
		String month = formatter
				.format(Double.valueOf(src.get(Calendar.MONTH) + 1));
		String day = formatter.format(Double.valueOf(src
				.get(Calendar.DAY_OF_MONTH)));
		String hour = formatter.format(Double.valueOf(src
				.get(Calendar.HOUR_OF_DAY)));
		String minute = formatter.format(Double.valueOf(src
				.get(Calendar.MINUTE)));
		String formattedDate = year + "-" + month + "-" + day + "T" + hour
				+ ":" + minute;

		return context.serialize(formattedDate);
	}
}
