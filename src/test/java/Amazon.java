import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		List<String>l=new ArrayList<String>();
		l.add("incognito");
		l.add("start-maximized");
		ChromeOptions options=new ChromeOptions();
		options.addArguments(l);
			
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Driver1\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String expected="Music";
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select s=new Select(dropdown);
		List<WebElement> option = s.getOptions();
		ListIterator<WebElement> li = option.listIterator();
		while(li.hasNext()) {
			WebElement next = li.next();
			String actual=next.getText();
			if(expected.equalsIgnoreCase(actual)) {
				s.selectByVisibleText(expected);
				break;
			}
			
		}
		String searchvalue="cd";
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(searchvalue);
		Thread.sleep(3000);
		
		List<WebElement> searchoptions = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div"));
		
		for(int i=1;i<=searchoptions.size();i++) {
			WebElement each = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div["+i+"]/div/div"));
			String text = each.getText();
			if(searchvalue.equalsIgnoreCase(text)) {
				each.click();
				break;
			}
		}
		Thread.sleep(3000);
		WebElement findtext = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
		String producttext = findtext.getText();
		System.out.println(producttext); 
		findtext.click();
		//WebElement findtext1 = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
		//findtext1.click();
		
		
		String hometab = driver.getWindowHandle();
		Set<String> multiple = driver.getWindowHandles();

		for(String each:multiple) {
			
			 if(!hometab.equals(each)) {
				 driver.switchTo().window(each);
				 break;
				 
			 }
		}
		
	             WebElement selectedprod = driver.findElement(By.id("productTitle"));
	             String selectedProdtext = selectedprod.getText();
	            System.out.println(selectedProdtext);
	              
	             
	             if(producttext.equals(selectedProdtext)) {
	     			
	     			WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
	     			addtocart.click();
	             }
	             
	             TakesScreenshot ts=(TakesScreenshot)driver;
	             File source= ts.getScreenshotAs(OutputType.FILE);
	             
	             File des=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Screenshot\\addtocart.png");
	             FileUtils.copyFile(source, des);
	             
	             WebElement goToCart = driver.findElement(By.xpath("(//a[@class='a-button-text'])[3]"));
	             goToCart.click();
	             
	             WebElement shoppingcart = driver.findElement(By.xpath("//span[@class='a-list-item']/a/span/span"));
	             String shopping = shoppingcart.getText();
	             System.out.println(shopping);
	             if(selectedProdtext.contains(shopping)) {
	            	 driver.close();
	             }
	             Thread.sleep(3000);
	             driver.quit();
	             }
	             
		}

		
	

			 
		
	
			
		
		
		
		
				
				
			
		
		
		
		
		
		
	
	


