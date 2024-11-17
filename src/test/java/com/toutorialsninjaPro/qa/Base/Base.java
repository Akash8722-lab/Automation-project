package com.toutorialsninjaPro.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.toutorialsninjaProj.qa.utility.Utilities;

public class Base {

   public WebDriver driver;
   public Properties prop;
   public Properties dataprop;

   public Base() throws IOException {

	   prop=new Properties();
	   FileInputStream fis=new FileInputStream("C://Users//shadows box//eclipse-workspace//toutorialsninjaProj//src//main//java//toutorialsninjaproj//qa//config//config.properties");
	   //C:\\Users\\rahul\\E2EProject\\src\\main\\java\\resources\\data.properties
	   prop.load(fis);

	   dataprop=new Properties();
	   FileInputStream datafis= new FileInputStream("C://Users//shadows box//eclipse-workspace//toutorialsninjaProj//src//main//java//com//toutorialsProj//qa//testdata//testdata.properties");
	   dataprop.load(datafis);
   }

	public WebDriver InitializaBrowsertoOpenApp(String BrowserName) {

		//String BrowserName="Chrome";
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));

		return driver;
	}

}
