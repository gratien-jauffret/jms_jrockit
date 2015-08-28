package net.gratien.test_jms_jrockit.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.gratien.test_jms_jrockit.controllers.MainController;
import net.stratml.productorservicedescription.ProductOrServiceDescription;

@Component
public class JmsReceiver implements MessageListener {

	Logger logger = LoggerFactory.getLogger(JmsReceiver.class);

	@Autowired
	MainController controller;

	@Override
	public void onMessage(Message message) {
		TextMessage msg = null;
		try {
			logger.info("received message : " + message);
			msg = (TextMessage) message;
			String xml = msg.getText();
			controller.handleJmsMessage(xml);
		} catch (Exception ex) {
			if (logger.isErrorEnabled()) {
				logger.error("Could not parse notification from queue {0} due to {1} ", new Object[] { "myQueue", ex });
			}
		}
	}
}
