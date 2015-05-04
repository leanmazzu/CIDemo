package com.globallogic.cidemo;

/**
 * 
 * @author leandro.mazzuquini
 * 
 */
public class CalcUtil {

	private static CalcUtil INSTANCE;
	
	private CalcUtil() {
		
	}
	
	public static CalcUtil get() {
		if (INSTANCE==null) {
			INSTANCE = new CalcUtil();
		}
		return INSTANCE;
	}
	
	public int add(int value1, int value2) {
		return value1 + value2;
	}

	public int mult(int value1, int value2) {
		return value1 * value2;
	}
}
