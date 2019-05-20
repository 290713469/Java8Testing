package com.yrk;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

//	public static void main(String[] args) {
//		int aHundredMillion = 1000000;
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		
//		long s1 = System.currentTimeMillis();
//		for (int i=0; i < aHundredMillion; i++) {
//			map.put(i, i);
//		}
//		long s2 = System.currentTimeMillis();
//		System.out.println("未初始化容量，耗时：" + (s2 - s1));
//				
//		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>(aHundredMillion/2);
//		
//		long s3 = System.currentTimeMillis();
//		for (int i=0; i < aHundredMillion; i++) {
//			map1.put(i, i);
//		}
//		long s4 = System.currentTimeMillis();
//		System.out.println("初始化容量500000，耗时：" + (s4 - s3));
//		
//		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(aHundredMillion);
//		
//		long s5 = System.currentTimeMillis();
//		for (int i=0; i < aHundredMillion; i++) {
//			map2.put(i, i);
//		}
//		long s6 = System.currentTimeMillis();
//		System.out.println("初始化容量1000000，耗时：" + (s6 - s5));
//	}
	
	public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<String, String>(3);
		Class<?> mapType = map.getClass();
		try {
			Method capacity = mapType.getDeclaredMethod("capacity");
			capacity.setAccessible(true);
			System.out.println("capacity : " + capacity.invoke(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
