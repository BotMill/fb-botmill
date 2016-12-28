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

				return ReplyFactory.addAirlineBoardingPassTemplate("TEST TEMPLATE", "en_US")
						.setThemeColor("#009023")
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
