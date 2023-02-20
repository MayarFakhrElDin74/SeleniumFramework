package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class ChangeCurrencyTest extends TestBase {
	
	String incompleteProductName = "macb" ;
	
	
	HomePage homeObject ;
	ProductDetailsPage productDetailsObject ;
	

	
	@Test (priority = 1)
	
	public void changeCurrency ()
	{
		homeObject = new HomePage(driver) ;
		homeObject.changeCurrency();
	}


	
@Test (priority = 2)
	
	public void searchProductUsingAutoSuggest () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.priceLbl.getText().contains("€"));
	}
}
