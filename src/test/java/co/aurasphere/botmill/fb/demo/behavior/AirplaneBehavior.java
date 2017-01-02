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
package co.aurasphere.botmill.fb.demo.behavior;

import java.math.BigDecimal;
import java.util.Calendar;

import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.TravelClass;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.UpdateType;

/**
 * The Class AirplaneBehavior.
 */
public class AirplaneBehavior extends BaseBehavior {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.FbBotDefinition#defineBehavior()
	 */
	public void defineBehavior() {

		// Boarding pass template
		addActionFrame(new MessageEvent("boarding pass airline template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {

				return ReplyFactory.addAirlineBoardingPassTemplate("TEST TEMPLATE", "en_US").setThemeColor("#009023")
						.addBoardingPass("Passenger 1", "13",
								"http://seeklogo.com/images/A/Airport-logo-912173495E-seeklogo.com.gif",
								"http://seeklogo.com/images/A/Airport-logo-912173495E-seeklogo.com.gif")
						.addFlightInfo("19099922").setArrivalAirport("SR", "Siracusa")
						.setDepartureAirport("CT", "Catania")
						.setFlightSchedule(Calendar.getInstance(), Calendar.getInstance()).endFlightInfo()
						.addAuxiliaryField("LABEL1", "VALUE1").addAuxiliaryField("LABEL2", "VALUE2")
						.addSecondaryField("SEC1", "SEC2")
						.setBarcodeImageUrl("http://www.qrstuff.com/images/sample.png")
						.setHeaderImageUrl("http://seeklogo.com/images/A/Airport-logo-912173495E-seeklogo.com.gif")
						.setHeaderTextField("HEADER TEXT").setQrCode("12345").setSeat("12")
						.setTravelClass(TravelClass.FIRST_CLASS).endBoardingPass()
						.addBoardingPass("Passenger 2", "213",
								"http://seeklogo.com/images/A/Airport-logo-912173495E-seeklogo.com.gif",
								"http://seeklogo.com/images/A/Airport-logo-912173495E-seeklogo.com.gif")
						.addFlightInfo("19099922").setArrivalAirport("SR", "Siracusa")
						.setDepartureAirport("CT", "Catania")
						.setFlightSchedule(Calendar.getInstance(), Calendar.getInstance()).endFlightInfo()
						.endBoardingPass().build(envelope);
			}
		});

		// Checkin Template template
		addActionFrame(new MessageEvent("checkin airline template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addAirlineCheckinTemplate("Here's your checkin info", "en_US", "assaf", "www.aurasphere.co")
						.addFlightInfo("1234").setArrivalAirport("SR", "SR").setDepartureAirport("BG", "BG")
						.setFlightSchedule(Calendar.getInstance(), Calendar.getInstance()).endFlightInfo()
						.build(envelope);
			}

		});

		// Flight Update airline template
		addActionFrame(new MessageEvent("flight update airline template"), new AutoReply() {

			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addAirlineFlightUpdateTemplate("Your flight has an update", "en_US", "121212",
								UpdateType.CANCELLATION)
						.addFlightInfo("120").setArrivalAirport("U2", "Bergamo").setDepartureAirport("D12", "Catania")
						.setFlightSchedule(Calendar.getInstance(), Calendar.getInstance()).endFlightInfo()
						.build(envelope);
			}
		});

		// Itinerary template
		addActionFrame(new MessageEvent("itinerary airline template"), new AutoReply() {
			@Override
			public FbBotMillResponse createResponse(MessageEnvelope envelope) {
				return ReplyFactory
						.addAirlineItineraryTemplate("Here's your itinerary", "en_US", "D0FQTK",
								new BigDecimal(4032.54), "USD")
						.setBasePrice(new BigDecimal(200.71)).addPassengerInfo("1", "Sarah Hum")
						.addPassengerInfo("2", "Jeremy Goldberg").addFlightInfo("123", "123", "1", TravelClass.BUSINESS)
						.setAircraftType("Boeing").setArrivalAirport("BG", "Bergamo")
						.setDepartureAirport("CT", "Catania")
						.setFlightSchedule(Calendar.getInstance(), Calendar.getInstance()).endFlightInfo()
						.addPassengerSegmentInfo("1", "2", "14A", "Economy").addProductInfo("Cabin", "Coach")
						.endPassengerSegmentInfo().addPriceInfo("Cabin", new BigDecimal(100))
						.addPriceInfo("Ticket", new BigDecimal(200)).setTax(new BigDecimal(200))
						.addQuickReply("OK", "OK").build(envelope);
			}
		});

	}
}
