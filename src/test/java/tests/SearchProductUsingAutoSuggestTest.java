package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

public class SearchProductUsingAutoSuggestTest extends TestBase  {
	
	String incompleteProductName = "macb" ;
	String productName = "Apple MacBook Pro 13-inch" ;
	
	HomePage homeObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	
@Test 
	
	public void searchProductUsingAutoSuggest () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.productBreadCrumb.getText().equals(productName));
	}

}
