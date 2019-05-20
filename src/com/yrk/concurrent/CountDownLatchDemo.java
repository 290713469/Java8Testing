package com.yrk.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo extends Thread {

	static CountDownLatch countDownLatch = new CountDownLatch(1);
	
	@Override
	public void run() {
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread:" + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			new CountDownLatchDemo().start();
		}
		System.out.println("所有线程阻塞中........");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("线程阻塞开关打开");
		countDownLatch.countDown();
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		CountDownLatch countDownLatch = new CountDownLatch(3);
//		new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + " - 执行中");
//			countDownLatch.countDown();
//			System.out.println(Thread.currentThread().getName() + "- 执行完毕");
//		}, "t1").start();
//		new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + " - 执行中");
//			countDownLatch.countDown();
//			System.out.println(Thread.currentThread().getName() + "- 执行完毕");
//		}, "t2").start();
//		new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + " - 执行中");
//			countDownLatch.countDown();
//			System.out.println(Thread.currentThread().getName() + "- 执行完毕");
//		}, "t3").start();
//		
//		countDownLatch.await();
//		System.out.println("所有线程执行完毕");
//	}

}
