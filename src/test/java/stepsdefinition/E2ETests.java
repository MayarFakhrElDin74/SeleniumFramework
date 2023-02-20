package stepsdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
import tests.TestBase;

public class E2ETests extends TestBase {
	
	
	
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
	
	
	
	@Given("user is registered and loggedin {string} , {string} , {string}, {string}")
	public void user_is_registered_and_loggedin (String firstname , String lastname , String email , String password) throws InterruptedException {
		
		Thread.sleep(3000);
		homeObject = new HomePage(driver) ;
	    homeObject.openRegistrationPage();
	    
	    registerObject = new UserRegistrationPage(driver) ;
	    registerObject.userRegistration(firstname, lastname, email, password);
	    
	    System.out.println(registerObject.successMsg.getText());
	    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
	    
    	homeObject.openLoginPage();
    	loginObject = new LoginPage(driver) ;
    	loginObject.userLogin(email, password);
	    
	}
	
	
	@When("he searches for {string}")
	public void he_searches_for_apple_mac_book_pro_inch(String productname) throws InterruptedException {
		Thread.sleep(3000);
		
		homeObject = new HomePage(driver) ;
		homeObject.searchProduct(productname);
		searchResultObject = new SearchResultPage(driver) ;
	
		searchResultObject.goToProductDetails();
		
	
	}
	
	
	@When("chooses to buy 1 item")
	public void chooses_to_buy_1_item () throws InterruptedException {
		
		Thread.sleep(3000);
		productDetailsObject = new ProductDetailsPage(driver) ;
		productDetailsObject.addProductToCart();
		
	}
	
	
	@When("moves to checkout cart and enter personal details on chekout page and place the order {string} , {string} , {string} , {string} , {string}")
	public void moves_to_checkout_cart_and_enter_personal_details_on_chekout_page_and_place_the_order 
	(String countryname, String cityname, String adress1Txt,  String zipCodeTxt, String phoneNumberTxt) throws InterruptedException
	{
		Thread.sleep(3000);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		productDetailsObject.goToAddToCartPage();
		
		addToCartObject = new AddToCartPage(driver) ;
		addToCartObject.goToCheckoutPage();
		
		Thread.sleep(3000);
		productCheckoutObject = new ProductCheckoutPage(driver) ;
		productCheckoutObject.fillingpersonalInfoForOrderCheckout
		(countryname, cityname, adress1Txt, zipCodeTxt, phoneNumberTxt);
		
		Thread.sleep(9000);
	    productCheckoutObject.selectshippingMethod();
	    
	    Thread.sleep(3000);
	    productCheckoutObject.selectPaymentMethod();
	    
	    Thread.sleep(3000);
	    productCheckoutObject.confirmPaymentInfo();
	    
	    Thread.sleep(3000);
	    productCheckoutObject.confirmOrder();
	}
	  
	
	    
	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		
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
