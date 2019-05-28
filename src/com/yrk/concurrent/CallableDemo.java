package com.yrk.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "Hello";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableDemo callableDemo = new CallableDemo();
		FutureTask futureTask = new FutureTask(callableDemo);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}

}
