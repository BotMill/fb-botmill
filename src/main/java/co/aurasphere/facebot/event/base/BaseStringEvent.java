package co.aurasphere.facebot.event.base;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.event.FaceBotEvent;

/**
 * Base event handler which occurs when an exact String is received.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public abstract class BaseStringEvent extends FaceBotBean implements
		FaceBotEvent {

	/**
	 * The expected string from the Facebook Messenger Platform callback in
	 * order to trigger this handler.
	 */
	protected String expectedString;

	/**
	 * Indicates whether the comparison should be case sensitive or not.
	 */
	protected boolean caseSensitive;

	/**
	 * Default constructor.
	 * 
	 * @param expectedString
	 *            the string that will trigger this handler. It can't be null or
	 *            empty.
	 * @param caseSensitive
	 *            a boolean that indicates if the comparison should be
	 *            caseSensitive.
	 */
	public BaseStringEvent(String expectedString, boolean caseSensitive) {
		this.expectedString = expectedString;
		this.caseSensitive = caseSensitive;
	}
	
	public BaseStringEvent(String expectedString) {
		this.expectedString = expectedString;
		this.caseSensitive = true;
	}

}
