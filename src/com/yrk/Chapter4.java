package com.yrk;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Chapter4 {

	public static void main(String[] args) {
		List<Dish> menu = MenuUtil.getMenu();
//		List<String> lowCaloricDishName = menu.stream().filter(a -> a.getCalories() < 400)
//				.sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
//		lowCaloricDishName.forEach(a -> System.out.println(a));
//		
//		System.out.println("=================");
//		Map<Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
//		dishesByType.forEach((a, b) -> {
//			System.out.println("Dish Type: " + a.name());
//			b.forEach(c -> System.out.println(c.getName()));
//			System.out.println("=================");
//		});
//		
//		List<String> highCaloricDishName = menu.stream().filter(a -> a.getCalories() > 300).limit(3).map(Dish::getName).collect(Collectors.toList());
//		System.out.println(highCaloricDishName);
		List<Integer> dishNameLength = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
		menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
		int count = menu.stream().map(d -> 1).reduce(0, (a, b) -> a+b);
		System.out.println("total number: " + count);
	}
}
