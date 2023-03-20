import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra_Automation {
	
	
	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.xpath("(//a[text()='Kids'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(search).build().perform();
		a.click();
		
		driver.findElement(By.xpath("(//a[text()='T-Shirts'])[2]")).click();
		
		List<WebElement> product1 = driver.findElements(By.xpath("//ul[@class='results-base']"));
		for(WebElement pro: product1) {
			System.out.println(pro.isDisplayed());
			//System.out.println(pro.getText());
			
			
			//System.out.println(pro.getSize());
		}
		
		List<WebElement> product = driver.findElements(By.xpath("//ul[@class='results-base']/li[1]"));
		for(WebElement prod: product) {
			System.out.println(prod.getText());
			System.out.println(prod.getSize());
			
		}
	}
}
		
		
	


