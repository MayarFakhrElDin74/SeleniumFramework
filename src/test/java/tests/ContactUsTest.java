package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	
	String name = "Mayar" ;
	String email = "ay7aga1@gmail.com" ;
	String enquiryTxt = "Hi, this product is good!" ;
	
	
	ContactUsPage contactUsObject ;
	HomePage homeObject ;
	
	@Test
	
	public void contactUs () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.openContactUsPage();
		
		Thread.sleep(3000);
		contactUsObject = new ContactUsPage(driver) ;
		contactUsObject.contactUs(name , email, enquiryTxt);
		
		assertEquals(contactUsObject.contactUsSuccessNotification.getText(),
				"Your enquiry has been successfully sent to the store owner.");
	}

}
