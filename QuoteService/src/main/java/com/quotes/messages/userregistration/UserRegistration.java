package com.quotes.messages.userregistration;

public class UserRegistration {
	public String name;
	public String password;
	public boolean deliveryMode;
	public int timeToLive;
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegistration(String name, String password, boolean deliveryMode, int timeToLive) {
		super();
		this.name = name;
		this.password = password;
		this.deliveryMode = deliveryMode;
		this.timeToLive = timeToLive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(boolean deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public int getTimeToLive() {
		return timeToLive;
	}
	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	
}
