package com.capgemini;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {

	public static void main(String[] args) {

		ConnectionFactory connectionFactory = null;
		Queue queue = null;
		InitialContext initialContext;
		try {
			initialContext = new InitialContext();
			queue = (Queue) initialContext.lookup("jms/P2PQueue");
			connectionFactory = (ConnectionFactory) InitialContext.doLookup("jms/__defaultConnectionFactory");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		

		try (JMSContext context = connectionFactory.createContext()) {

			TextMessage message = context.createTextMessage("Hello....");
			//System.out.println(message.getText());
			System.out.println("message sent");
			context.createProducer().send(queue, message);
		}
	}

}
