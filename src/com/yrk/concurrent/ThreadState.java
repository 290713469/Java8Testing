package com.yrk.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadState {

	public static void main(String[] args) {
		new Thread(() ->  {
			while(true) {
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "TimeWaitingThread").start();
		
		new Thread(new Waiting(), "WaitingThread").start();
		new Thread(new Blocked(), "BlockedThread - 1").start();
		new Thread(new Blocked(), "BlockedThread - 2").start();
	}
	
	static class Waiting implements Runnable {

		@Override
		public void run() {
			while(true) {
				synchronized(Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	static class Blocked implements Runnable {
		@Override
		public void run() {
			synchronized (Blocked.class) {
				while(true) {
					try {
						TimeUnit.SECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
