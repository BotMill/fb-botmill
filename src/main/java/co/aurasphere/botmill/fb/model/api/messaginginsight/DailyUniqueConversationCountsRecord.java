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
package co.aurasphere.botmill.fb.model.api.messaginginsight;

import java.util.List;

/**
 * Record used by {@link DailyUniqueConversationCounts}.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class DailyUniqueConversationCountsRecord extends MessagingInsightBaseRecord {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The values.
	 */
	private List<DailyUniqueConversationCountsValue> values;

	/**
	 * Gets the {@link #values}.
	 *
	 * @return the {@link #values}.
	 */
	public List<DailyUniqueConversationCountsValue> getValues() {
		return values;
	}

	/**
	 * Sets the {@link #values}.
	 *
	 * @param values the {@link #values} to set.
	 */
	public void setValues(List<DailyUniqueConversationCountsValue> values) {
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.model.api.messaginginsight.MessagingInsightBaseRecord#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.model.api.messaginginsight.MessagingInsightBaseRecord#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DailyUniqueConversationCountsRecord other = (DailyUniqueConversationCountsRecord) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.model.api.messaginginsight.MessagingInsightBaseRecord#toString()
	 */
	@Override
	public String toString() {
		return "DailyUniqueConversationCountsRecord [values=" + values + "]";
	}

}
