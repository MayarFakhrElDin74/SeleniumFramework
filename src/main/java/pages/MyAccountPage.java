package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
	
String oldPassword = "12345678" ;
public String newPassword = "11223344" ;
			
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (linkText = "My account")
	 WebElement myAccountLink ;
	
	@FindBy (linkText = "Change password")
	WebElement changePasswordLink ;
	
	@FindBy (id = "OldPassword")
	WebElement oldPasswordTxtBox ;
	
	@FindBy (id = "NewPassword")
	WebElement newPasswordTxtBox ;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTxtBox ;
	
	@FindBy (css = "button.button-1.change-password-button")
	WebElement changePasswordBtn ;
	
	@FindBy (css = "p.content")
	public WebElement changePasswordSuccessMsg ;
	
    @FindBy (css = "span.close")
    WebElement notificationCloseBtn ;
	
    public void goToMyAccount()
    {
    clickButton(myAccountLink);
}
    
	public void registeredUserChangePassword () 
	
	{
		clickButton(changePasswordLink);
		setTextElementText(oldPasswordTxtBox, oldPassword);
		setTextElementText(newPasswordTxtBox, newPassword);
		setTextElementText(confirmNewPasswordTxtBox, newPassword);
		clickButton(changePasswordBtn);
		clickButton(notificationCloseBtn);
	}
	

}
