package com.quotes.consumer;

import java.util.function.Function;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.NamingException;

import com.quotes.jndi.JndiService;


public class UserRegistration {

	private final JndiService jndiService;
	private final String queueName;
	public UserRegistration(JndiService jndiServices, String factoryName, String queueName) throws NamingException{
		this.jndiService = jndiServices;
		this.queueName = queueName;
		jndiServices.startConnections(factoryName);
	}
	public void listen(Function<String, Void> callback){
		try(JMSContext context = jndiService.getConnectionFactory().createContext()){
			try {
				Queue queue = (Queue) jndiService.getInitialContext().lookup(queueName);
			
			
			 JMSConsumer consumer = context.createConsumer(queue);
			 while(true)
			 {
				 String body = consumer.receiveBody(String.class);
				 callback.apply(body);			 }
			
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
}
