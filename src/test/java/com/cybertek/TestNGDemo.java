package com.cybertek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	@BeforeClass
	public void tearUpMethod() {
		System.out.println("runs once before anything");
	}
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("runs before every method");
	}
	
	@Test
	public void testOne() {
		System.out.println("First one");
	}
	
	@Test
	public void testSecond() {
		System.out.println("Second one");
	}
	
	
	@AfterMethod
	public void terDownMethod() {
		System.out.println("runs after every method");
	}
	
	@AfterClass
	public void tearDownClass() {
		System.out.println("runs once after everything");
	}

}
