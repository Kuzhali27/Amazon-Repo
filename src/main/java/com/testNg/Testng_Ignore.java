package com.testNg;

import org.testng.annotations.Test;

import org.testng.annotations.Ignore;

public class Testng_Ignore {
	@Ignore
	@Test
	
	public void Laptops() {
		System.out.println("Laptops");
	}
	
	@Test(enabled=false)

	public void Mobiles() {
		System.out.println("Mobiles");
	}
    @Test

public void Accessories() {
	System.out.println("Accessories");
    }
	@Test

	public void Fashion() {
		System.out.println("Fashion");
}
}
