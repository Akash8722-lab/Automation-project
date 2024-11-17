package com.toutorialsninjaProj.qa.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.toutorialsninja.qa.pageobjects.LoginPage;
import com.toutorialsninja.qa.pageobjects.homePage;
import com.toutorialsninjaPro.qa.Base.Base;
import com.toutorialsninjaProj.qa.utility.Utilities;

public class Login extends Base{

	public WebDriver driver;

	public Login() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver=InitializaBrowsertoOpenApp(prop.getProperty("browser"));
		
		homePage Home=new homePage(driver);
		Home.clickonmyaccount();
		Home.clickonlogin();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	/*
	 * @Test(priority=1,dataProvider="datasupply") public void
	 * loginwithvalidcread(String Email,String Password) { //WebDriver driver=new
	 * ChromeDriver(); driver.findElement(By.id("input-email")).sendKeys(Email);
	 * driver.findElement(By.id("input-password")).sendKeys(Password);
	 * driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
	 * Assert.assertTrue(driver.findElement(By.
	 * linkText("Edit your account information")).isDisplayed()); }
	 */
	@DataProvider
	public Object datasupply() throws IOException {

		Object[][] data= Utilities.getTestDatafromExcel("Login");

		return data;

	}



	@Test(priority=2)
	public void loginwithInvalidlogin() {
   
		LoginPage Login=new LoginPage(driver);
		Login.emailadressfield(Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys();
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidpassword"));
		Login.passwordfield(dataprop.getProperty("invalidpassword"));
		Login.loginbutton();
		//driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
		//String ActualWarningMSG = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
		//System.out.println(e);
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
	}

	
	@Test(priority=3)
	public void loginwithvalidEmailandInvalidpsw() {
         
		LoginPage login=new LoginPage(driver);
		login.emailadressfield(prop.getProperty("validemail"));
		login.passwordfield(Utilities.generateTimeStamp());
		login.loginbutton();
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		//driver.findElement(By.id("input-password")).sendKeys(Utilities.generateTimeStamp());
		//driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
		//String ActualWarningMSG = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
		//System.out.println(e);
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());

	}

	@Test(priority=4)
	public void loginwithInvalidEmailandValidPSW() {

		LoginPage Login=new LoginPage(driver);
		Login.emailadressfield(Utilities.generateTimeStamp());
		Login.passwordfield(prop.getProperty("validpassword"));
		Login.loginbutton();
		
		
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		//driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
		//String ActualWarningMSG = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
		//System.out.println(e);
		///Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
	}
	@Test(priority=5)
	public void loginwithoutEnteringEmailandPSW() {
     
		LoginPage Login=new LoginPage(driver);
		Login.emailadressfield("");
		Login.passwordfield("");
		Login.loginbutton();
		
		//driver.findElement(By.id("input-email")).sendKeys("");
		//driver.findElement(By.id("input-password")).sendKeys("");
		//driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
		//String ActualWarningMSG = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
		//System.out.println(e);
		///Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
	}
}