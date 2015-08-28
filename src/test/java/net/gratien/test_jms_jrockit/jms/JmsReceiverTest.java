package net.gratien.test_jms_jrockit.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gratien.test_jms_jrockit.config.ApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextTest.class)
public class JmsReceiverTest {
	
	Logger logger = LoggerFactory.getLogger(JmsReceiverTest.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Test
	public void onMessageTest() throws Exception{
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("ping!");
			}
		});
		logger.info("message sent");
	}
}
