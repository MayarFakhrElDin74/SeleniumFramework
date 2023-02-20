package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishListPage extends PageBase {

	public AddToWishListPage(WebDriver driver) {
		super(driver);
		
	
	}
	
	@FindBy (css  = "button.remove-btn")
	WebElement removeProductBtn ;
	
	@FindBy (css = "a.product-name")
	public WebElement productAddedName ;
	
	@FindBy (css =  "div.no-data")
	public WebElement removeProductNotification ;
	
	
	
	
	public void removeProductFromWishList ()
	{
		clickButton(removeProductBtn);
	}

}
