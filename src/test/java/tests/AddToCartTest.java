package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

public class AddToCartTest extends TestBase {
	
	
	String incompleteProductName = "macb" ;
	String productName = "Apple MacBook Pro 13-inch" ;
	String finalProductQuantity = "4" ;
	
	HomePage homeObject ;
	SearchResultPage searchResultObject ;
	ProductDetailsPage productDetailsObject ;
	AddToCartPage addToCartObject ;
	
	
@Test (priority = 1)
	
	public void searchProductUsingAutoSuggest () throws InterruptedException
	{
		homeObject = new HomePage(driver) ;
		homeObject.searchProductUsingAutoSuggest(incompleteProductName);
		
		productDetailsObject = new ProductDetailsPage(driver) ;
		assertTrue(productDetailsObject.productBreadCrumb.getText().equals(productName));
	}


@Test (priority = 2)
public void addToCart () throws InterruptedException
{
	productDetailsObject = new ProductDetailsPage(driver) ;
	productDetailsObject.addProductToCart();
	Thread.sleep(3000);
	productDetailsObject.goToAddToCartPage();
	
}


@Test (priority = 3)
public void manageshoppingCart () throws InterruptedException
{Thread.sleep(3000);
	addToCartObject = new AddToCartPage(driver) ;
	
	addToCartObject.modifyProductQuantity(finalProductQuantity);
	addToCartObject.updateShoppingCart();
	
	assertTrue(addToCartObject.shoppingCartQuantity.getText().contains(finalProductQuantity)) ;
	
	
}

@Test (priority = 4)
public void clearShoppingCart ()
{
	addToCartObject = new AddToCartPage(driver) ;
	addToCartObject.clearShoppingCart();
	assertTrue(addToCartObject.emptyCartNotification.getText().equals("Your Shopping Cart is empty!"));
}




}
