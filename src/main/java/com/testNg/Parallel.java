package com.testNg;

import org.testng.annotations.Test;

public class Parallel {
	@Test
	public void Laptops() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Laptops");
	}
	
	@Test

	public void Mobiles() throws InterruptedException {
		Thread.sleep(2000);
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
