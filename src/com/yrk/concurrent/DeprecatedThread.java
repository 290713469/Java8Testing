package com.yrk.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DeprecatedThread {

	public static void main(String[] args) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Thread printThread = new Thread(new Runner(), "printThread");
		printThread.setDaemon(true);
		printThread.start();
		TimeUnit.SECONDS.sleep(3);
		printThread.suspend();
		System.out.println("main suspend PrintThread at " + dateFormat.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		printThread.resume();
		System.out.println("main resume PrintThread at " + dateFormat.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		printThread.stop();
		System.out.println("main stop PrintThread at " + dateFormat.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
	}
	
	static class Runner implements Runnable {

		@Override
		public void run() {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			while (true) {
				System.out.println(Thread.currentThread().getName() + " Run at " +
						dateFormat.format(new Date()));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
