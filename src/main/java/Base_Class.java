import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Driver1\\chromedriver 1.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Driver1\\chromedriver 1.exe");
			driver=new FirefoxDriver();
			
		}
		else
		{
			System.out.println("Invalid browser");
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	public static void launchUrl(String URL) {
		driver.get(URL);

	}
		
	public static void sendValues(WebElement element,String values) {
		element.sendKeys(values);
	}
	public static void clickonElement(WebElement element) {
		element.click();
	}
	public static void navigationTo(String URL) {
		driver.navigate().to(URL);
	}
	public static void getAttribute(WebElement element,String values) {
		element.getAttribute(values);

	}
	public static void isDisplayed(WebElement element) {
		
boolean displayed = element.isDisplayed();
System.out.println("is displayed" +displayed);
	}
		

	
	public static void printScreen(String filename) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Screenshot\\"+filename+".png");
		FileUtils.copyFile(source,destination);
	}
	public static void closeBrowser() {
		driver.close();
	}
		public static void quitBrowser() {
			driver.quit();	
	}

	}


