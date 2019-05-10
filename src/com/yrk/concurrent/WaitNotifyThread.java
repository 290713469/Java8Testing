package com.yrk.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotifyThread {
	
	private static boolean flag = true;
	private static Object lock = new Object();

	public static void main(String[] args) throws Exception {
		Thread waitThread = new Thread(new Wait(), "waitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(5);
		
		Thread notifyThread = new Thread(new Notify(), "notifyThread");
		notifyThread.start();
	}
	
	private static class Wait implements Runnable {

		@Override
		public void run() {
			synchronized (lock) {
				while (flag) {
					try {
						System.out.println(Thread.currentThread().getName() + " flag is true :" 
								+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " flag is false :" 
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}
	
	private static class Notify implements Runnable {

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " hold lock, notify @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " hold lock again, sleep @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
