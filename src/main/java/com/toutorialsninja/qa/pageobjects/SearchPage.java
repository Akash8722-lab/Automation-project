package com.toutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
       
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement Searchfield;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	WebElement SearchClcik;
	

	public void search(String search) {
		Searchfield.sendKeys(search);
	}
	
	public void SearchClcik() {
		SearchClcik.click();
	}
	
	public  SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	 
	
	
	
}
