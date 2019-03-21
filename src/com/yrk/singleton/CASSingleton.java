package com.yrk.singleton;

import java.util.concurrent.atomic.AtomicReference;

public class CASSingleton {

	private static final AtomicReference<CASSingleton> instance = new AtomicReference<CASSingleton>();
	
	private CASSingleton() {
		
	}
	
	public static CASSingleton getInstance() {
		for (;;) {
			CASSingleton single = instance.get();
			if (single != null) {
				return single;
			}
			single = new CASSingleton();
			if (instance.compareAndSet(null, single)) {
				return single;
			}
		}
	}
}
