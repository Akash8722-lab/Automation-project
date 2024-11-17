package com.toutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailadressfield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@value=\'Login\']")
	private WebElement loginbutton;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	public void emailadressfield(String Email) {
		emailadressfield.sendKeys(Email);
	}
	
	public void passwordfield(String Password) {
		passwordfield.sendKeys(Password);
	}
	
	public void loginbutton()
	{
		loginbutton.click();
	}
	
	
}
