package com.toutorialsninja.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement Loginoption;
	
	@FindBy(linkText="Register")
	private WebElement Registeroption;
	
public homePage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
			
//Actions
public void clickonmyaccount() {
	MyAccountDropMenu.click();
}
public void clickonlogin() {
	Loginoption.click();
}
	public RegisterPage Registeroption() {
		Registeroption.click();
		return new RegisterPage(driver);
	}
	
	
}