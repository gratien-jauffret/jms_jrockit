package net.gratien.test_jms_jrockit.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@Import(ApplicationContext.class)
public class ApplicationContextTest {

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setDefaultDestination(queue());
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
	}

	@Bean
	public Destination queue() {
		return new ActiveMQQueue("jms.queue");
	}

	@Bean
	@DependsOn("broker")
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;
	}

	@Bean
	BrokerService broker() throws Exception {
		BrokerService broker = BrokerFactory.createBroker("broker:tcp://localhost:61616", false);
		broker.setUseJmx(false);
		broker.setPersistent(true);
		broker.setUseShutdownHook(false);
		broker.start();
		return broker;
	}
}