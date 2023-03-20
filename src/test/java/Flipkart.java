import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		/*
		 * WebElement home = driver.findElement(By.xpath(
		 * "/html/body/div/div/div[2]/div/div/div[5]/a/div[2]/div/div")); Actions ac=new
		 * Actions(driver); ac.moveToElement(home).build().perform(); WebElement blanket
		 * = driver.findElement(By.xpath("//a[text()='Blankets']")); blanket.click();
		 */
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//div[text()='₹65,999'])[1]/ancestor::div[@class='_3pLy-c row']//div[contains (text(),'APPLE')]")).click();
		Thread.sleep(2000);
		String home = driver.getWindowHandle();
		Set<String> each = driver.getWindowHandles();
		for(String ne: each) {
			
			if(!home.equalsIgnoreCase(ne)) {
				driver.switchTo().window(ne);
				
			}
			
		}
		
	}
	
	
	
	

}
