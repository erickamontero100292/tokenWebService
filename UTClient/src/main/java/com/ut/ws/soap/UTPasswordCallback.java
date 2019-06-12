package com.ut.ws.soap;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callback) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callback.length; i++) {
			WSPasswordCallback passwordCallback = (WSPasswordCallback)callback[i];
			if(passwordCallback.getIdentifier().equals("Ericka")) {
				passwordCallback.setPassword("Ericka");
				return;
			}
			
		}
	}

}
