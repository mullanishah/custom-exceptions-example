package com.core.utils;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StringUtils {
	
	private static SimpleDateFormat sdf = null;
	private static Scanner scanner = null;
	
	static {
		scanner = new Scanner(System.in); 
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static Scanner getScanner() {
		return scanner;
	}
	
	public static void printLine() {
		System.out.println("==================================");
	}
	
}
