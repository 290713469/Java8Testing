package com.yrk.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicDemo {
	
	private static int count = 0;
	
	static Lock lock = new ReentrantLock();
	
	public static void incr() {
		lock.lock();
		
		try {
			Thread.sleep(1);
			count++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {AtomicDemo.incr();}).start();
		}
		Thread.sleep(3000);
		System.out.println(count);
	}

}
