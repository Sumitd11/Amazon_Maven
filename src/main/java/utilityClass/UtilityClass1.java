package utilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass1 {
	
	public static String getProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("Configuration\\config.properties");
		
		Properties p = new Properties();
		
		p.load(file);
		
	String property = p.getProperty(key);
	
	return property;
		
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public WebElement explicitWait(WebDriver driver, WebElement element) 
	{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    
    WebElement newElement = wait.until(ExpectedConditions.visibilityOf(element));
    
    return newElement;
	}
	
	public String takeScreenShot(WebDriver driver, String sName) throws IOException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
	 	
	    String time = sdf.format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    
	    String path = "Screenshots\\"+sName+".png";
	    File destionation = new File(path);
	    
	    FileHandler.copy(source, destionation);
	    return path;
	}

}
