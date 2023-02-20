package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddYourReviewPage extends PageBase {

	public AddYourReviewPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (id = "AddProductReview_Title")
	WebElement reviewTitleTxtBox ;
	
	@FindBy (id = "AddProductReview_ReviewText")
	WebElement reviewTxtBox ;
	
	@FindBy (id = "addproductrating_4")
	WebElement ratingBtn ;
	
	@FindBy (css = "button.button-1.write-product-review-button")
	WebElement submitReviewBtn ;
	
	@FindBy (css = "div.result")
	public WebElement addReviewSuccessNotification ;
	
	
	public void registeredUserCanAddReview (String reviewTitle , String reviewTxt)
	{
		setTextElementText(reviewTitleTxtBox, reviewTitle);
		setTextElementText(reviewTxtBox, reviewTxt);
		clickButton(ratingBtn);
		clickButton(submitReviewBtn);
	}
}
