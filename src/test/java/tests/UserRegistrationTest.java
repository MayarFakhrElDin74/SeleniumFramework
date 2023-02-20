package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	String firstName = "Mayar" ;
	String lastName = "Fakhr ElDin" ;
	String email = "ay7aga555555@gmail.com" ;
	String password = "12345678" ;
	String newPassword = "11223344" ;
	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;
	
	
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
	
	//@Test (priority = 3)
	public void loggedinUserCanLogout () throws InterruptedException
	{
		Thread.sleep(3000);
		registeredUserObject = new RegisteredUserHomePage(driver) ;
		registeredUserObject.loggedinUserCanLogout();	
	}
	
		@Test (priority = 4)
		public void changePassword () throws InterruptedException
		{
			Thread.sleep(3000);
			
			myAccountObject = new MyAccountPage(driver) ;
			myAccountObject.registeredUserChangePassword();
			
			assertTrue(myAccountObject.changePasswordSuccessMsg.getText().equals("Password was changed")) ;	
			
			registeredUserObject = new RegisteredUserHomePage(driver) ;
			registeredUserObject.loggedinUserCanLogout();
		}
		
		
		@Test (priority = 5)
		public void userCanLoginWithNewPassword () throws InterruptedException
		{
			Thread.sleep(3000);
			
			homeObject = new HomePage(driver);
			homeObject.openLoginPage();
			
			loginObject = new LoginPage(driver) ;
			loginObject.userLogin(email, newPassword);
				
		}
}
