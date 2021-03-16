package com.singleton;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConn instance1 = DBConn.getInstance();
		DBConn instance2 = DBConn.getInstance();
		System.out.println(instance1.hashCode()==instance2.hashCode());

	}

}
