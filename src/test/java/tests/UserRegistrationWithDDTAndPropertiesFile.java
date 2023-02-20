package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase {
	
	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;
	
	
	String firstName = LoadProperties.userData.getProperty("firstName") ;
	String lastName = LoadProperties.userData.getProperty("lastName") ;
	String email = LoadProperties.userData.getProperty("email") ;
	String password = LoadProperties.userData.getProperty("password") ;
			
	
	
@Test (priority = 1)
	
	public void userCanRegisterSuccessfully () throws InterruptedException 
	
	{
		
    homeObject = new HomePage(driver) ;
    homeObject.openRegistrationPage();
    
    registerObject = new UserRegistrationPage(driver) ;
    registerObject.userRegistration(firstName , lastName , email , password);
    
    System.out.println(registerObject.successMsg.getText());
    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
    
    Thread.sleep(3000);
    homeObject.openLoginPage();
    
    Thread.sleep(3000);
	loginObject = new LoginPage(driver) ;
	loginObject.userLogin(email , password);
    
  
		Thread.sleep(3000);
		registeredUserObject = new RegisteredUserHomePage(driver) ;
		registeredUserObject.loggedinUserCanLogout();			
		
	}

}
