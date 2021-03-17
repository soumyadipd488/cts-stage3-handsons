package com.soumyadip;

public class MessageSubscriberThree implements Observer

{

	@Override

	public void update(Message m) {

		System.out.println("MessageSubscriberThree :: " + m.getMessageContent());

	}
	@Override
	public void statemsg(Message m) {
		
		System.out.println("MessageSubscriberTwo :: " + m.getStateMsg());
		
	}
}