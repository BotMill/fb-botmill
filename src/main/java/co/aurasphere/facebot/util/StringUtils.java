package co.aurasphere.facebot.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Utility class which handles string conversions.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class StringUtils {

	/**
	 * Utility method which converts an InputStream to a String.
	 * 
	 * @param stream
	 *            the InputStream to convert.
	 * @return a String with the InputStream content.
	 * @throws IOException
	 */
	public static String inputStreamToString(InputStream stream)
			throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		String resultString = null;
		while ((length = stream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		resultString = result.toString("UTF-8");
		return resultString;
	}

	/**
	 * Utility method that converts a Reader to a String.
	 * 
	 * @param reader
	 *            the reader to convert.
	 * @return a String with the content of the reader.
	 * @throws IOException
	 */
	public static String readerToString(Reader reader) throws IOException {
		char[] arr = new char[8 * 1024];
		StringBuilder buffer = new StringBuilder();
		int numCharsRead;
		while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
			buffer.append(arr, 0, numCharsRead);
		}
		return buffer.toString();
	}

	public static String stringListToString(List<String> stringList) {
		if (stringList == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for(String s : stringList){
			builder.append(s).append(", ");
		}
		// Removes the last comma.
		int len = builder.length();
		if (len > 0) {
			builder.delete(len - 2, len);
		}
		return builder.toString();
	}
	
	public static String mergeStringArray(String[] array, boolean addSpace){
		if(array == null){
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for(String s : array){
			builder.append(s);
			if(addSpace){
				builder.append(" ");
			}
		}
		return builder.toString();
	}

}
