package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

public class AddToCompareTest extends TestBase {
	
	String incompleteProductName = "macb" ;
	String productName = "Apple MacBook Pro 13-inch" ;
	
	String incompleteSecondProductName = "asus" ;
	String secondProductName = "Asus N551JK-XO076H Laptop" ;
			
			
	HomePage homeObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	AddToComparePage addToCompareObject ;
	
	
	@Test (priority = 1)
	
	public void addFirstProductToCompareList () throws InterruptedException 
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
			Thread.sleep(3000);
			
			productDetailsObject = new ProductDetailsPage(driver) ;
			productDetailsObject.addProductToCompareList();
		}
	
	
		@Test (priority = 2)
		
		public void addSecondProductToCompareList () throws InterruptedException 
		{
			
			homeObject = new HomePage(driver) ;
			homeObject.searchProductUsingAutoSuggest(incompleteSecondProductName);
			
			Thread.sleep(3000);
		
				productDetailsObject = new ProductDetailsPage(driver) ;
				productDetailsObject.addProductToCompareList();
			}
			
			
			@Test (priority = 3)
			public void compareProducts () throws InterruptedException 
			
			{
		Thread.sleep(3000);
				productDetailsObject = new ProductDetailsPage(driver) ;
				productDetailsObject.goToComparisonPage();
			
					addToCompareObject = new AddToComparePage(driver) ;
					addToCompareObject.compareTwoProducts();
					
					assertTrue(addToCompareObject.compareTable.isDisplayed());
					
				}
				
				@Test (priority = 4)
				
				public void clearCompareProductList ()
				{
					addToCompareObject = new AddToComparePage(driver) ;
					addToCompareObject.clearCompareProductList();
					
					assertTrue(addToCompareObject.clearListNotification.getText().equals("You have no items to compare."));
				}
			

}
