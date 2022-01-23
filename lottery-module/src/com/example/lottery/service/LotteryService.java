package com.example.lottery.service;

import java.util.List;
import java.util.stream.IntStream;

public interface LotteryService {
	List<Integer> draw(int max, int size);
	default List<List<Integer>> draw(int max,int size,int column) {
		//functional programming with solved us
		return IntStream.range(0,  column)
		.mapToObj( i -> draw(max, size))
		.toList();
	}
	

}
