package tests;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {
	
	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;
	
	CSVReader reader ;
	
	
@Test (priority = 1)

	
	public void userCanRegisterSuccessfully 
	() throws InterruptedException, CsvValidationException, IOException 
	
	{
		
	String CSV_file = System.getProperty(("user.dir") + "/src/test/java/data/UserData 2.csv") ;
	
	reader = new CSVReader(new FileReader(CSV_file)) ;
	
	
	String [] csvCell ;
	
	
	while ((csvCell = reader.readNext()) != null ) {
		
		String firstName = csvCell [0] ;
		String lastName = csvCell [1] ;
		String email = csvCell [2] ;
		String password = csvCell [3] ;
			
			
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

}
