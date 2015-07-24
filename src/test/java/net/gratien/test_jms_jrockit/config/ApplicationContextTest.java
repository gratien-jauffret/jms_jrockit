package net.gratien.test_jms_jrockit.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import net.gratien.test_jms_jrockit.jms.JmsReceiver;

@Configuration
@Import(ApplicationContext.class)
@EnableJms
public class ApplicationContextTest {
	
	@Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory, Queue queue) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(queue);
        jmsTemplate.setConnectionFactory(connectionFactory);
        return jmsTemplate;
    }
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("jms.queue");
	}

    @Bean
    @DependsOn("broker")
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }
    
    @Bean
    BrokerService broker() throws Exception {
    	BrokerService broker = BrokerFactory.createBroker("broker:tcp://localhost:61616", false);
    	broker.setUseJmx(false);
    	broker.setPersistent(true);
    	broker.start();
    	return broker;
    }
    
    @Bean
    JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
    
    @Bean
    public JmsReceiver jmsReceiver() {
    	return new JmsReceiver();
    }
//	
//	@Bean
//    MessageListenerAdapter messageListenerAdp(JmsReceiver receiver) {
//        MessageListenerAdapter messageListenerAdp = new MessageListenerAdapter(receiver);
//        messageListenerAdp.setDefaultListenerMethod("receiveMessage");
//        return messageListenerAdp;
//    }
    
    
    
//    @Bean
//    public DefaultJmsListenerContainerFactory myContainerFactory() {
//        DefaultJmsListenerContainerFactory factory =
//                new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory());
//        factory.setDestinationResolver(destinationResolver());
//        factory.setConcurrency("3-10");
//        return factory;
//    }
//    
//    @Bean
//    public DestinationResolver destinationResolver() {
//    	DynamicDestinationResolver destinationResolver = new DynamicDestinationResolver();
//    	destinationResolver.resolveDestinationName(session, destinationName, pubSubDomain);
//    }
}
