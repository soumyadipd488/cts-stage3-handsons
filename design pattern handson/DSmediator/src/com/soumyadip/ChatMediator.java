package com.soumyadip;

import java.util.ArrayList;

public class ChatMediator implements IChatMediator {
	
	private ArrayList<IUser> users;
	
	public ChatMediator() {
		// TODO Auto-generated constructor stub
		users = new ArrayList<IUser>();
	}

	@Override
	public void addUser(IUser user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		for(IUser user : users)
		{
			user.receiveMessage();
		}
	}

}
