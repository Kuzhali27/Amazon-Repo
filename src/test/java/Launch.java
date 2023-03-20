
	
	import java.io.IOException;

	
	import org.openqa.selenium.By;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	

	public class Launch extends Base_Class{
		public static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {
			driver=browserLaunch("chrome");
			launchUrl("https://www.facebook.com/login/");
			WebElement email = driver.findElement(By.id("email"));
			sendValues(email,"kuzhali2714@gmail.com");
			WebElement pwd = driver.findElement(By.id("pass"));
			sendValues(pwd,"123456");
			
			WebElement login = driver.findElement(By.id("loginbutton"));
			clickonElement(login);
		
			Thread.sleep(3000);
		navigationTo("https://letcode.in/edit");
		
			
		WebElement attribute = driver.findElement(By.id("getMe"));
			getAttribute(attribute, "values");
			
			WebElement disp = driver.findElement(By.id("noEdit"));
			disp.isDisplayed();
			System.out.println("is displayed: ");
		//	printScreen("fb1");
		//closeBrowser();
			
		//quitBrowser();
			
			System.out.println("COMPLETED THE TASK");
			
			
			
		}
		
		}


