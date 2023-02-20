package tests;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJson  extends TestBase {

	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;




	@Test (priority = 1)
		
		public void userCanRegisterSuccessfully () throws InterruptedException, FileNotFoundException, IOException, ParseException 
		
		{
			JsonDataReader jsonDataReader = new JsonDataReader() ;
			jsonDataReader.jsonReader();
			
	    homeObject = new HomePage(driver) ;
	    homeObject.openRegistrationPage();
	    
	    registerObject = new UserRegistrationPage(driver) ;
	    registerObject.userRegistration
	    (jsonDataReader.firstname , jsonDataReader.lastname , jsonDataReader.email , jsonDataReader.password);
	    
	    System.out.println(registerObject.successMsg.getText());
	    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
	    
	    Thread.sleep(3000);
	    homeObject.openLoginPage();
	    
	    Thread.sleep(3000);
		loginObject = new LoginPage(driver) ;
		loginObject.userLogin(jsonDataReader.email , jsonDataReader.password);
	    
	  
			Thread.sleep(3000);
			registeredUserObject = new RegisteredUserHomePage(driver) ;
			registeredUserObject.loggedinUserCanLogout();			
			
		}
		
}
