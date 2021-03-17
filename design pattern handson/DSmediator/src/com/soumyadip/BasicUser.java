package com.soumyadip;

public class BasicUser implements IUser {
	
	private String name;
	private ChatMediator chatMediator;
	
	public BasicUser(ChatMediator m, String name)
	{
		this.chatMediator = m;
		this.name = name;
		
	}

	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub
		System.out.println("Message received:"+this.name);
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		chatMediator.sendMessage();
	}

}
