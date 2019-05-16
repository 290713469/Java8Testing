package com.yrk.concurrent;

public class TestSynchronized {

	public static void main(String[] args) {
		synchronized(TestSynchronized.class) {
			test();
		}
	}
	
	private static void test() {
		
	}

}
