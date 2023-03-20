package com.testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderexample {
@Test(dataProvider="data1")
public void method1(String name,String password) {
	System.out.println("Username is "+ name);
	System.out.println("Password is "+ password);
}
@DataProvider(name="data1")
public Object[][] test1() {
	return new Object[][]
			{
		{"abc","123"},{"def","456"},{"sju","498"}
			};
}
}
