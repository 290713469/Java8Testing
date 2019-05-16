package com.yrk.concurrent;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {

	public volatile static boolean stop = false;
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			int i = 0;
			while (!stop) {
				i++;
			}
		}, "VolatileDemoThread") ;
		thread.start();
		System.out.println("start Thread");
		TimeUnit.SECONDS.sleep(1);
		stop = true;
	}

}
