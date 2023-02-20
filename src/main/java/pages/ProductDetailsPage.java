package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver ;
		
	}

	@FindBy (className = "current-item")
	public WebElement productBreadCrumb ;
	
	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement emailAFriendBtn ;
	
	@FindBy (id = "price-value-4")
	public WebElement priceLbl ;
	
	@FindBy (linkText = "Add your review")
	WebElement addYourReviewLink ;
	
	@FindBy (id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn ;
	
	@FindBy (linkText = "wishlist")
	WebElement wishListLink ;
	
	@FindBy (css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn ;
	
	@FindBy (linkText = "product comparison")
	WebElement productComparisonLink ;
	
	@FindBy (id = "add-to-cart-button-4")
WebElement addToCartBtn ;
	
	@FindBy (linkText = "shopping cart")
	WebElement shoppingCartLink ;
	
	
	
	
	public void goToEmailAFriendPage () 
	{
		clickButton(emailAFriendBtn);
	}
	
	
	public void goToAddYourReviewPage ()
	{
		clickButton(addYourReviewLink);
	}
	
	
	public void addProductToWishList () throws InterruptedException
	{
		clickButton(addToWishListBtn);
		Thread.sleep(3000);
		clickButton(wishListLink);
	}
	
	
public void addProductToCompareList ()
{
	clickButton(addToCompareListBtn);
}


public void goToComparisonPage ()
{
	clickButton(productComparisonLink);
}


public void addProductToCart ()
{
	clickButton(addToCartBtn);
}


public void goToAddToCartPage ()
{
	
	clickButton(shoppingCartLink);
}



}
