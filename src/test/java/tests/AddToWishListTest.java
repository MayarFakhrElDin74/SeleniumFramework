package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToWishListPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

public class AddToWishListTest extends TestBase {
	
	String incompleteProductName = "macb" ;
	String productName = "Apple MacBook Pro 13-inch" ;
	
	HomePage homeObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	AddToWishListPage addToWishListObject ;
	
	
@Test (priority = 1)
	
	public void searchProductUsingAutoSuggest () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.productBreadCrumb.getText().equals(productName));
	}


@Test (priority = 2) 

public void addProductToWishList () throws InterruptedException
{
	productDetailsObject = new ProductDetailsPage(driver);
	productDetailsObject.addProductToWishList();
	
	addToWishListObject = new AddToWishListPage(driver) ;
	assertTrue(addToWishListObject.productAddedName.getText().equals(productName)) ;
	
}
	
	
	@Test (priority = 3) 
	
	public void removeProductFromWishList() throws InterruptedException
	{
		
		Thread.sleep(3000);
		
	addToWishListObject = new AddToWishListPage(driver) ;
    addToWishListObject.removeProductFromWishList();
	
	assertTrue(addToWishListObject.removeProductNotification.getText().equals("The wishlist is empty!"));
	
	}
			

}


