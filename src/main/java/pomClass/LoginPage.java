package pomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.UtilityClass1; 



public class LoginPage extends UtilityClass1 {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement signinBTN;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueBTN;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signin;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickSigninBTN()
	{
		
		signinBTN.click();
	}
	
	public void enterUserName() throws IOException
	{   
		userName.sendKeys(UtilityClass1.getProperty("username"));	
	}
	
	public void clickContinueBTN()
	{
		continueBTN.click();
	}
	
	public void enterPassword() throws IOException
	{
		password.sendKeys(UtilityClass1.getProperty("password"));
	}
	
	public void clickSignin()
	{
		signin.click();
	}

}
