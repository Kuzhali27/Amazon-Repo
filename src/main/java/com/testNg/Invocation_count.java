package com.testNg;

import org.testng.annotations.Test;

public class Invocation_count {
	@Test(invocationCount=5)
	public void Laptops() {
		System.out.println("Laptops");
	}
	
	@Test

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
