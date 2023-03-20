package com.testNg;

import org.testng.annotations.Test;

public class Expected_Exceptions {
	@Test(expectedExceptions=ArithmeticException.class)
	public void  aLaptops() {
		int a=5/0;
		System.out.println("Laptops");
	}
	
	@Test

	public void Mobiles() {
		System.out.println("Mobiles");
	}
    

}




