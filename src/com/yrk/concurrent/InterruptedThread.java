package com.yrk.concurrent;

import java.util.concurrent.TimeUnit;

public class InterruptedThread {

	public static void main(String[] args) throws Exception {
		Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
		Thread busyThread = new Thread(new BusyRunner(), "SleepThread");
		sleepThread.setDaemon(true);
		busyThread.setDaemon(true);
		busyThread.start();
		sleepThread.start();
		
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
		System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
	}
	
	static class SleepRunner implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static class BusyRunner implements Runnable {

		@Override
		public void run() {
			while (true) {
				
			}
		}
		
	}

}
