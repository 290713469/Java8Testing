package com.yrk.concurrent;

import java.util.concurrent.TimeUnit;

public class InterruptedDemo {

	private static int i;
	
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(() ->  {
			while (true) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("before interrputed(): " + Thread.currentThread().isInterrupted());
					Thread.currentThread().interrupted();
					System.out.println("after interrputed(): " + Thread.currentThread().isInterrupted());
				}
			}
		}, "interruptedThread");
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}
	
//	public static void main(String[] args) throws Exception {
//		Thread thread = new Thread(() ->  {
//			while (!Thread.currentThread().isInterrupted()) {
//				i++;
//			}
//		}, "interruptedThread");
//		thread.start();
//		TimeUnit.SECONDS.sleep(1);
//		thread.interrupt();
//	}
}
