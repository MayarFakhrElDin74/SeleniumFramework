package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToComparePage extends PageBase {

	public AddToComparePage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy (css = "table.compare-products-table")
	public WebElement compareTable;
	
	@FindBy (tagName = "tr")
	List<WebElement> allRows ;
	
	@FindBy (tagName = "td")
	List<WebElement> allCols ;
	
	
	@FindBy (css = "a.clear-list")
	WebElement clearListBtn ;
	
	@FindBy (css = "div.no-data")
public WebElement clearListNotification ;
	
	
	public void compareTwoProducts ()
	{
		for (WebElement col : allCols) {
			System.out.println(col.getText() +"\t");
			
			for (WebElement row : allRows) {
				System.out.println(row.getText() +"\t");
				
			}
			
		}
	}
	
	public void clearCompareProductList ()
	{
		clickButton(clearListBtn);
	}
	
}
