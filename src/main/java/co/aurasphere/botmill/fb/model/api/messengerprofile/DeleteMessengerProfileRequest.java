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
package co.aurasphere.botmill.fb.model.api.messengerprofile;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Request used to delete a Messenger Profile setting.
 * 
 * @author Donato Rimenti
 */
public class DeleteMessengerProfileRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The fields to delete.
	 */
	@NotEmpty
	private List<String> fields;

	/**
	 * Instantiates a new DeleteMessengerProfileRequest.
	 */
	public DeleteMessengerProfileRequest() {
	}

	/**
	 * Instantiates a new DeleteMessengerProfileRequest.
	 *
	 * @param fields
	 *            the {@link #fields}.
	 */
	public DeleteMessengerProfileRequest(String... fields) {
		this.fields = Arrays.asList(fields);
	}

	/**
	 * Gets the {@link #fields}.
	 *
	 * @return the {@link #fields}.
	 */
	public List<String> getFields() {
		return fields;
	}

	/**
	 * Sets the {@link #fields}.
	 *
	 * @param fields
	 *            the {@link #fields} to set.
	 */
	public void setFields(List<String> fields) {
		this.fields = fields;
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
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
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
		DeleteMessengerProfileRequest other = (DeleteMessengerProfileRequest) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
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
		return "DeleteMessengerProfileRequest [fields=" + fields + "]";
	}

}
