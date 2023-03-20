import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Testng {
	
	WebDriver driver=null;
	String producttext=null;
	String selectedProdtext=null; 
	
	@BeforeTest
	public void launch(){
		List<String>l=new ArrayList<String>();
		l.add("incognito");
		l.add("start-maximized");
		ChromeOptions options=new ChromeOptions();
		options.addArguments(l);
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Driver1\\chromedriver.exe");
		 driver=new ChromeDriver(options);
		
		
	}
	

	@BeforeClass
	public void launchUrl() {
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
	

	
	
	@Test(priority=1)
	@Parameters("dropdownvalue")
	public void dropDown(String dropdownvalue){
		String expected="dropdownvalue";
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
	}
	@Test(dependsOnMethods="dropDown")
	public void searchBox() throws InterruptedException{
		
	
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
	}
	
	@Test(priority=3)
	public void selectProduct(){
		WebElement findtext = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
		 producttext = findtext.getText();
		System.out.println(producttext);
		WebElement findtext1 = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
		findtext1.click();
	}
	
	@Test	(priority=4)
	public void windowSwitch(){	
	String hometab = driver.getWindowHandle();
		Set<String> multiple = driver.getWindowHandles();

		for(String each:multiple) {
			
			 if(!hometab.equals(each)) {
				 driver.switchTo().window(each);
				 break;
				 
			 }
		
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(priority=5,expectedExceptions=NoSuchElementException.class,groups="alpha")
	public void producCompare() throws IOException, InterruptedException{
	
		WebElement selectedprod = driver.findElement(By.xpath("//span[@id='productTitle']"));
         selectedProdtext = selectedprod.getText();
       // System.out.println(selectedProdtext);
         
        
        if(producttext.equals(selectedProdtext)) {
			
			WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
			addtocart.click();
        }
        
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        
        File des=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Screenshot\\addtocart.png");
        FileUtils.copyFile(source, des);
        
	}
	
	
	
	@Test(priority=6,expectedExceptions=InvalidSelectorException.class,groups="alpha")
	public void gotoCart(){
		WebElement goToCart = driver.findElement(By.xpath("(//div[@id='sw-subtotal']/following-sibling::span"));
        goToCart.click();
	}
	@Test(priority=7,expectedExceptions=NoSuchElementException.class)
	public void shoppingCompare() throws InterruptedException{
		WebElement shoppingcart = driver.findElement(By.xpath("//span[@class='a-list-item']/parent::li[@class='a-spacing-mini']"));
        String shopping = shoppingcart.getText();
        System.out.println(shopping);
        if(selectedProdtext.contains(shopping)) {
       	 driver.close();
        }
        
        Thread.sleep(3000);
	}
	

	
	@AfterClass
	public void  urlClose(){
        driver.quit();
        }
	
        

		
		
	}
		
	
		
	
