package net.gratien.test_jms_jrockit.handlers.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class JmsErrorHandler implements ErrorHandler {

	Logger logger = LoggerFactory.getLogger(JmsErrorHandler.class);
	
	@Override
	public void handleError(Throwable t) {
		logger.error("error receiving message", t);
	}

}
