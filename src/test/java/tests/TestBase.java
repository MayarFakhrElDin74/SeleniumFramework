package tests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase extends AbstractTestNGCucumberTests {
 
public static WebDriver driver ;
		
	
	
  @BeforeSuite
  @Parameters ({"browser"})
  public void startDriver (@Optional ("chrome") String browserName)
  { 
	   
	  if (browserName.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver() ;
	  }
		  else if (browserName.equalsIgnoreCase("firefox"))  {
			  driver = new FirefoxDriver() ;	
	  }
      
		  else if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver() ;
		}
	  
      driver.manage().window().maximize();
      driver.navigate().to("https://demo.nopcommerce.com/") ;
      
  }
  
  
  //@AfterSuite
  public void stopDriver () 
  {
	 driver.close();
  }
  
  
  @AfterMethod
  
  public void screenshotOnFailure (ITestResult result)
  {
	  if (result.getStatus() == ITestResult.FAILURE) 
	  System.out.println("Failed! Taking screenshot ..");
	  Helper.captureScreenshot(driver, result.getName());
	  
	  {
		
	}
  }
  
  
}
