package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends PageBase {

	public EmailAFriendPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id = "FriendEmail")
	WebElement frindsEmailTxtBox ;
	
	@FindBy (id = "PersonalMessage")
	WebElement personalMsgTxtBox ;
	
	@FindBy (css =  "button.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn ;
	
	@FindBy (css = "div.result")
	public WebElement emailAFriendSuccessNotification ;
	
	
	public void emailAFriend (String friendsEmail , String msgTxt)
	{
		setTextElementText(frindsEmailTxtBox, friendsEmail);
		setTextElementText(personalMsgTxtBox, msgTxt);
		clickButton(sendEmailBtn);
	}
}
