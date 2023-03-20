package com.amazonstepdefn;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

import com.base.proj.Baseclass;
import com.testrunner.AmazonRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonStepDefn extends Baseclass {
	
	static String producttext=null;
	static String searchvalue=null;
	static String selectedProdtext=null;
	static String shopping=null;
	
	
	public static  WebDriver driver =AmazonRunner.driver;
	
	
	
	@Given("user Launch The Application")
	public void user_launch_the_application() {
		
		getUrl("https://www.amazon.in");
		 
		implicitWait();
	    
	}
	@When("user Select An Option From Dropdown")
	public void user_select_an_option_from_dropdown() {
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
	}
		
	@When("user Search The Relevant Option")
	public void user_search_the_relevant_option() throws InterruptedException {
		  searchvalue="cd";
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        
		userInput(search, searchvalue);
        
		sleep();
	}
	
		
	    
	@Then("user Clicks On The Selected Option")
	public void user_clicks_on_the_selected_option() throws InterruptedException {
List<WebElement> searchoptions = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div"));
		
		for(int i=1;i<=searchoptions.size();i++) {
			WebElement each = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div["+i+"]/div/div"));
			String text = printTheValue(each);
			if(searchvalue.equalsIgnoreCase(text)) {
				clickOnElement(each);
				break;
			}
			sleep();
		}
		
	}
	
	@When("user Fetch The Product Title")
	public void user_fetch_the_product_title() {
		WebElement findtext = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
		 producttext = printTheValue(findtext);
		System.out.println(producttext);
		
	}
	@Then("user Select the Fetched Product Title")
	public void user_Select_the_Fetched_Product_Title() {
		WebElement findtext1 = driver.findElement(By.xpath("//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2"));
		clickOnElement(findtext1); 
	}  
	
	
	@Then("user Cilcks On The Product and Get The Window")
	public void user_cilcks_on_the_product_and_get_the_window() {
		String hometab = driver.getWindowHandle();
		Set<String> multiple = driver.getWindowHandles();
		for(String each:multiple) {
			
			 if(!hometab.equals(each)) {
				 driver.switchTo().window(each);
				 break;
				 
			 }
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	   
	}


@When("user Compares The Selected Product Title")
public void user_compares_the_selected_product_title() {
	WebElement selectedprod = driver.findElement(By.xpath("//span[@id='productTitle']"));
    selectedProdtext = printTheValue(selectedprod);
  // System.out.println(selectedProdtext);
    
    
}
@Then("user Clicks on Addtocart")
public void user_clicks_on_addtocart() {
	 if(producttext.equals(selectedProdtext)) {
			
			WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
			clickOnElement(addtocart);
	   }
    
}

@When("user Capture The Page")
public void user_capture_the_page() throws IOException {
	 TakesScreenshot ts=(TakesScreenshot)driver;
     File source= ts.getScreenshotAs(OutputType.FILE);
     
     File des=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Screenshot\\addtocart.png");
     FileUtils.copyFile(source, des);
    
}
@Then("user Clicks On Gotocart")
public void user_clicks_on_gotocart() {
	WebElement goToCart = driver.findElement(By.xpath("(//div[@id='sw-subtotal']/following-sibling::span"));
    clickOnElement(goToCart);
    
}

@When("Compare The Purchase Product Title")
public void compare_the_purchase_product_title() {
	WebElement shoppingcart = driver.findElement(By.xpath("//span[@class='a-list-item']/parent::li[@class='a-spacing-mini']"));
     shopping = printTheValue(shoppingcart);
    System.out.println(shopping);
    if(selectedProdtext.contains(shopping)){
      closeBrowser();
    }
    
    }
    

@Then("Close The Current Tab")
public void close_the_current_tab() {
	 {
	   	 quitBrowser();
    
}
}
}





	



