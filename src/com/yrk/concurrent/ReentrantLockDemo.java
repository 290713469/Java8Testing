package com.yrk.concurrent;

public class ReentrantLockDemo {
	
	public synchronized void demo() {
		System.out.println("begin demo");
		demo2();
	}
	
	public void demo2() {
		System.out.println("begin demo1");
		synchronized (this) {
			
		}
	}

	public static void main(String[] args) {
		ReentrantLockDemo rl = new ReentrantLockDemo();
		new Thread(rl::demo).start();
	}

}
