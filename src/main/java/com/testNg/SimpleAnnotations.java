package com.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotations {
	@BeforeSuite
	public void setup() {
		System.out.println("System Set Property");
	}
	@BeforeTest
	public void browserlaunch() {
		System.out.println("Browser launching");
	}
	@BeforeClass
		public void url() {
			System.out.println("Url Launch-Amazon");
		}
	@BeforeMethod
		public void login() {
			System.out.println("Login");
		}
	@Test
		public void searchlaptop() {
			System.out.println("HP Laptop");
		}
	@Test
			public void searchmobile() {
				System.out.println("IPHONE 13");
			}
	@AfterMethod
		public void verify() {
			System.out.println("Verification");
		}
	@AfterClass
		public void logout() {
			System.out.println("logout");
		}
	@AfterTest
		public void closeBrowser() {
			System.out.println("Close the browser");
		}
	@AfterSuite
		public void deletecookies() {
			System.out.println("Delete cookies");
			
			
		}
	}
	


