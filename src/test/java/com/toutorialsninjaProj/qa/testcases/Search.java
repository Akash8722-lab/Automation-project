package com.toutorialsninjaProj.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toutorialsninja.qa.pageobjects.SearchPage;
import com.toutorialsninjaPro.qa.Base.Base;

public class Search extends Base{

	

public Search() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

public WebDriver driver;
SearchPage scr;
@AfterMethod
public void teardown() {

	driver.quit();

}

	@BeforeMethod
	public void setup() {

		driver=InitializaBrowsertoOpenApp(prop.getProperty("browser"));
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
		 scr=new SearchPage(driver);

	}

	@Test(priority=1)
	public void Verifysearchwithexistingproducts() {
         
		scr.search(dataprop.getProperty("validproduct"));
		scr.SearchClcik();
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataprop.getProperty("validproduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@Test(priority=2)
	public void Verifysearchwithnonexistingproducts() {

		
		scr.search(dataprop.getProperty("invalidproduct"));
		scr.SearchClcik();
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataprop.getProperty("invalidproduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//Assert.assertEquals(false, null);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).isDisplayed());
	}
	
	@Test(priority=3,dependsOnMethods= {"Verifysearchwithnonexistingproducts","Verifysearchwithexistingproducts"})
	public void Verifysearchwithoutenteringanyproduct() {
		
		scr.SearchClcik();
		
		
	}
	
	
	
	
	
	
}