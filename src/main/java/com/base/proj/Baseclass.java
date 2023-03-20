package com.base.proj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	
	public static void userInput(WebElement element,String value) {
		element.sendKeys(value);
	
	}
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
    public static void clearInput(WebElement element) {
    	element.clear();
    }
    public static String printTheValue(WebElement element) {
    	String text = element.getText();
    	return text;
    	}
    public static boolean isSelected(WebElement element) {
    	boolean s = element.isSelected();
    	return s;
    }
    public static boolean isDisplayed(WebElement element) {
    	boolean dis = element.isDisplayed();
    	return dis;
    }
    
    public static boolean isEnabled(WebElement element) {
    	boolean enabled = element.isEnabled();
        return enabled;
    }
    public static  void getAttribute(WebElement element,String value) {
    	String attribute = element.getAttribute(value);
    	System.out.println("The Attribute is "+attribute);
    	
    }
    public static void closeBrowser() {
    	driver.close();
    }
    public static void quitBrowser() {
    	driver.quit();
    }
    
    public static void navigateTo(String url){
    	driver.navigate().to(url);
    }
     public static void navigateBack() {
    	 driver.navigate().back();
    	
    }
     public static String getUrlofPage(){
    	 String currentUrl = driver.getCurrentUrl();
    	 return currentUrl;
     }
     public static String getTitleOfPage() {
    	 String title = driver.getTitle();
    	 return title;
     }
     public static void sleep() throws InterruptedException {
    	 Thread.sleep(3000);
     }
     public static WebDriver browserLaunch(String browser) {
    	 
    	 
    	 if(browser.equalsIgnoreCase("chrome")) {
    		 List<String>l=new ArrayList<>();
    		 l.add("start-maximized");
    		 l.add("incognito");
    		 ChromeOptions options=new ChromeOptions();
    		 options.addArguments(l);
    		 WebDriverManager.chromedriver().setup();
    		 driver=new ChromeDriver();
    	 }else if(browser.equalsIgnoreCase("edge")) {
    		 WebDriverManager.edgedriver().setup();
    		 driver=new EdgeDriver();
    	 }else if(browser.equalsIgnoreCase("gecko")) {
    		 WebDriverManager.firefoxdriver().setup();
    		 driver=new FirefoxDriver();
    	 }else {
    		 System.out.println("Invalid Browser");
    	 }
    	 return driver;
    	 
     }
     public static void getUrl(String url){
    	 driver.get(url);
    	 
     }
     public static void implicitWait() {
    	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     }
     public static void singleDropdown(WebElement element,String value,String mtdtype) {
    	 Select s=new Select(element);
    	 if(mtdtype.equalsIgnoreCase("value")) {
    		 s.selectByValue(value);
    	 }
    	 else if(mtdtype.equalsIgnoreCase("visible")) {
    		 s.selectByVisibleText(value);
    	 }
    	 else if(mtdtype.equalsIgnoreCase("index")) {
    		 int index = Integer.parseInt(value);
    		 s.selectByIndex(index);
    	 }
     }
     
     public static void printScreen(String filename) throws IOException {
    	 TakesScreenshot ts=(TakesScreenshot)driver;
    	 File source = ts.getScreenshotAs(OutputType.FILE);
    	 File dest=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Screenshot\\"+filename+".png");
    	 FileUtils.copyDirectory(source, dest);
     }
    	 
     public static void frameSwitch(WebDriver driver,WebElement element) {
    	
    	 driver.switchTo().frame(element);
    	 
     } 
     
     public static void frameSwitchUsingIndex(WebDriver driver,int index) {
     	
    	 driver.switchTo().frame(index);
     }
     public static void frameSwitchUsingName(WebDriver driver,String name) {
    	 driver.switchTo().frame(name);
    	 
     }
     public static void frameSwitchParentframe(WebDriver driver,int id) {
    	 driver.switchTo().frame(id);
    	 
     }
     
     
     public static String singleWindow() {
    	 String windowHandle = driver.getWindowHandle();
    	 return windowHandle;
     }
     public static Set<String> multipleWindows() {
    	 Set<String> windowHandles = driver.getWindowHandles();
    	 return windowHandles;
     }
     
     public static void popUpOk(WebDriver driver) {
    	 Alert a=driver.switchTo().alert();
    	 a.accept();
     }
     public static void mouseEvents(WebDriver driver,WebElement element,String options) {
    	 Actions a=new Actions(driver);
    	 if(options.equalsIgnoreCase("click")) {
    		 a.click(element).build().perform();
    	 }
    		 else if(options.equalsIgnoreCase("double")) {
    			 a.doubleClick(element).build().perform();
    		 }
    		 else if(options.equalsIgnoreCase("move")) {
    			 a.moveToElement(element).build().perform();
    		 }
    		 else if(options.equalsIgnoreCase("right")) {
    			 a.contextClick(element).build().perform();
    	 }
     }
}
     
    
     
    	 
     
      		 
    			  
     
     
     
     
     

