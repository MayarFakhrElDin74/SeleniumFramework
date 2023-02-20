package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;


public class UserRegistrationTestWithDDTAndDataProvider extends TestBase {
	

HomePage homeObject ;
UserRegistrationPage registerObject ;
LoginPage loginObject ;
RegisteredUserHomePage registeredUserObject ;
MyAccountPage myAccountObject ;


@DataProvider (name = "testData")

public static Object [] [] userData ()
{
	
	return new Object [] [] {
		
		{"Mayar", "Fakhr ElDin" , "test000000@gmail.com" , "1234567"} ,
		{"Esraa" , "Abdelwahab" , "test222222@gmail.com" , "11223344"}
		
	} ;
	
}


@Test (priority = 1 , dataProvider = "testData")
	
	public void userCanRegisterSuccessfully 
	(String firstName , String lastName , String email , String password) throws InterruptedException 
	
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
	loginObject.userLogin(email, password);
    
  
		Thread.sleep(3000);
		registeredUserObject = new RegisteredUserHomePage(driver) ;
		registeredUserObject.loggedinUserCanLogout();			
		
	}
	
    	
}


