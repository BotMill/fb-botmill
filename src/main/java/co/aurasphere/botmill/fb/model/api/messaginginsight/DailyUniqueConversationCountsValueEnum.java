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

import com.google.gson.annotations.SerializedName;

/**
 * Value of a record from {@link DailyUniqueConversationCountsValueEnum}.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class DailyUniqueConversationCountsValueEnum implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The turn on.
	 */
	@SerializedName("TURN_ON")
	private int turnOn;

	/**
	 * The turn off.
	 */
	@SerializedName("TURN_OFF")
	private int turnOff;

	/**
	 * The delete.
	 */
	@SerializedName("DELETE")
	private int delete;

	/**
	 * The other.
	 */
	@SerializedName("OTHER")
	private int other;

	/**
	 * The report spam.
	 */
	@SerializedName("REPORT_SPAM")
	private int reportSpam;

	/**
	 * Gets the {@link #turnOn}.
	 *
	 * @return the {@link #turnOn}.
	 */
	public int getTurnOn() {
		return turnOn;
	}

	/**
	 * Sets the {@link #turnOn}.
	 *
	 * @param turnOn
	 *            the {@link #turnOn} to set.
	 */
	public void setTurnOn(int turnOn) {
		this.turnOn = turnOn;
	}

	/**
	 * Gets the {@link #turnOff}.
	 *
	 * @return the {@link #turnOff}.
	 */
	public int getTurnOff() {
		return turnOff;
	}

	/**
	 * Sets the {@link #turnOff}.
	 *
	 * @param turnOff
	 *            the {@link #turnOff} to set.
	 */
	public void setTurnOff(int turnOff) {
		this.turnOff = turnOff;
	}

	/**
	 * Gets the {@link #delete}.
	 *
	 * @return the {@link #delete}.
	 */
	public int getDelete() {
		return delete;
	}

	/**
	 * Sets the {@link #delete}.
	 *
	 * @param delete
	 *            the {@link #delete} to set.
	 */
	public void setDelete(int delete) {
		this.delete = delete;
	}

	/**
	 * Gets the {@link #other}.
	 *
	 * @return the {@link #other}.
	 */
	public int getOther() {
		return other;
	}

	/**
	 * Sets the {@link #other}.
	 *
	 * @param other
	 *            the {@link #other} to set.
	 */
	public void setOther(int other) {
		this.other = other;
	}

	/**
	 * Gets the {@link #reportSpam}.
	 *
	 * @return the {@link #reportSpam}.
	 */
	public int getReportSpam() {
		return reportSpam;
	}

	/**
	 * Sets the {@link #reportSpam}.
	 *
	 * @param reportSpam
	 *            the {@link #reportSpam} to set.
	 */
	public void setReportSpam(int reportSpam) {
		this.reportSpam = reportSpam;
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
		result = prime * result + delete;
		result = prime * result + other;
		result = prime * result + reportSpam;
		result = prime * result + turnOff;
		result = prime * result + turnOn;
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
		DailyUniqueConversationCountsValueEnum other = (DailyUniqueConversationCountsValueEnum) obj;
		if (delete != other.delete)
			return false;
		if (this.other != other.other)
			return false;
		if (reportSpam != other.reportSpam)
			return false;
		if (turnOff != other.turnOff)
			return false;
		if (turnOn != other.turnOn)
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
		return "DailyUniqueConversationCountsValueEnum [turnOn=" + turnOn
				+ ", turnOff=" + turnOff + ", delete=" + delete + ", other="
				+ other + ", reportSpam=" + reportSpam + "]";
	}

}
