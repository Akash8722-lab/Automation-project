package com.toutorialsninjaProj.qa.testcases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toutorialsninja.qa.pageobjects.RegisterPage;
import com.toutorialsninja.qa.pageobjects.homePage;
import com.toutorialsninjaPro.qa.Base.Base;
import com.toutorialsninjaProj.qa.utility.Utilities;

public class Register extends Base{

	
	
	public WebDriver driver;
	RegisterPage RP;
	public Register() throws IOException {
		super();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@BeforeMethod
	public void setup() {
	   // driver=new ChromeDriver();
		driver=InitializaBrowsertoOpenApp(prop.getProperty("browser"));
		homePage home=new homePage(driver);
		home.clickonmyaccount();
		RP = home.Registeroption();
	}

	@Test(priority=1)
	public void verifyregisteraccountwithmandatoryfields() {

		//driver.findElement(By.linkText("Login")).click();
		//verify register account HeaderElement
		WebElement ActualHeader=driver.findElement(By.xpath("//h1[text()='Register Account']"));

		//Gettext
		String ActualHeaderText=ActualHeader.getText();
		String ExpectedText="Register Account";

		//Validate Register page
		Assert.assertEquals(ActualHeaderText, ExpectedText,"Headertext is not as expected");

		//RegisterPage RP=new RegisterPage(driver);
		RP.firstnamefield(dataprop.getProperty("firstname"));
		RP.lastnamefield(dataprop.getProperty("lastname"));
		RP.emailfield(Utilities.generateTimeStamp());
		RP.telephonefield(dataprop.getProperty("telephone"));
		RP.passwordfield(prop.getProperty("validpassword"));
		RP.confirmpasswordfield(prop.getProperty("validpassword"));
		RP.checkbox();
		RP.Continue();
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validpassword"));
		//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(prop.getProperty("validpassword"));
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//validpassword
		//validemail
		//verify  account created
	    WebElement Actualsuccessmsg=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
		String Actualsuccessmsgtext=Actualsuccessmsg.getText();

		String ExpectedtextAccountcreatedmsg=dataprop.getProperty("ExpectedtextAccountcreatedmsg");
		Assert.assertEquals(Actualsuccessmsgtext, ExpectedtextAccountcreatedmsg,"Account is not created");

	}
	@Test(priority=2)
	public void verifyregisteraccountwithallfields() {

		//driver.findElement(By.linkText("Login")).click();

		//verify register account HeaderElement
		WebElement ActualHeader=driver.findElement(By.xpath("//h1[text()='Register Account']"));

		//Gettext
		String ActualHeaderText=ActualHeader.getText();
		String ExpectedText="Register Account";

		//Validate Register page
		Assert.assertEquals(ActualHeaderText, ExpectedText,"Headertext is not as expected");

		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(prop.getProperty("validpassword"));

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//verify  account created
	    WebElement Actualsuccessmsg=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
		String Actualsuccessmsgtext=Actualsuccessmsg.getText();

		String ExpectedtextAccountcreatedmsg=dataprop.getProperty("ExpectedtextAccountcreatedmsg");
		Assert.assertEquals(Actualsuccessmsgtext, ExpectedtextAccountcreatedmsg,"Account is not created");

	}


	@Test(priority=3)
	public void verifyRegisteringAccountwithExistingEmailid() {


		//driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(prop.getProperty("validpassword"));

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//verify  account created
	    WebElement Actualsuccessmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
		String Actualsuccessmsgtext=Actualsuccessmsg.getText();

		String ExpectedtextEmailwarning=dataprop.getProperty("ExpectedtextEmailwarning");
		Assert.assertEquals(Actualsuccessmsgtext, ExpectedtextEmailwarning,"Warning msg is not displayed");

	}

	@Test(priority=4)
	public void Verifyregisteringaccountwithoutfillingmanddetails() {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//validate privacypolicy
	    String ActualWarningprivacy=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	    String ExpectedWarningprivacy="Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(ActualWarningprivacy, ExpectedWarningprivacy,"No warning");
		//validate Fnamewarning
		String ActualfnameWarning=driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText();
		String ExpectedfnameWarning=dataprop.getProperty("ExpectedfnameWarning");
		Assert.assertEquals(ActualfnameWarning, ExpectedfnameWarning,"warning is not displayed");
	}

}