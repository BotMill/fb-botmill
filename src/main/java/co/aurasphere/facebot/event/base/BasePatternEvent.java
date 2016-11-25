package co.aurasphere.facebot.event.base;

import java.util.regex.Pattern;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.event.FaceBotEvent;

/**
 * Base event handler which occurs when a Pattern matches a String.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public abstract class BasePatternEvent extends FaceBotBean implements
		FaceBotEvent {

	/**
	 * The pattern to match against the incoming text message.
	 */
	public Pattern expectedPattern;

	/**
	 * Object constructor.
	 * 
	 * @param expectedPattern
	 *            the pattern to match against the incoming event. It can't be
	 *            null.
	 */
	public BasePatternEvent(Pattern expectedPattern) {
		this.expectedPattern = expectedPattern;
	}

	/**
	 * Object constructor.
	 * 
	 * @param expectedPattern
	 *            the pattern to match against the incoming event. It can't be
	 *            null or empty.
	 */
	public BasePatternEvent(String expectedPattern) {
		this.expectedPattern = Pattern.compile(expectedPattern);
	}

}
