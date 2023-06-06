package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.BaseClass1;
import pomClass.LoginPage;

//@Listeners(listnersClasses.ListnerClass.class)
public class TestClass1 {
	WebDriver driver;
	LoginPage lp;
	
	ExtentHtmlReporter extentReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		extentReporter = BaseClass1.getHtmlReporter();
		reports = BaseClass1.getReports();
		test = BaseClass1.getTest("TestClass1");
		driver = BaseClass1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
        lp = new LoginPage(driver);
	}
	
	@Test
	public void test1() throws IOException
	{
		lp.clickSigninBTN();
		lp.enterUserName();
		lp.clickContinueBTN();
		lp.enterPassword();
		lp.clickSignin();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName()+ "test passed");
		}else
		{
		String path	=lp.takeScreenShot(driver, result.getName());
			test.log(Status.FAIL,result.getName()+ "test fail", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		}
		System.out.println("after method");
	}
	
	@AfterClass
	public void afterClass()
	{
		reports.flush();
		System.out.println("after class");
	}
	
	
	


}
