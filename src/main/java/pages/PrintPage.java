package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintPage extends PageBase {

	public PrintPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css = "li.order-status")
	public WebElement orderStatus ;
	
	
	
	
}
