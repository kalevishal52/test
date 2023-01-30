package com.practice;

public class Demo {

	public Demo() {
		System.out.println("Inside constuructor");
	}
	
	static {
		System.out.println("Inside static block");
	}
	
	{
		System.out.println("Inside non static block");
	}
	
	public static void staticMethod() {
		System.out.println("INside static Method...");
	}
	
	public void fun() {
		System.out.println("Inside non-static method of fun");
	}
	
	public static void main(String[] args) {
		
		System.out.println("INside main method of DEMO");
		
		Demo d = new Demo();
		d.fun();
	
	}
}
