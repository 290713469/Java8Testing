package com.yrk;

import java.util.Arrays;
import java.util.List;

public class Java8NewFeatures {

	public static void main(String[] args) {
		lambda();
	}
	
	private static void lambda() {
//		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
//		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));
//		Arrays.asList("a", "b", "c").forEach(e -> {
//			System.out.println(e);
//			System.out.println(e);
//		});
		
//		String separate = ",";
//		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e + separate));
//		Arrays.asList("a", "b", "c").sort((e1, e2) -> e1.compareTo(e2));
//		List<String> str = Arrays.asList("a", "c", "b");
//		str.sort(String::compareToIgnoreCase);
//		str.forEach((String a) -> System.out.println(a));
		List<Apple> inventory = Arrays.asList(new Apple(32, "color", "c"), new Apple(2, "yellow", "d"), new Apple(3, "red", "t"));
		inventory.forEach(s -> {
			System.out.println(s.getWeight());
		});
		//		inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
//		inventory.forEach((Apple a) -> System.out.println(a.getWeight()));
		
//		String inputFilePath = "E:\\WAS_apps\\mdms\\input\\input-test2.txt";
//		String outFilePath = "E:\\WAS_apps\\mdms\\input\\input-test3.txt";
//		
//		if(Files.exists(Paths.get(outFilePath))) {
//            try {
//                Files.createFile(Paths.get(outFilePath));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//		try {
//            BufferedWriter bfw=Files.newBufferedWriter(Paths.get(outFilePath));
//            
//            Stream<String> lines = Files.lines(Paths.get(inputFilePath), Charset.defaultCharset());
//            lines.forEach((String line) -> {
//            	try {
//					bfw.write(line);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//            });
//            bfw.flush();
//            bfw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
//		Runnable r1 = () -> System.out.println("Hello world 1");
//		process(r1);
//		process(() -> System.out.println("Hello world 2"));
		
//		String test = "ttest";
//		char[] t = test.toCharArray();
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < t.length; i++) {
//			t[i] = (char) (t[i] - 32);
//		}
//		System.out.println(String.valueOf(t));
//		int n = 0b00000101;
//		System.out.println(Integer.toBinaryString(n));
//		int n1 = n >>>1;//00000010
//		System.out.println(Integer.toBinaryString(n1));
//		n |= n1;
//		System.out.println(Integer.toBinaryString(n));
		// 00000101
		// 00000010
		// 00000111
	}
	
	public static void process(Runnable r) {
		r.run();
	}

}
