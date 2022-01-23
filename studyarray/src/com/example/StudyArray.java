package com.example;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class StudyArray {

	public static void main(String[] args) {
		int x = 42;
		int [] numbers = { 4, 8, 23, 15, 42, 16};
		int [] array;
		array = new int[] {4, 8, 23, 15, 42, 16};
		int[] dizi;
		dizi = new int[6];
		dizi[0] = 4;
		dizi[1] = 8;
		dizi[2] = 23;
		dizi[3] = 15;
		dizi[4] = 42;
		dizi[5] = 16;
		System.err.println(dizi.length);
		
		//loop #1
		int sum = 0;
		for (int i=0; i<dizi.length; ++i) {
			var sayi = dizi[i];
			//dizi[i]++;
			if(sayi % 2 == 1) {
				sum += sayi * sayi;
				}
			}
		System.err.println("sum: "+sum);
	
		//loop #2
		sum =0;
		for (int sayi : dizi) { // sequential + read-only
			if(sayi %2 == 1) {
				sum += sayi * sayi;
				sayi++;
				}
		}
		System.err.println("sum: "+sum);
		
		// loop#3: functional programming (java se 8)
		IntPredicate tekSayilar = n -> n%2 == 1;
		IntUnaryOperator karesine = n -> n*n;
		sum = Arrays.stream(dizi)
			  .parallel()
			  .filter(tekSayilar)
			  .map(karesine)
			  .sum();
		System.err.println("sum: "+sum);
	}
	

}
