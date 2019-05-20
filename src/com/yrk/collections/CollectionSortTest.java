package com.yrk.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CollectionSortTest {

	public static void main(String[] args) {
		List<CollectionSortDto> list = new ArrayList<CollectionSortDto>();
		for (int i = 0; i <40; i++) {
			CollectionSortDto dto = new CollectionSortDto();
			if (i%2 == 0) {
				dto.setStartDate(new Date());
			}
			dto.setTest("test" + i);
			list.add(dto);
		}
		Collections.sort(list);
		System.out.println("complete");
	}

}
