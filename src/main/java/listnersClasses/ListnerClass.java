package listnersClasses;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {
	
	
	  public void onTestStart(ITestResult result) {

System.out.println(result.getName() + "test Start");
	  }
	  
	  public void onTestSuccess(ITestResult result) {
		  System.out.println(result.getName() + "test success");
		  }
	  
	  
	  public void onTestFailure(ITestResult result) {
		  System.out.println(result.getName() + "test fail");
		  
		  }
	  
	  public void onTestSkipped(ITestResult result) {
		  System.out.println(result.getName() + "test skipped");
		  
		  }
}
