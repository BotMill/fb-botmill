package co.aurasphere.facebot.validator;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.FaceBotContext;

/**
 * Utility class that performs argument validation. If a validation fails, an
 * IllegalArgumentException is thrown.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class FaceBotValidator {

	private static final Logger logger = LoggerFactory
			.getLogger(FaceBotValidator.class);

	/**
	 * Checks if an object is not null.
	 * 
	 * @param object
	 *            the object to check.
	 * @param variableName
	 *            the object name, used for logging purpose in case the
	 *            validation fails. Optional but recommended.
	 * @throws IllegalArgumentException
	 *             if the object is null.
	 * @return true if the object is not null.
	 */
	public static boolean notNull(Object object, String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		if (object == null) {
			String callerName = getCallerName();
			String message = variableName + " for " + callerName
					+ " can't be null!";
			logAndThrow(message);
		}
		return true;
	}

	/**
	 * Checks if a String is not null and is not empty.
	 * 
	 * @param string
	 *            the String to check.
	 * @param variableName
	 *            the String name, used for logging purpose in case the
	 *            validation fails. Optional but recommended.
	 * @throws IllegalArgumentException
	 *             if the String is null or empty.
	 * @return true if the String is not null and not empty.
	 */
	public static boolean notEmpty(String string, String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		if (string == null || string.isEmpty()) {
			String callerName = getCallerName();
			String message = variableName + " for " + callerName
					+ " can't be empty!";
			logAndThrow(message);
		}
		return true;
	}

	private static void logAndThrow(String message) {
		RuntimeException exception = new FaceBotValidationException(message);
		logger.error(message);
		throw exception;
	}

	private static String getCallerName() {
		StackTraceElement[] stackTrace = new Exception().getStackTrace();
		for (StackTraceElement e : stackTrace) {
			if (!e.getClassName().equals(
					FaceBotValidator.class.getCanonicalName()))
				return e.getClassName();
		}
		return null;
	}

	/**
	 * Checks if a String is not null, not empty and shorter than the given
	 * size.
	 * 
	 * @param string
	 *            the String to check.
	 * @param length
	 *            the maximum size of the String to check.
	 * @param variableName
	 *            the String name, used for logging purpose in case the
	 *            validation fails. Optional but recommended.
	 * @throws IllegalArgumentException
	 *             if the String is null, empty or longer than length.
	 * @return true if the String is not null, not empty and shorter than
	 *         length.
	 */
	public static boolean shorterThanNotEmpty(String string, int length,
			String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		notEmpty(string, variableName);
		shorterThan(string, length, variableName);
		return true;
	}

	public static boolean shorterThan(String string, int length,
			String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		if (string.length() > length) {
			String callerName = getCallerName();
			String message = variableName + " for " + callerName
					+ " can't be longer than " + length + " characters!";
			logAndThrow(message);
		}
		return true;
	}

	public static boolean notEqual(Object objectToCheck, Object objectTwo,
			String variableName, String unacceptableVariableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		notNull(objectToCheck, variableName);
		if (objectToCheck.equals(objectTwo)) {
			String callerName = getCallerName();
			String message = variableName + " for " + callerName
					+ " can't have the value " + unacceptableVariableName + "!";
			logAndThrow(message);
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static boolean notEmpty(Collection collection, String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		notNull(collection, variableName);
		if (collection.isEmpty()) {
			String callerName = getCallerName();
			String message = variableName + " for " + callerName
					+ " can't be empty!";
			logAndThrow(message);
		}
		return true;
	}

	public static boolean notEmpty(Object[] array, String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		notNull(array, variableName);
		if (array.length == 0) {
			String callerName = getCallerName();
			String message = variableName + " for " + callerName
					+ " can't be empty!";
			logAndThrow(message);
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static boolean lessElementsThanNotEmpty(List list, int maxElements,
			String listName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		notEmpty(list, listName);
		if (list.size() > maxElements) {
			String callerName = getCallerName();
			String message = listName + " for " + callerName
					+ " can't have more than " + maxElements + "!";
			logAndThrow(message);
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static boolean lessElementsThan(List list, int maxElements,
			String listName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		if (list != null && list.size() > maxElements) {
			String callerName = getCallerName();
			String message = listName + " for " + callerName
					+ "can't have more than " + maxElements + "!";
			logAndThrow(message);
		}
		return true;
	}

	public static boolean onlyOneNotNull(String variableNames,
			Object... variables) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		int notNullCounter = 0;
		for (Object o : variables) {
			if (o != null) {
				notNullCounter++;
			}
		}
		if (notNullCounter != 1) {
			String callerName = getCallerName();
			String message = "Only one between [" + variableNames + "] for "
					+ callerName + " must be not null.";
			logAndThrow(message);
		}
		return true;
	}

	public static boolean atLeastOneNotNull(String variableNames,
			Object... variables) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		for (Object o : variables) {
			if (o != null) {
				return true;
			}
		}
		String callerName = getCallerName();
		String message = "At least one between [" + variableNames + "] for "
				+ callerName + " must be not null.";
		logAndThrow(message);

		// Never reaches this.
		return true;
	}

	public static boolean phoneNumberValid(String phoneNumber,
			String variableName) {
		if (!FaceBotContext.getInstance().isValidationEnabled()) {
			return false;
		}
		notEmpty(phoneNumber, variableName);

		if (!phoneNumber.startsWith("+")) {
			String callerName = getCallerName();
			String message = variableName
					+ " for "
					+ callerName
					+ " format mush be ‘+’ prefix followed by the country code, area code and local number.";
			logAndThrow(message);
		}

		return true;

	}
}
