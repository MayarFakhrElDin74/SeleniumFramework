package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {

	
HomePage homeObject ;
UserRegistrationPage registerObject ;
LoginPage loginObject ;
RegisteredUserHomePage registeredUserObject ;
MyAccountPage myAccountObject ;
	
Faker fakerData = new Faker () ;
	
String firstname = fakerData.name().firstName() ;
String lastname = fakerData.name().lastName() ; 
String email = fakerData.internet().emailAddress() ;
String password = fakerData.number().digits(7).toString() ;


	@Test (priority = 1)
		
		public void userCanRegisterSuccessfully  () throws InterruptedException 
		
		{
			
	    homeObject = new HomePage(driver) ;
	    homeObject.openRegistrationPage();
	    
	    registerObject = new UserRegistrationPage(driver) ;
	    registerObject.userRegistration(firstname , lastname , email , password);
	    
	    System.out.println("User data is: " +firstname +" " +lastname +" " +email +" " + password +" ");
	    
	    System.out.println(registerObject.successMsg.getText());
	    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
	    
	    Thread.sleep(3000);
	    homeObject.openLoginPage();
	    
	    Thread.sleep(3000);
		loginObject = new LoginPage(driver) ;
		loginObject.userLogin(email, password);
	    
	  
			Thread.sleep(3000);
			registeredUserObject = new RegisteredUserHomePage(driver) ;
			registeredUserObject.loggedinUserCanLogout();			
			
		}
		
}
