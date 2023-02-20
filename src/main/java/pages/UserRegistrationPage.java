package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	String firstName = "Mayar" ;
	String lastName = "Fakhr ElDin" ;
	 String email = "ay7aga555555@gmail.com" ;
	 String password = "12345678" ;
			
			
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "gender-female")
	WebElement genderBtn ;
	
	@FindBy (id = "FirstName")
	WebElement firstNameTxtBox ;
	
	@FindBy (id = "LastName")
	WebElement lastNameTxtBox ;
	
	@FindBy (id = "Email")
    WebElement emailTxtBox ;
	
	@FindBy (id = "Password")
	WebElement passwordTxtBox ;
	
	@FindBy (id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox ;
	
	@FindBy (id = "register-button")
	WebElement registerBtn ;
	
	@FindBy (css = "div.result") 
	public WebElement successMsg ;
	
	
	
	public void userRegistration (String firstName , String lastName , String email ,  String password)
	
	{
		clickButton(genderBtn);
		setTextElementText(firstNameTxtBox, firstName);
		setTextElementText(lastNameTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
		
	}
	
}
