package com.yrk.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadPool {
	
	private static ThreadPool threadPool = new ThreadPool();
	private static List<Thread> initPools;
	
	static {
		initPools = new ArrayList<Thread>(1);
	}
	
	public static ThreadPool getInstance() {
		return threadPool;
	}
	
	public void init(int threadNum) {
		System.out.println("thread pool initializing....");
		IntStream.rangeClosed(1, threadNum).forEach(a -> {
			Thread t = new Thread("thread - " + a);
			initPools.add(t);
			t.start();
		});
	}

}
