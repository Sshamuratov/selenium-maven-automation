package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	
	@Test
	public void testOne() {
		System.out.println("First asserting");
		Assert.assertTrue(false);
		System.out.println("done asserting");
	}
	
	@Test
	public void testTwo() {
		System.out.println("First second");
		Assert.assertTrue(true);
		System.out.println("done asserting");
	}

}
