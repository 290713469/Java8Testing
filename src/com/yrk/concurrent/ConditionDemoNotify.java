package com.yrk.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoNotify implements Runnable {

	private Lock lock;
	private Condition condition;
	
	public ConditionDemoNotify(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		System.out.println("begin ConditionDemoNotify");
		try {
			lock.lock();
			condition.signal();
			System.out.println("end ConditionDemoNotify");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
