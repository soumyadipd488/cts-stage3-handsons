package com.soumyadip;

public class PlatinumUser implements IUser {
	
	private String name;
	private ChatMediator chatMediator;
	
	public PlatinumUser(ChatMediator m, String name) {
		// TODO Auto-generated constructor stub
		this.chatMediator = m;
		this.name =name;
	}

	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub
		System.out.println("message Received:" + this.name);

	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		chatMediator.sendMessage();
	}

}
