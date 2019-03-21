package com.yrk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter5 {

	public static void main(String[] args) {
//		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
//		List<String> test = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
//		
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950)); 
		System.out.println("result 1:");
		transactions.stream().filter(i -> i.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList()).forEach(t -> System.out.println(t));
		
		System.out.println("result 2:");
		transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(d -> System.out.println(d));
		
		System.out.println("result 3:");
		transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
		.map(t -> t.getTrader()).distinct().sorted(Comparator.comparing(Trader::getName)).forEach(t -> System.out.println(t.getName()));;
		
		
		System.out.println("result 4:");
		String names = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().distinct().reduce("", (a, b) -> a + b);
		System.out.println(names);
		
		System.out.println("result 5:");
		System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
		
		System.out.println("result 6:");
		System.out.println(transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(0, (a, b) -> a + b));
		
		
		IntStream.rangeClosed(0, 10).forEach(a -> System.out.println(a));
		
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10).map(t -> t[0]).forEach(t -> System.out.print(t));
		
//		
//		System.out.println("result 2:");
//		transactions.stream().map(i -> i.getTrader().getCity()).distinct().forEach(t -> System.out.println(t));
//		
//		System.out.println("result 3:");
//		transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
//		.map(t -> t.getTrader()).distinct().sorted(Comparator.comparing(Trader::getName)).forEach(t -> System.out.println(t.getName()));
//		
//		System.out.println("result 4:");
//		String traderStr = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
//		System.out.println(traderStr);
//		
//		System.out.println("result 5:");
//		System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan")));
//		
//		System.out.println("result 6:");
//		transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(Transaction::getValue).forEach(t -> System.out.println(t));
//		
//		System.out.println("result 7:");
//		System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max));
		
	}

}
