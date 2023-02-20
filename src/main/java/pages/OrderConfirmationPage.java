package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends PageBase {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (linkText = "Click here for order details.")
	public WebElement orderDetailsLink ;

	
	@FindBy (css = "button.button-1.order-completed-continue-button")
	WebElement confirmedOrderContinueBtn ;
	

	

	
	public void goToOrderDetailsPage ()
	{
		
		clickButton(orderDetailsLink);
	}
}
