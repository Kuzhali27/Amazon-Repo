package com.testrunner;




import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import com.base.proj.Baseclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\src\\test\\java\\com\\amazonfeature\\Amazon.feature",
glue="com.amazonstepdefn",dryRun=true,stepNotifications=true,monochrome=true,
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class AmazonRunner {
	
	public static WebDriver driver = null;
	
	@BeforeClass
	
	public static void setUp(){
		
		driver=Baseclass.browserLaunch("chrome");
		
	}
	@AfterClass
	public static void tearDown(){
        driver.quit();
        }
	
	
	
	
	
	

}

