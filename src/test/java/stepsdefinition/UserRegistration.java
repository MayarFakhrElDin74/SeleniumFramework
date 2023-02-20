package stepsdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisteredUserHomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	
	
	HomePage homeObject ;
	UserRegistrationPage registerObject ;
	LoginPage loginObject ;
	RegisteredUserHomePage registeredUserObject ;
	MyAccountPage myAccountObject ;
	
	
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		
		homeObject = new HomePage(driver) ;
	    homeObject.openRegistrationPage();
	    
	}
	
	
	@When("he clicks on register link")
	public void he_clicks_on_register_link() {
	    assertTrue(driver.getCurrentUrl().contains("register"));
		
	}
	
	
	@When("enters his data {string} , {string} , {string}, {string}")
	public void enters_his_data(String firstname , String lastname , String email , String password) {
		
		registerObject = new UserRegistrationPage(driver) ;
	    registerObject.userRegistration(firstname , lastname , email , password);
		
	}
	
	
	@Then("the registration page is displayed successfully")
	public void the_registration_page_is_displayed_successfully() {
		
		System.out.println(registerObject.successMsg.getText());
	    assertEquals(registerObject.successMsg.getText(), "Your registration completed");
	    
	    
	}


}
