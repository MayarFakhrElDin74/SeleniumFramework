package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import pages.AddYourReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.UserRegistrationPage;

public class AddYourReviewTest extends TestBase {

	String firstName = "Mayar" ;
	String lastName = "Fakhr ElDin" ;
	String email = "ay7aga555555555555@gmail.com" ;
	String password = "12345678" ;
	String incompleteProductName = "macb" ;
String reviewTitle = "Good product" ;
String reviewTxt = "This product is Good!" ;
	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	AddYourReviewPage addReviewObject ;
	
	
	
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
	}



	@Test (priority = 4)
	
	public void registeredUserCanAddReview ()
	{
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		productDetailsObject.goToAddYourReviewPage();
		
		addReviewObject = new AddYourReviewPage(driver) ;
		addReviewObject.registeredUserCanAddReview(reviewTitle, reviewTxt) ;
		
assertEquals(addReviewObject.addReviewSuccessNotification.getText(), "Product review is successfully added.");	

	}
	
	
	
}
