import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_Robot {
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement Mob = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		Mob.click();
		driver.findElement(By.xpath("//a[@aria-selected='true']/parent::li")).click();
		driver.findElement(By.xpath("//span[text()='Mobile Accessories']")).click();
		WebElement Power = driver.findElement(By.xpath("//span[text()='Power banks']"));
		Actions ac=new Actions(driver);
		ac.contextClick(Power).build().perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		String hometab = driver.getWindowHandle();
		System.out.println(hometab);
		Set<String> secwindow = driver.getWindowHandles();
		for(String id:secwindow) {
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
		}
		
		
		
	//	System.out.println(secwindow);
		
		
		
		
		
		
	} 

}
