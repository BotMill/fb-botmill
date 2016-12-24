package co.aurasphere.botmill.fb.event.base;

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;


/**
 * Base event handler which occurs when a Pattern matches a String.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public abstract class BasePatternEvent extends FbBotMillBean implements
		FbBotMillEvent {

	/**
	 * The pattern to match against the incoming text message.
	 */
	public Pattern expectedPattern;

	/**
	 * Instantiates a new base pattern event.
	 *
	 * @param expectedPattern
	 *            the {@link #expectedPattern}.
	 */
	protected BasePatternEvent(Pattern expectedPattern) {
		this.expectedPattern = expectedPattern;
	}

	/**
	 * Instantiates a new base pattern event.
	 *
	 * @param expectedPattern
	 *            the {@link #expectedPattern}.
	 */
	protected BasePatternEvent(String expectedPattern) {
		this.expectedPattern = Pattern.compile(expectedPattern);
	}

	/**
	 * Method used to check if a text matches against this event pattern.
	 * 
	 * @param text
	 *            the text to match.
	 * @return true if the text matches this event pattern, false otherwise.
	 */
	protected boolean verifyPatternMatch(String text) {
		if(this.expectedPattern == null){
			return false;
		}
		return this.expectedPattern.matcher(text).matches();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expectedPattern == null) ? 0 : expectedPattern.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasePatternEvent other = (BasePatternEvent) obj;
		if (expectedPattern == null) {
			if (other.expectedPattern != null)
				return false;
		} else if (!expectedPattern.equals(other.expectedPattern))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.bean.FaceBotBean#toString()
	 */
	@Override
	public String toString() {
		return "BasePatternEvent [expectedPattern=" + expectedPattern + "]";
	}

}
