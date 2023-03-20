package com.testNg;

import org.testng.annotations.Test;

public class Timeout {
	@Test(timeOut=1000)
	public void Laptops() {
		System.out.println("Laptops");
	}
	
	@Test

	public void Mobiles() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Mobiles");
	}
    @Test

public void Accessories() {
	System.out.println("Accessories");
    }
	
}



