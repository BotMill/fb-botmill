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
package co.aurasphere.botmill.fb.bean;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.event.FbBotMillEventType;
import co.aurasphere.botmill.fb.model.base.QuickReplyLocationPayload;
import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.callback.EchoMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.LocationCoordinates;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.support.FbBotMillMonitor;

/**
 * Base FbBot bean which contains utility methods for handling an envelope.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillBean {

	/**
	 * The logger.
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(FbBotMillBean.class);

	/**
	 * Retrieves a text message from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the text message if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetMessage(MessageEnvelope envelope) {
		if (envelope != null && envelope.getMessage() != null
				&& envelope.getMessage().getText() != null
				&& envelope.getMessage().getQuickReply() == null) {
			return envelope.getMessage().getText();
		}
		return "";
	}

	/**
	 * Retrieves a quick reply payload from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the text message if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetQuickReplyPayload(MessageEnvelope envelope) {
		if (envelope != null && envelope.getMessage() != null
				&& envelope.getMessage().getQuickReply() != null
				&& envelope.getMessage().getQuickReply().getPayload() != null) {
			return envelope.getMessage().getQuickReply().getPayload();
		}

		return "";
	}

	/**
	 * Retrieves a text message from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the message envelope if found or an empty String otherwise. It
	 *         never returns null.
	 */
	protected String safeGetPostbackPayload(MessageEnvelope envelope) {
		if (envelope != null && envelope.getPostback() != null
				&& envelope.getPostback().getPayload() != null) {
			return envelope.getPostback().getPayload();
		}
		return "";
	}

	/**
	 * Retrieves the recipient ID from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the recipient ID if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetRecipientId(MessageEnvelope envelope) {
		if (envelope != null && envelope.getRecipient() != null
				&& envelope.getRecipient().getId() != null) {
			return envelope.getRecipient().getId();
		}
		return "";
	}

	/**
	 * Retrieves the sender ID from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the sender ID if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetSenderId(MessageEnvelope envelope) {
		if (envelope != null && envelope.getSender() != null
				&& envelope.getSender().getId() != null) {
			return envelope.getSender().getId();
		}
		return "";
	}

	/**
	 * Retrieves the recipient from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return a {@link User} containing the recipient if found, empty
	 *         otherwise. It never returns null.
	 */
	protected User safeGetRecipient(MessageEnvelope envelope) {
		if (envelope != null && envelope.getRecipient() != null
				&& envelope.getRecipient().getId() != null) {
			return envelope.getRecipient();
		}
		return new User();
	}

	/**
	 * Retrieves the location from an envelope. It return nulls if none was
	 * retrieved.
	 * 
	 * @param envelope
	 *            the message envelope
	 * @return a {@link LocationCoordinates} containing the coordinates that the
	 *         user sets from the quick reply location payload.
	 */
	protected LocationCoordinates getLocationMessage(MessageEnvelope envelope) {
		if (envelope != null
				&& envelope.getMessage() != null
				&& envelope.getMessage().getAttachments() != null
				&& envelope.getMessage().getAttachments().get(0) != null
				&& envelope.getMessage().getAttachments().get(0).getPayload() != null
				&& envelope.getMessage().getAttachments().get(0).getPayload() instanceof QuickReplyLocationPayload) {

			QuickReplyLocationPayload payload = (QuickReplyLocationPayload) envelope
					.getMessage().getAttachments().get(0).getPayload();

			return payload.getCoordinates();
		}
		return null;
	}

	/**
	 * Retrieves the sender from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return a {@link User} containing the sender if found, empty otherwise.
	 *         It never returns null.
	 */
	protected User safeGetSender(MessageEnvelope envelope) {
		if (envelope != null && envelope.getSender() != null
				&& envelope.getSender().getId() != null) {
			return envelope.getSender();
		}
		return new User();
	}

	/**
	 * Returns the kind of callback received for the current envelope.
	 * 
	 * @param envelope
	 *            the envelope to inspect.
	 * @return a {@link FbBotMillEventType} representing the current callback
	 *         type.
	 */
	protected FbBotMillEventType eventKind(MessageEnvelope envelope) {
		IncomingMessage message = envelope.getMessage();
		if (message != null) {
			if (message instanceof ReceivedMessage) {
				if (getLocationMessage(envelope) != null) {
					return FbBotMillEventType.LOCATION;
				}
				return FbBotMillEventType.MESSAGE;
			}
			if (message instanceof EchoMessage) {
				return FbBotMillEventType.ECHO;
			}
		}
		if (envelope.getPostback() != null) {
			return FbBotMillEventType.POSTBACK;
		}
		if (envelope.getDelivery() != null) {
			return FbBotMillEventType.DELIVERY;
		}
		if (envelope.getRead() != null) {
			return FbBotMillEventType.READ;
		}
		if (envelope.getAccountLinking() != null) {
			return FbBotMillEventType.ACCOUNT_LINKING;
		}
		if (envelope.getOptin() != null) {
			return FbBotMillEventType.AUTHENTICATION;
		}
		if (envelope.getCheckoutUpdate() != null) {
			return FbBotMillEventType.CHECKOUT_UPDATE;
		}
		if (envelope.getReferral() != null) {
			return FbBotMillEventType.REFERRAL;
		}
		if (envelope.getPayment() != null) {
			return FbBotMillEventType.PAYMENT;
		}
		if (envelope.getPreCheckout() != null) {
			return FbBotMillEventType.PRE_CHECKOUT;
		}
		return FbBotMillEventType.ANY;
	}

	/**
	 * Validates the {@link FbBotMillResponse}.
	 *
	 * @param response
	 *            the response
	 * @return true if the response is valid, false otherwise.
	 */
	protected boolean validate(FbBotMillResponse response) {
		// If validations are not enabled, returns true.
		if (!FbBotMillContext.getInstance().isValidationEnabled()) {
			return true;
		}

		boolean valid = true;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<FbBotMillResponse>> violations = validator
				.validate(response);
		for (ConstraintViolation<FbBotMillResponse> v : violations) {
			valid = false;
			logger.error(
					"FbBotMillResponse validation error. Message: [{}] Value: [{}], Class: [{}], Field: [{}]",
					v.getMessage(), v.getInvalidValue(), v.getRootBean(),
					v.getPropertyPath());
		}

		if (valid == false) {
			// Sends the constraint violations through the callback.
			List<FbBotMillMonitor> registeredMonitors = FbBotMillContext
					.getInstance().getRegisteredMonitors();
			for (FbBotMillMonitor monitor : registeredMonitors) {
				monitor.onValidationError(response, violations);
			}
		}

		return valid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillBean []";
	}

}
