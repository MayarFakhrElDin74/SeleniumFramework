package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}

 @FindBy (id = "FullName")
 WebElement yourNameTxtBox ;
 
 @FindBy (id = "Email")
 WebElement yourEmailTxtBox ;
 
 @FindBy (id = "Enquiry")
 WebElement enquiryTxtBox ;
 
 @FindBy (css = "button.button-1.contact-us-button")
 WebElement submitBtn ;
 
 @FindBy (css = "div.result")
 public WebElement contactUsSuccessNotification ;
 
 
 public void contactUs (String name , String email , String enquiryTxt)
 {
	 setTextElementText(yourNameTxtBox, name);
	 setTextElementText(yourEmailTxtBox, email);
	 setTextElementText(enquiryTxtBox, enquiryTxt);
	 clickButton(submitBtn);
 }
 
}
