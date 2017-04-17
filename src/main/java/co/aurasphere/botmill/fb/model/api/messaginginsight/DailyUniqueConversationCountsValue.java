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

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Value of a record from {@link DailyUniqueConversationCountsRecord}.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class DailyUniqueConversationCountsValue implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The value.
	 */
	private DailyUniqueConversationCountsValueEnum value;

	/**
	 * The end time.
	 */
	@SerializedName("end_time")
	private Date endTime;

	/**
	 * Gets the {@link #value}.
	 *
	 * @return the {@link #value}.
	 */
	public DailyUniqueConversationCountsValueEnum getValue() {
		return value;
	}

	/**
	 * Sets the {@link #value}.
	 *
	 * @param value
	 *            the {@link #value} to set.
	 */
	public void setValue(DailyUniqueConversationCountsValueEnum value) {
		this.value = value;
	}

	/**
	 * Gets the {@link #endTime}.
	 *
	 * @return the {@link #endTime}.
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the {@link #endTime}.
	 *
	 * @param endTime
	 *            the {@link #endTime} to set.
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		DailyUniqueConversationCountsValue other = (DailyUniqueConversationCountsValue) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DailyUniqueConversationCountsValue [value=" + value
				+ ", endTime=" + endTime + "]";
	}

}
