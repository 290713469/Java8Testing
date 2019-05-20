package com.yrk.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		new Thread(new ConditionDemoWait(lock, condition)).start();
		TimeUnit.SECONDS.sleep(2);
		new Thread(new ConditionDemoNotify(lock, condition)).start();
	}

}
