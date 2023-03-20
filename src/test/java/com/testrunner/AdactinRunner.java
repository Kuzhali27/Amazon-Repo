package com.testrunner;

 import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(features="src\\test\\java\\com\\feature",glue="com.stepdefinition",plugin= {"pretty",
"html:Report/Cucumber_Report","json:Report/Cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:Report/Cucumber_Extent_Report.html"},monochrome=true,
dryRun=false,tags="@smoketest1,@smoketest2")
public class AdactinRunner {
	public static WebDriver driver;
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Driver1\\chromedriver 1.exe");
		driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public static void tearDown() {
driver.close();
	
		
	}
	
	

}
