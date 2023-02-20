package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OrderConfirmationPage;
import pages.OrderDetailsPage;
import pages.PrintPage;
import pages.ProductCheckoutPage;
import pages.ProductDetailsPage;
import pages.RegisteredUserHomePage;
import pages.SearchResultPage;
import pages.UserRegistrationPage;

public class ProductCheckoutTest extends TestBase {
	
	String firstName = "Mayar" ;
	String lastName = "Fakhr ElDin" ;
	String email = "ay7aga77777777777777777777777@gmail.com" ;
	String password = "12345678" ;
	String newPassword = "11223344" ;
	
	String incompleteProductName = "macb" ;
	String productName = "Apple MacBook Pro 13-inch" ;
	
	String countryName = "Egypt" ;
	String cityName = "Cairo" ;
	String adress1Txt = "5 Tahrir Square" ;
    String zipCodeTxt = "1234" ;
    String phoneNumberTxt = "01067301204" ;
	
	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	AddToCartPage addToCartObject ;
	ProductCheckoutPage productCheckoutObject ;
	OrderConfirmationPage orderConfirmationObject ;
	OrderDetailsPage orderDetailsObject ;
	PrintPage printObject ;
	
	
	
	@Test (priority = 1)
	public void userCanRegisterSuccessfully () 
	{
		
    homeObject = new HomePage(driver) ;
    homeObject.openRegistrationPage();
    
    registerObject = new UserRegistrationPage(driver) ;
    registerObject.userRegistration(firstName, lastName, email, password);
    
    System.out.println(registerObject.successMsg.getText());
    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
    
	}
  
    @Test (priority = 2)
    public void resgistredUserCanLoginSuccessfully ()
    {
    	homeObject = new HomePage(driver);
    	homeObject.openLoginPage();
    	
	loginObject = new LoginPage(driver) ;
	loginObject.userLogin(email, password);
    
	}
    
	
	
@Test (priority = 3)
	
	public void searchProductUsingAutoSuggest () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.productBreadCrumb.getText().equals(productName));
	}


@Test (priority = 4)
public void addToCart () throws InterruptedException
{
	productDetailsObject = new ProductDetailsPage(driver) ;
	productDetailsObject.addProductToCart();
	Thread.sleep(3000);
	productDetailsObject.goToAddToCartPage();
	
	addToCartObject = new AddToCartPage(driver) ;
	addToCartObject.updateShoppingCart();
	
}


@Test (priority = 5)

public void productCheckout () throws InterruptedException
{
	addToCartObject = new AddToCartPage(driver) ;
	addToCartObject.goToCheckoutPage();
	
	productCheckoutObject = new ProductCheckoutPage(driver) ;
	productCheckoutObject.fillingpersonalInfoForOrderCheckout(countryName, cityName, adress1Txt, zipCodeTxt, phoneNumberTxt);
	Thread.sleep(9000);
    productCheckoutObject.selectshippingMethod();
    Thread.sleep(3000);
    productCheckoutObject.selectPaymentMethod();
    Thread.sleep(3000);
    productCheckoutObject.confirmPaymentInfo();
    Thread.sleep(3000);
    productCheckoutObject.confirmOrder();

}

@Test (priority = 6)

public void  postOrderConfirmation () throws InterruptedException
{
	Thread.sleep(3000);
	orderConfirmationObject = new OrderConfirmationPage(driver) ;
	assertTrue(orderConfirmationObject.orderDetailsLink.getText().equals("Click here for order details."));
	
	orderConfirmationObject.goToOrderDetailsPage();
	
	Thread.sleep(3000);
	orderDetailsObject = new OrderDetailsPage(driver);
	orderDetailsObject.downloadPdfInvoice();
	orderDetailsObject.printOrderDetails();
	
	printObject = new PrintPage(driver) ;
	assertTrue(printObject.orderStatus.isDisplayed());
	
	
	Thread.sleep(3000);
	
	registeredUserObject = new RegisteredUserHomePage(driver) ;
	registeredUserObject.loggedinUserCanLogout();
}
		

}
