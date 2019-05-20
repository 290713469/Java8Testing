package com.yrk.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo {
	
	static Map<String, Object> map = new HashMap<String, Object>();
	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static Lock read = rwl.readLock();
	static Lock write = rwl.writeLock();
	
	public static final Object get(String key) {
		System.out.println("开始读取数据");
		read.lock();
		try {
			return map.get(key);
		} finally {
			read.unlock();
		}
	}
	
	public static final void put(String key, Object obj) {
		System.out.println("开始写入数据");
		write.lock();
		try {
			map.put(key, obj);
		} finally {
			write.unlock();
		}
	}

}
