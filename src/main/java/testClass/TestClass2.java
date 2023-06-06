package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.BaseClass1;
import pomClass.HomePage;
import pomClass.LoginPage;

public class TestClass2 {

	  static WebDriver driver;
		LoginPage lp;
		HomePage hp;
		
		ExtentHtmlReporter extentReporter;
		ExtentReports reports;
		ExtentTest test;
		
		
		@BeforeClass
		public void beforeClass() throws IOException
		{  extentReporter= BaseClass1.getHtmlReporter();
		 reports = BaseClass1.getReports();
		 test =  BaseClass1.getTest("TestClass2");
			driver = BaseClass1.getDriver("chrome");
		}
		
		@BeforeMethod
		public void beforeMethod()
		{
		    lp = new LoginPage(driver);
			hp = new HomePage(driver);
		}
		
		@Test
		public void test()
		{
//			lp.clickSigninBTN();
//		    lp.enterUserName();
//		    lp.clickContinueBTN();
//		    lp.enterPassword();
//		    lp.clickSignin();
			
//		String profileName =	hp.getProfileName();
//		Assert.assertEquals(profileName, "Hello, Sumit"); 
		
			Assert.assertTrue(hp.getProfileName());//pass
//			Assert.assertFalse(hp.getProfileName());//fail
		System.out.println("after assert");
//		if(profileName.equals("Hello, Sumit"))
//		{
//			System.out.println("test Pass");
//		}else
//		{
//			System.out.println("test Fail");
//		}
			
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
		
		@AfterClass()
		public void afterClass()
		{
			reports.flush();
			//driver.quit();
		}

}
