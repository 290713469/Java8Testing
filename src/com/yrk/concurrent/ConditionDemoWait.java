package com.yrk.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoWait implements Runnable {
	
	private Lock lock;
	private Condition condition;
	
	

	public ConditionDemoWait(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}



	@Override
	public void run() {
		System.out.println("begin ConditionDemoWait");
		try {
			lock.lock();
			condition.await();
			System.out.println("end ConditionDemoWait");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
