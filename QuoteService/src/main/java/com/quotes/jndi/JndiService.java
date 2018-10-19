package com.quotes.jndi;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public interface JndiService {

	public ConnectionFactory getConnectionFactory();
	public InitialContext getInitialContext();
	public boolean startConnections(String connectionFactoryName) throws NamingException;
	public JMSContext getContext();
}
