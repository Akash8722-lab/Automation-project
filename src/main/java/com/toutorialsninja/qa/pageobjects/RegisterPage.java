package com.toutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
  
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastnamefield;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordfield;
	

	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmpasswordfield;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement Continue;
	
	
	
	public void firstnamefield(String Firstname) {
		firstnamefield.sendKeys(Firstname);
	}
	
	public void lastnamefield(String lastname) {
		lastnamefield.sendKeys(lastname);
	}
	public void emailfield(String email) {
		emailfield.sendKeys(email);
	}
	
	public void telephonefield(String telephone) {
		telephonefield.sendKeys(telephone);
	}
	
	public void passwordfield(String password) {
		passwordfield.sendKeys(password);
	}
	
	public void confirmpasswordfield(String confirm) {
		confirmpasswordfield.sendKeys(confirm);
	}
	
	public void checkbox() {
		checkbox.click();
	}
	public void Continue() {
		Continue.click();
	}
	
	
	
	
	
	
	
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
}
