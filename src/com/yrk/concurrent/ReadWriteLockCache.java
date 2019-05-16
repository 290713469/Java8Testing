package com.yrk.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockCache {
	
	private static Map<String, Object> map = new HashMap<String, Object>();
	private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private static Lock readLock = rwl.readLock();
	private static Lock writeLock = rwl.writeLock();
	
	public static final Object get(String key) {
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public static final Object put(String key, Object obj) {
		writeLock.lock();
		try {
			return map.put(key, obj);
		} finally {
			writeLock.unlock();
		}
	}
	
	public static final void clear() {
		writeLock.lock();
		try {
			map.clear();
		} finally {
			writeLock.unlock();
		}
	}

}
