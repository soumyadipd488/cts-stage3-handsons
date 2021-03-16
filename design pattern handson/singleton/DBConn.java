package com.singleton;

public class DBConn {
	
	private static DBConn instance;
	
	static {
		instance = new DBConn();
	}
	
	private DBConn() {
		
	}
	
	public static DBConn getInstance()
	{
		return instance;
	}

}
