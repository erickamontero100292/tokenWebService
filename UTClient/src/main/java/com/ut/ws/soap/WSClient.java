package com.ut.ws.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.token.ws.soap.PaymentProcessorImplService;
import com.token.ws.soap.PaymentProcessorRequest;
import com.token.ws.soap.PaymentProcessorResponse;
import com.token.ws.soap.PaymentProcessor_0020;

public class WSClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PaymentProcessorImplService service = new PaymentProcessorImplService(
					new URL("http://localhost:8080/tokenwebservices/paymentProcessor?wsdl"));
			PaymentProcessor_0020 port = service.getPaymentProcessorImplPort();

			PaymentProcessorRequest paymentProcessorResponse = new PaymentProcessorRequest();

			Client client = ClientProxy.getClient(port);
			Endpoint endpoint = client.getEndpoint();
			Map<String, Object> map = new HashMap<>();
			map.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			map.put(WSHandlerConstants.USER, "Ericka");
			map.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			map.put(WSHandlerConstants.PW_CALLBACK_CLASS,UTPasswordCallback.class.getName());
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(map);
			endpoint.getOutInterceptors().add(wssOut);
			PaymentProcessorResponse response = port.processPayment(paymentProcessorResponse);
			System.out.println(response.isResult());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
