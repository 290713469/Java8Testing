package com.yrk.concurrent;

import java.util.concurrent.TimeUnit;

public class ShutdownThread {

	public static void main(String[] args) throws Exception {
		Thread thread1 = new Thread(new Runner(), "countThreadOne");
		thread1.start();
		TimeUnit.SECONDS.sleep(1);
		thread1.interrupt();
		
		Runner two = new Runner();
		Thread thread2 = new Thread(two, "countThreadTwo");
		thread2.start();
		TimeUnit.SECONDS.sleep(1);
		two.cancel();
	}
	
	private static class Runner implements Runnable {
		
		private volatile boolean on = true;
		private long i;
		
		@Override
		public void run() {
			while (on && !Thread.currentThread().isInterrupted()) {
				i++;
			}
			System.out.println(i);
		}
		
		public void cancel() {
			this.on = false;
		}
		
	}

}
