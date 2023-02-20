package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	//create constructor	
	protected WebDriver driver ;
	
	public JavascriptExecutor jse ;
	public Select select ;
	public Actions action ;
	
	
	
	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton (WebElement button) 
	
	{
		button.click(); 
	}
	
	protected static void setTextElementText (WebElement txtBoxElement , String value)
	{
		txtBoxElement.sendKeys(value);
	}
	
	public void scrollToButtom ()
	{
		jse.executeScript("window.scroll (0,5000)") ;
	}
	
}
