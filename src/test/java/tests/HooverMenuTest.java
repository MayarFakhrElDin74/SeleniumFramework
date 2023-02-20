package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class HooverMenuTest extends TestBase {

	HomePage homeObject ;
	

	
	@Test
	
	public void  goToNotebooksPage ()
	{
		
		homeObject = new HomePage(driver) ;
		homeObject.goToNotebooksPage();
		
		assertTrue(driver.getCurrentUrl().contains("notebooks")) ;
		
	}
}
