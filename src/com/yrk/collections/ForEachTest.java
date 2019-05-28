package com.yrk.collections;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

public class ForEachTest {

//	public static void main(String[] args) {
//		List<String> userNames = Arrays.asList(new String[] {"小明", "小紅", "小张"});
//		System.out.println("使用for循环遍历");
//		for (int i = 0; i < userNames.size(); i++) {
//			System.out.println(userNames.get(i));
//		}
//		
//		System.out.println("使用foreach循环遍历");
//		for (String name : userNames) {
//			System.out.println(name);
//		}
//	}
	
//	public static void main(String[] args) {
//		List<String> userNames = new ArrayList<String>();
//		userNames.add("Tom");
//		userNames.add("Jack");
//		userNames.add("Mic");
//		for (int i = 0; i < userNames.size(); i++) {
//			if (userNames.get(i).equals("Jack")) {
//				userNames.remove(i);
//			}
//		}
//		System.out.println(userNames);
//	}
//	public static void main(String[] args) {
//		ArrayList arraylist = new ArrayList();
//        arraylist.add("Tom");
//        arraylist.add("Jack");
//        arraylist.add("Mic");
//		arraylist.add("Seven");
//        Iterator iterator = arraylist.iterator();
//        do
//        {
//            if(!iterator.hasNext())
//                break;
//            String s = (String)iterator.next();
//            if(s.equals("Jack"))
//                arraylist.remove(s);
//        } while(true);
//        System.out.println(arraylist);
//    }
	
//	public static void main(String[] args) {
//		List<String> userNames = new ArrayList<String>();
//		userNames.add("Tom");
//		userNames.add("Jack");
//		userNames.add("Mic");
//		userNames.add("Seven");
//		userNames = userNames.stream().filter(userName -> !userName.equalsIgnoreCase("Jack")).collect(Collectors.toList());
//		System.out.println(userNames);
//	}
	public static void main(String[] args) {
		int sshift = 0;
		int concurrentLevel = 16;
		int ssize = 1;
		while (ssize < concurrentLevel) {
			++sshift;
			ssize <<=1;
		}
		
		System.out.println(sshift);
		
//		ConcurrentLinkedDeque<String> userNames = new ConcurrentLinkedDeque<String>();
//		userNames.add("Tom");
//		userNames.add("Jack");
//		userNames.add("Mic");
//		userNames.add("Seven");
//		for (String userName : userNames) {
//			if (userName.equals("Jack")) {
//				userNames.remove(userName);
//			}
//		}
//		System.out.println(userNames);
	}
	
}
