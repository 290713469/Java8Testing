package com.yrk.singleton;

public class Singleton {

	//Inner Class
	private Singleton() {
		
	}
	
	public static final Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
}
