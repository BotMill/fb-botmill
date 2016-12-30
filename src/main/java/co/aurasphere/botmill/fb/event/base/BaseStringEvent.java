package co.aurasphere.botmill.fb.event.base;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;


/**
 * The Class BaseStringEvent.
 */
public abstract class BaseStringEvent extends FbBotMillBean implements
		FbBotMillEvent {

	/**
	 * The expected string.
	 */
	protected String expectedString;

	/**
	 * The case sensitive.
	 */
	protected boolean caseSensitive;

	/**
	 * Instantiates a new BaseStringEvent.
	 *
	 * @param expectedString the {@link #expectedString}.
	 * @param caseSensitive the {@link #caseSensitive}.
	 */
	public BaseStringEvent(String expectedString, boolean caseSensitive) {
		if (caseSensitive == false && expectedString != null) {
			this.expectedString = expectedString.toLowerCase();
		}
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Instantiates a new BaseStringEvent.
	 *
	 * @param expectedString the {@link #expectedString}.
	 */
	public BaseStringEvent(String expectedString) {
		this.expectedString = expectedString;
		this.caseSensitive = true;
	}

	/**
	 * Verify string match.
	 *
	 * @param text the string used to check if it matches the event string.
	 * @return true, if successful
	 */
	protected boolean verifyStringMatch(String text) {
		if (text == null) {
			return false;
		}
		if (!this.caseSensitive) {
			text = text.toLowerCase();
		}
		return text.equals(this.expectedString);
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
		result = prime * result + (caseSensitive ? 1231 : 1237);
		result = prime * result
				+ ((expectedString == null) ? 0 : expectedString.hashCode());
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
		BaseStringEvent other = (BaseStringEvent) obj;
		if (caseSensitive != other.caseSensitive)
			return false;
		if (expectedString == null) {
			if (other.expectedString != null)
				return false;
		} else if (!expectedString.equals(other.expectedString))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "BaseStringEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}
}
