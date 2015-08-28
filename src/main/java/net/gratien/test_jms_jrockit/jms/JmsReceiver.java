package net.gratien.test_jms_jrockit.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.gratien.test_jms_jrockit.controllers.MainController;
import net.stratml.productorservicedescription.ProductOrServiceDescription;

@Component
public class JmsReceiver {

	Logger logger = LoggerFactory.getLogger(JmsReceiver.class);

	@Autowired
	MainController controller;
	
	public void onProductOrServiceDescriptionMessage(ProductOrServiceDescription posd) {
		logger.info("posd received : " + posd);
	}
}
