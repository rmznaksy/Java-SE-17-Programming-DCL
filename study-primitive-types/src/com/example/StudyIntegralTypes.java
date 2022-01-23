package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {
	public static void main(String[] args) {
		//Integral types all are signed integers!
		byte b = 1; //1-Byte, [-128..127]
		b = 127;
		b++; // CPU -> ALU
		// 0111 1111 -> +1
		// 0000 0001 -> +1
		// 1000 0000 -> -128
		//0111 1111 + 0000 0001 = 128
		b = -128;
		b--;
		System.err.println("b: "+b);
		short s = 2; // 2-Byte, [-32768..32]
		s = Short.MAX_VALUE;
		System.err.println("s: "+s);
		s++;
		System.err.println("s: "+s);
		
		int i = 42; // 4-Byte [-2147483648..2147483647]
		System.err.println("i: "+i);
		i+=2;
		System.err.println("i: "+i);
		
		long l = 42;
		l = Long.MAX_VALUE;
		System.err.println("l: "+l);
		l++;
		System.err.println("l: "+l);
		// Immutable ->
		
		// 
		BigInteger bi = BigInteger.valueOf(9223372036854775807L);
		System.err.println("bi: "+bi);
		bi = bi.add(BigInteger.ONE);
		System.err.println("bi: "+bi);
		byte x = 3, y = 5, z;
		z = (byte)(x + y); // + -> int -> 4-byte -> 1-byte
		System.err.println("z: "+z);
		long m ;
		m = (long)(Integer.MAX_VALUE + 1L);
		System.err.println("m: "+m);
		
	}

}
