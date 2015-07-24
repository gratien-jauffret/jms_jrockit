package net.gratien.test_jms_jrockit.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {
	
	Logger logger = LoggerFactory.getLogger(JmsReceiver.class);

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "jms.queue", containerFactory = "jmsContainerFactory")
    public void receiveMessage(String message) {
//        System.out.println("Received <" + message + ">");
    	logger.info("Received <" + message + ">");
    }
}
