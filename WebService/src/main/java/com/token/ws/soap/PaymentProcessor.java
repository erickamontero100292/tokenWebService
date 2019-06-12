package com.token.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.token.ws.soap.dto.PaymentProcessorRequest;
import com.token.ws.soap.dto.PaymentProcessorResponse;


@WebService (name="PaymentProcessor ")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name="response") PaymentProcessorResponse processPayment(
			@WebParam(name="paymentProcessorResponse") PaymentProcessorRequest paymentProcessorRequest);
}
