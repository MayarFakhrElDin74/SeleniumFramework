package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	String email = "ay7aga555555@gmail.com" ;
	String password = "12345678" ;
			
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy (linkText = "Log in")
	WebElement loginLink ;
	
	@FindBy (id = "Email")
	WebElement emailTxtBox ;
	
	@FindBy (id = "Password")
	WebElement passwordTxtBox ;
	
	@FindBy (css = "button.button-1.login-button")
	WebElement loginBtn ;
	
	public void userLogin (String email , String password)
	{
		setTextElementText(emailTxtBox, email );
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
	
	

}
