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
package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;

import com.google.gson.annotations.SerializedName;

/**
 * A {@link Payload} which contains a Template.
 * 
 * @author Donato Rimenti
 * 
 */
public class TemplateBasePayload implements Payload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The type of the template content.
	 */
	@NotNull
	@SerializedName("template_type")
	protected PayloadType templateType;

	/**
	 * Gets the {@link #templateType}.
	 *
	 * @return the {@link #templateType}.
	 */
	public PayloadType getTemplateType() {
		return templateType;
	}

	/**
	 * Sets the {@link #templateType}.
	 *
	 * @param templateType
	 *            the {@link #templateType} to set.
	 */
	public void setTemplateType(PayloadType templateType) {
		this.templateType = templateType;
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
				+ ((templateType == null) ? 0 : templateType.hashCode());
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
		TemplateBasePayload other = (TemplateBasePayload) obj;
		if (templateType != other.templateType)
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
		return "TemplateBasePayload [templateType=" + templateType + "]";
	}

}
