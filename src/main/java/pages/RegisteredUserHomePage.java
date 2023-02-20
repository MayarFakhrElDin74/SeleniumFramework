package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisteredUserHomePage extends PageBase {

	public RegisteredUserHomePage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy (linkText = "Log out")
	public WebElement logoutLink ;
	
	
	
	
	public void loggedinUserCanLogout ()
	{
		clickButton(logoutLink);
	}
}
