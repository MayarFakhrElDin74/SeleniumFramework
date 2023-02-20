package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductCheckoutPage extends PageBase {

	public ProductCheckoutPage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy (id =  "BillingNewAddress_CountryId")
	WebElement countryTxtBox ;
	
	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement countrySelected ;
	
	@FindBy (id = "BillingNewAddress_City")
	WebElement cityTxtBox ;
	
	@FindBy (id = "BillingNewAddress_Address1")
	WebElement adress1TxtBox ;
	
	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxtBox ;
	
	@FindBy (id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxtBox ;
	
	@FindBy (css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn ;
	
	@FindBy (css = "button.button-1.shipping-method-next-step-button")
	WebElement shippingContinueBtn ;
	
	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement paymentContinueBtn ;
	
	@FindBy (css = "button.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn ;
	
	
	@FindBy (css  =  "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn ;
	
	
	
	
	public void fillingpersonalInfoForOrderCheckout
	(String countryName , String cityName , String adress1Txt , String zipCodeTxt , String phoneNumberTxt) throws InterruptedException
	
	{
		
		clickButton(countryTxtBox);
		
		Thread.sleep(3000);
		
		//action = new Actions(driver) ;
		//action.scrollToElement(countrySelected).build().perform() ;
		
		
		Thread.sleep(3000);
		
		select = new Select(countryTxtBox) ;
		select.selectByVisibleText(countryName);
		
		Thread.sleep(3000);
		
		setTextElementText(cityTxtBox, cityName);
		setTextElementText(adress1TxtBox, adress1Txt);
		setTextElementText(zipCodeTxtBox , zipCodeTxt) ;
		setTextElementText(phoneTxtBox, phoneNumberTxt);
		clickButton(continueBtn);
	}
	
	public void selectshippingMethod ()
	{
		clickButton(shippingContinueBtn);
	}
	
	
	public void selectPaymentMethod ()
	{
		clickButton(paymentContinueBtn);
	}
	
	public void confirmPaymentInfo ()
	{
		clickButton(paymentInfoContinueBtn);
	}
	
	public void confirmOrder ()
	{
		clickButton(confirmOrderBtn);
	}
}
