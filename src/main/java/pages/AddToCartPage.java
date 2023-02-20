package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageBase {

	public AddToCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css = "input.qty-input")
	WebElement quantityBox ;
	
	@FindBy (css = "button.remove-btn")
	WebElement removeProductFromCartBtn ;
	
	@FindBy (id = "updatecart")
	WebElement updateCartBtn ;
	
	@FindBy (css = "div.no-data")
	public WebElement emptyCartNotification ;
	
	@FindBy (css = "span.cart-qty")
	public WebElement shoppingCartQuantity ;
	
	@FindBy (id = "termsofservice")
	WebElement termsBtn ;
	
	@FindBy (id = "checkout")
	WebElement checkoutBtn ;
	
	
	
	
	
	public void modifyProductQuantity (String finalProductQuantity)
	{
		clickButton(quantityBox);
		quantityBox.clear();
		setTextElementText(quantityBox, finalProductQuantity);
	}
	
	public void updateShoppingCart ()
	{
		clickButton(updateCartBtn);
	}

	public void clearShoppingCart ()
	{
		clickButton(removeProductFromCartBtn) ;
	}
	
	

	
	public void goToCheckoutPage ()	
	{
		clickButton(termsBtn);
		clickButton(checkoutBtn);
		
	}
	
	
}
