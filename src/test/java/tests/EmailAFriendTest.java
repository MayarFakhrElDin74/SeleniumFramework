package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.EmailAFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDetailsPage;
import pages.RegisteredUserHomePage;
import pages.SearchResultPage;
import pages.UserRegistrationPage;

public class EmailAFriendTest extends TestBase {

	String firstName = "Mayar" ;
	String lastName = "Fakhr ElDin" ;
	String email = "ay7aga666666666666666666666666@gmail.com" ;
	String password = "12345678" ;
	String productName = "Apple MacBook Pro 13-inch" ;
	String incompleteProductName = "macb" ;
	String friendsEmail = "test@gmail.com" ;
	String msgTxt = "Hi!";
	

	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	EmailAFriendPage emailFriendObject ;
	
	
	
	@Test (priority = 1)
	public void userCanRegisterSuccessfully () throws InterruptedException 
	{
		Thread.sleep(3000);
    homeObject = new HomePage(driver) ;
    homeObject.openRegistrationPage();
    
    registerObject = new UserRegistrationPage(driver) ;
    registerObject.userRegistration(firstName, lastName, email, password);
    
    System.out.println(registerObject.successMsg.getText());
    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
    
	}
	
  
	//@Test (priority = 2)
		public void loggedinUserCanLogout () throws InterruptedException
		{
			Thread.sleep(3000);
			registeredUserObject = new RegisteredUserHomePage(driver) ;
			registeredUserObject.loggedinUserCanLogout();	
		}
	
	
    @Test (priority = 3)
    public void resgistredUserCanLoginSuccessfully () throws InterruptedException
    {
    	Thread.sleep(3000);
    	
    homeObject = new HomePage(driver) ;
    homeObject.openLoginPage();
    	
	loginObject = new LoginPage(driver) ;
	loginObject.userLogin(email, password);
    
	}
    
   
	@Test (priority = 4 )
	
	public void searchProductUsingAutoSuggest () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.productBreadCrumb.getText().equals(productName));	
		
	}
	
	
	@Test (priority = 5)
	
	public void  emaiAFriend () throws InterruptedException 
	
	{
		Thread.sleep(3000);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		productDetailsObject.goToEmailAFriendPage();
		
		emailFriendObject = new EmailAFriendPage(driver) ;
		emailFriendObject.emailAFriend(friendsEmail, msgTxt);
		
		assertEquals(emailFriendObject.emailAFriendSuccessNotification.getText(), "Your message has been sent.");
		
	}
    
    
    
}
