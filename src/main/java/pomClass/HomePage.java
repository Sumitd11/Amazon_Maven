package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.UtilityClass1;

public class HomePage extends UtilityClass1{
	
WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Hello, Sumit']")
	private WebElement profileNmae;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
	}
	
	public boolean getProfileName()
	{
		WebElement element =explicitWait(driver, profileNmae);
		String pName =element.getText();
//		
//		return pName;
		
		if(pName.equals("Hello, Sumit"))
		{
			return true;
		}
		return false;
	}
	


}
