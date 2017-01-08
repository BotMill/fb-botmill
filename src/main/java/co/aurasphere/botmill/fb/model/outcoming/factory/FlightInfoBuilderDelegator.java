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
package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;

/**
 * An interface that represents a builder which uses a {@link FlightInfoBuilder}
 * object to populate its {@link FlightInfo} field.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class FlightInfoBuilderDelegator extends
		AirlineBaseTemplateBuilder {

	/**
	 * Adds a flight info object to the builder's payload.
	 * 
	 * @param flightInfo
	 *            the flight info to add.
	 */
	abstract void addFlightInfo(FlightInfo flightInfo);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.factory.AirlineBaseTemplateBuilder
	 * #toString()
	 */
	@Override
	public String toString() {
		return "FlightInfoBuilderDelegator [messageBuilder=" + messageBuilder
				+ "]";
	}

}
