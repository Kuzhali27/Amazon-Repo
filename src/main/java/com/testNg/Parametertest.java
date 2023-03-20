package com.testNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametertest {
	
	@Parameters({"user1","user2"})
	@Test
	public void Method1(String username,String username2) {
		System.out.println("Username is : "+username);
		System.out.println("Username is : "+username2);
	}
	@Parameters({"pass1","pass2"})
	@Test
	public void Method2(String password,String passw) {
		System.out.println("Password is : "+password);
		System.out.println("Password is : "+passw);
	}

}
