package com.testNg;

import org.testng.annotations.Test;

public class DependsonMthds {
	@Test
	public void Laptops() {
		//int a[]= {1,2,3,4,5};
		//System.out.println(a);
		System.out.println("Laptops");
	}
	
	@Test

	public void Mobiles() {
		System.out.println("Mobiles");
	}
    @Test(dependsOnMethods="Mobiles")

public void Accessories() {
	System.out.println("Accessories");
    }
	@Test(dependsOnMethods="Accessories")

	public void Fashion() {
		System.out.println("Fashion");

}
}



