package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testrunner.AdactinRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef {
	WebDriver driver= AdactinRunner.driver;

@Given("^user Launch The Adactin App$")
public void user_Launch_The_Adactin_App() throws Throwable {
	driver.get("http://adactinhotelapp.com/index.php");
  
}

@When("^user Enter The Username In Inputbox$")
public void user_Enter_The_Username_In_Inputbox() throws Throwable {
	WebElement id = driver.findElement(By.id("username"));
	id.sendKeys("KUZHALIBALA");
   
}

@When("^user Enter The Password In Inputbox$")
public void user_Enter_The_Password_In_Inputbox() throws Throwable {
	WebElement pass = driver.findElement(By.id("password"));
	pass.sendKeys("kuzhali92");
  
}

@Then("^user Click Login Button And Navigate To The Next Page$")
public void user_Click_Login_Button_And_Navigate_To_The_Next_Page() throws Throwable {
	WebElement log = driver.findElement(By.id("login"));
	log.click();
}

@When("^user Select The Location From Dropdown$")
public void user_Select_The_Location_From_Dropdown() throws Throwable {
   WebElement loc= driver.findElement(By.id("location"));
   Select s1=new Select(loc);
	s1.selectByIndex(2);
   
}

@When("^user Select Hotels From Dropdown$")
public void user_Select_Hotels_From_Dropdown() throws Throwable {
	WebElement h= driver.findElement(By.id("hotels"));
	Select s2=new Select(h);
	s2.selectByIndex(2);
}

@When("^user Select Roomtype From Dropdown$")
public void user_Select_Roomtype_From_Dropdown() throws Throwable {
	WebElement r= driver.findElement(By.id("room_type"));
	Select s3=new Select(r);
	s3.selectByVisibleText("Deluxe");
}

@When("^user Select No Of Rooms From The Dropdown$")
public void user_Select_No_Of_Rooms_From_The_Dropdown() throws Throwable {
	WebElement no= driver.findElement(By.id("room_nos"));
	Select s4=new Select(no);
	s4.selectByIndex(4);
}

@When("^user Enter The Check In Date In Inputbox$")
public void user_Enter_The_Check_In_Date_In_Inputbox() throws Throwable {
	WebElement date= driver.findElement(By.id("datepick_in"));
	date.sendKeys("13/08/2022");
	
}

@When("^user Enter Check Out Date In Inputbox$")
public void user_Enter_Check_Out_Date_In_Inputbox() throws Throwable {
	WebElement date= driver.findElement(By.id("datepick_out"));
	date.sendKeys("15/08/2022");
}

@When("^user Select Adult Per Room From Dropdown$")
public void user_Select_Adult_Per_Room_From_Dropdown() throws Throwable {
	WebElement adult= driver.findElement(By.id("adult_room"));
	Select s5=new Select(adult);
	s5.selectByIndex(3);
}

@When("^user Select Children Per Room From Dropdown$")
public void user_Select_Children_Per_Room_From_Dropdown() throws Throwable {
	WebElement ch= driver.findElement(By.id("child_room"));
	Select s6=new Select(ch);
	s6.selectByIndex(3);
}

@Then("^user Click The Search Button$")
public void user_Click_The_Search_Button() throws Throwable {
	WebElement sub= driver.findElement(By.id("Submit"));
	sub.click();
}

@When("^user Click The Radiobutton$")
public void user_Click_The_Radiobutton() throws Throwable {
	WebElement radio= driver.findElement(By.id("radiobutton_0"));
	radio.click();
}

@Then("^user Click The Continue Option$")
public void user_Click_The_Continue_Option() throws Throwable {
	WebElement con = driver.findElement(By.id("continue"));
	con.click();
}

@When("^user Enters  The First Name In Inputbox$")
public void user_Enters_The_First_Name_In_Inputbox() throws Throwable {
	WebElement fs= driver.findElement(By.id("first_name"));
	fs.sendKeys("POO");
}

@When("^user Enters  The Last Name In Inputbox$")
public void user_Enters_The_Last_Name_In_Inputbox() throws Throwable {
	WebElement Ls= driver.findElement(By.id("last_name"));
	Ls.sendKeys("BALA");
}

@When("^user Enters  The Billing Address In Inputbox$")
public void user_Enters_The_Billing_Address_In_Inputbox() throws Throwable {
	WebElement add= driver.findElement(By.id("address"));
	add.sendKeys("No.4,xyz street,chennai");
}

@When("^user Enter Credit Card Num In The Inputbox$")
public void user_Enter_Credit_Card_Num_In_The_Inputbox() throws Throwable {
	WebElement cc= driver.findElement(By.id("cc_num"));
	cc.sendKeys("8976564367854321");
}

@When("^user Enter Credit Card Type In The Inputbox$")
public void user_Enter_Credit_Card_Type_In_The_Inputbox() throws Throwable {
	WebElement ct= driver.findElement(By.id("cc_type"));
	Select s7=new Select(ct);
	s7.selectByIndex(2);
}

@When("^user Enter Expiry Date By Selecting Month And Year From Dropdown$")
public void user_Enter_Expiry_Date_By_Selecting_Month_And_Year_From_Dropdown() throws Throwable {
	WebElement month= driver.findElement(By.id("cc_exp_month"));
	Select s8=new Select(month);
	s8.selectByVisibleText("March");
	WebElement year= driver.findElement(By.id("cc_exp_year"));
	Select s9=new Select(year);
	s9.selectByVisibleText("2022");
}

@When("^user Enter CVV Num In The Inputbox$")
public void user_Enter_CVV_Num_In_The_Inputbox() throws Throwable {
	WebElement cvv= driver.findElement(By.id("cc_cvv"));
	cvv.sendKeys("897");
}

@Then("^user Click The Book Now Button$")
public void user_Click_The_Book_Now_Button() throws Throwable {
	WebElement book= driver.findElement(By.id("book_now"));
	book.click();
	Thread.sleep(3000);
}
@Then("^user Clicks On The My Itinerary Button$")
public void user_Clicks_On_The_My_Itinerary_Button() throws Throwable {
	WebElement ite= driver.findElement(By.id("my_itinerary"));
	ite.click();
}

@Then("^user Clicks On The Logout Button$")
public void user_Clicks_On_The_Logout_Button() throws Throwable {
	WebElement log= driver.findElement(By.id("logout"));
	log.click();

}

}


