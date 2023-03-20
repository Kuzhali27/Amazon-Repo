package com.testNg;

import org.testng.annotations.Test;

public class Priority {
	@Test(priority=1)
	public void Laptops() {
		System.out.println("Laptops");
	}
	
	@Test(priority=4)

	public void Mobiles() {
		System.out.println("Mobiles");
	}
    @Test(priority=3)

public void Accessories() {
	System.out.println("Accessories");
    }
	@Test(priority=2)

	public void Fashion() {
		System.out.println("Fashion");
}

}
