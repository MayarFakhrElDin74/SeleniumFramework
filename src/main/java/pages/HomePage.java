package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		
		jse = (JavascriptExecutor) driver ;
		
		
	}
	
		@FindBy (linkText = "Register") 
		WebElement registerLink ;
	
		@FindBy (linkText = "Log in")
		public WebElement loginLink ;
		
		@FindBy (linkText = "Log out")
		public WebElement logoutLink ;
		
		@FindBy (id = "small-searchterms")
		WebElement searchTxtBox ;
		
		@FindBy (id = "ui-id-1")
		List <WebElement> productDropDownList ;
		
		@FindBy (css = "button.button-1.search-box-button") 
		WebElement searchBtn ;
		
		@FindBy (linkText = "Contact us")
		WebElement contactUsLink ;
		
		@FindBy (id = "customerCurrency")
        WebElement currencyDropDownList ;
		
		@FindBy (linkText = "Computers")
		WebElement computersMenu ;
		
		@FindBy (linkText = "Notebooks")
		WebElement notebooksLink ;
		
		
		
		
		public void openRegistrationPage ()
		{
        clickButton(registerLink); 
		}
	
		public void openLoginPage ()
		{
			clickButton(loginLink);
		}
		
		public void searchProduct (String productName)
		{
			setTextElementText(searchTxtBox , productName );
			clickButton(searchBtn);
		}
		
		public void searchProductUsingAutoSuggest (String incompleteProductName) throws InterruptedException 
		{
			setTextElementText(searchTxtBox, incompleteProductName);
			Thread.sleep(3000);
			clickButton(productDropDownList.get(0));
		}
		
		public void openContactUsPage ()
		{
			scrollToButtom() ;
			clickButton(contactUsLink);
		}
		
		public void changeCurrency ()
		{
			select = new Select(currencyDropDownList) ;
			select.selectByVisibleText("Euro");
		}
		
		public void goToNotebooksPage ()
		{
			
			action.moveToElement(computersMenu).moveToElement(notebooksLink).click().build().perform();
		}
		
		

}
