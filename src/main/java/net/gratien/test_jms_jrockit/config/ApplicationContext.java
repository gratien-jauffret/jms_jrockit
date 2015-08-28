package net.gratien.test_jms_jrockit.config;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jms.connection.TransactionAwareConnectionFactoryProxy;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import net.gratien.test_jms_jrockit.handlers.jms.JmsErrorHandler;
import net.gratien.test_jms_jrockit.handlers.unmarshalling.UnmarshallingValidationEventHandler;
import net.gratien.test_jms_jrockit.jms.JmsReceiver;

@Configuration
@ComponentScan("net.gratien.test_jms_jrockit")
public class ApplicationContext {

	Logger logger = LoggerFactory.getLogger(ApplicationContext.class);

	/************************************************* JNDI *************************************************/
	@Bean
	public JndiTemplate jndiTemplate() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		Properties jndiProps = new Properties();
		jndiProps.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
		jndiProps.setProperty("java.naming.provider.url", "t3://localhost:7001");
		jndiProps.setProperty("java.naming.security.principal", "weblogic");
		jndiProps.setProperty("java.naming.security.credentials", "weblogic01");
		jndiTemplate.setEnvironment(jndiProps);
		return jndiTemplate;
	}

	/************************************************* JMS *************************************************/
	@Bean
	public ConnectionFactory connectionFactory() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		try {
			jndiObjectFactoryBean.setJndiTemplate(jndiTemplate());
			jndiObjectFactoryBean.setJndiName("jms/TestConnectionFactory");
			jndiObjectFactoryBean.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			logger.error("a jndi name must be defined for the connectionFactory", e);
		} catch (NamingException e) {
			logger.error("the jndi name of the connectionFactory couldn't be resolved", e);
		}
		return (ConnectionFactory) jndiObjectFactoryBean.getObject();
	}

	@Bean
	public Destination queue() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		try {
			jndiObjectFactoryBean.setJndiTemplate(jndiTemplate());
			jndiObjectFactoryBean.setJndiName("jms/TestJMSQueue");
			jndiObjectFactoryBean.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			logger.error("a jndi name must be defined for the queue", e);
		} catch (NamingException e) {
			logger.error("the jndi name of the queue couldn't be resolved", e);
		}
		return (Destination) jndiObjectFactoryBean.getObject();
	}

	@Bean
	public TransactionAwareConnectionFactoryProxy connectionFactoryProxy() {
		return new TransactionAwareConnectionFactoryProxy(connectionFactory());
	}

	@Bean
	public DefaultMessageListenerContainer queueMessageListener() {
		DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
		defaultMessageListenerContainer.setConnectionFactory(connectionFactoryProxy());
		defaultMessageListenerContainer.setDestination(queue());
		MessageListenerAdapter adapter = new MessageListenerAdapter();
		adapter.setDelegate(jmsReceiver());
		adapter.setDefaultListenerMethod("onProductOrServiceDescriptionMessage");
		adapter.setMessageConverter(marshallingMessageConverter());
		defaultMessageListenerContainer.setMessageListener(adapter);
		defaultMessageListenerContainer.setSessionTransacted(true);
		defaultMessageListenerContainer.setErrorHandler(errorHandler());
//		defaultMessageListenerContainer.setConcurrentConsumers(1);
//		defaultMessageListenerContainer.setMaxConcurrentConsumers(4);
		defaultMessageListenerContainer.afterPropertiesSet();
		defaultMessageListenerContainer.start();
		return defaultMessageListenerContainer;
	}

	@Bean
	public JmsErrorHandler errorHandler() {
		return new JmsErrorHandler();
	}

	@Bean
	public JmsReceiver jmsReceiver() {
		return new JmsReceiver();
	}

	/************************************************* JAXB *************************************************/
	@Bean
	public MarshallingMessageConverter marshallingMessageConverter() {
		return new MarshallingMessageConverter(jaxb2Marshaller(), jaxb2Marshaller());
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("net.stratml.productorservicedescription");
		marshaller.setSchema(new ClassPathResource("/ProductOrServiceDescription.xsd"));
		marshaller.setValidationEventHandler(handler());
		return marshaller;
	}

	public UnmarshallingValidationEventHandler handler() {
		return new UnmarshallingValidationEventHandler();
	}
}