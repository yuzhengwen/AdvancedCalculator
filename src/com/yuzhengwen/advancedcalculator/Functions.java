package com.yuzhengwen.advancedcalculator;

public class Functions {

	public static double add(double x, double y) {
		return x + y;
	}

	public static double minus(double x, double y) {
		return x - y;
	}

	public static double multiply(double x, double y) {
		return x * y;
	}

	public static double divide(double x, double y) {
		return x / y;
	}

	//advanced functions
	
	public static double squareRoot(double x) {
		return Math.sqrt(x);
	}

	public static double cubeRoot(double x) {
		return Math.cbrt(x);
	}

	/** x to the power of y */
	public static double powerOf(double x, double y) {
		return Math.pow(x, y);
	}

}
