package com.yrk.singleton;

public class Singleton1 {
	
	//lazy mode
	private static Singleton1 instance;
	
	private Singleton1() {
		
	}
	
	public static synchronized Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
