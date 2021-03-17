package com.soumyadip;



public class Test {

public static void main(String[] args) {
		
		ChatMediator chatmediator = new ChatMediator();
		IUser b_user = new BasicUser(chatmediator,"Soumyadip basic");
		IUser p_user = new PlatinumUser(chatmediator,"Sukarna platinum");
		
		chatmediator.addUser(p_user);
		chatmediator.addUser(b_user);
		
		b_user.sendMessage();
		p_user.sendMessage();
	}

}
