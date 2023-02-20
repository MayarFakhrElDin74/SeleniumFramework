package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(linkText = "Print")
WebElement printOrderDetailsBtn ;


@FindBy (linkText = "PDF Invoice")
WebElement pdfInvoiceDownload ;


public void printOrderDetails ()
{
	clickButton(printOrderDetailsBtn);
}

public void downloadPdfInvoice ()
{
	clickButton(pdfInvoiceDownload);
}


	
	
}
