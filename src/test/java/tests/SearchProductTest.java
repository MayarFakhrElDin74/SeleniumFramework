package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

public class SearchProductTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch" ;
	
	
	HomePage homeObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	
	
	@Test (priority = 1)
	
	public void searchProduct ()
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProduct(productName);
	}
	
	@Test (priority = 2 )
	
	public void goToProductDetails () throws InterruptedException
	{
		Thread.sleep(3000);
		searchResultObject = new SearchResultPage(driver) ;
		searchResultObject.goToProductDetails();
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.productBreadCrumb.getText().equals(productName));
	}
	
	
}
