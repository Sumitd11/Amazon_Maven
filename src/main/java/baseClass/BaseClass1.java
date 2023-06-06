package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilityClass.UtilityClass1;

public class BaseClass1 {
	static ExtentHtmlReporter extentReporter = null;
	static ExtentReports report = null;
   static 	ExtentTest test = null;
	
	static WebDriver driver = null;

		public static WebDriver getDriver(String browser) throws IOException
		{
			if(driver == null)
			{
				if(browser.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
					
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
				 driver = new ChromeDriver(options);
				}else if(browser.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				driver.get(UtilityClass1.getProperty("url"));
				driver.manage().window().maximize();
				return driver;
			}else
			{
				return driver;
			}
		}
		
		public static ExtentHtmlReporter getHtmlReporter() 
		{
			if(extentReporter == null)
			{
				extentReporter = new ExtentHtmlReporter("ExtentReporter.html");
				return extentReporter;
			}
			return extentReporter;
		}
		
		public static ExtentTest getTest(String testName)
		{
			test = report.createTest(testName);
			return test;
		}
		
		public static ExtentReports getReports()
		{
			if(report == null)
			{
				report = new ExtentReports();
				 report.attachReporter(extentReporter);
				return report;
			}
			return report;
		}
		
	
		
	
}
