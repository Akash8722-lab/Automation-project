package com.toutorialsninja.qa.pageobject.listners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.toutorialsninjaProj.qa.utility.Extentrepoter;

public class myListners implements ITestListener {

	ExtentReports report;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Executionof the project started");
		/*
		 * try { report=Extentrepoter.generateExtentReport(); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace();
		 }*/
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String TestName=result.getName();
		/*
		 * extentTest=report.createTest(TestName); extentTest.log(Status.INFO,
		 * TestName+"Started executed executing");
		 */System.out.println(TestName+"Started executed executing");
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Testname=result.getName();
		///extentTest.log(Status.PASS, Testname+"Test executed successfully");
	        System.out.println(Testname+"Test executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Testname=result.getName();
		
		
		 WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File SrcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String DestinationScreenshotpath=System.getProperty("user.dir")+"//Screenshots//"+Testname+(".png");
		try {
			FileHandler.copy(SrcScreenshot, new File(DestinationScreenshotpath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//System.out.println("Screenshot taken");	
		//extentTest.log(Status.FAIL, Testname+"Test got failed");
		//System.out.println(Testname+"got failed");
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String Testname=result.getName();
		System.out.println(Testname+"got skiped");
		System.out.println(result.getThrowable());
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("finished executing project tests");
		
	}



	
	
}
