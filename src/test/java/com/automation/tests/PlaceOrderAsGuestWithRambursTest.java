package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.objects.CategoryPage;
import com.automation.objects.CheckoutPage;
import com.automation.objects.HomePage;
import com.automation.objects.ProductDetailsPage;
import com.automation.prestashop.BasePage;

public class PlaceOrderAsGuestWithRambursTest extends BasePage {

	HomePage home;
	CategoryPage category;
	ProductDetailsPage PDP;
	CheckoutPage checkout;
	
	@Test
	public void placeOrderAsGuestWithRamburs() {
		home = new HomePage(driver);
		home.goToCategoryPage();
		category = new CategoryPage(driver);
		category.clickRandomProduct();
		PDP = new ProductDetailsPage(driver);
		PDP.addToCart();
		PDP.beginCheckout();
		checkout = new CheckoutPage(driver);
		checkout.fillInShippingAddress();
		checkout.selectRambursPaymentMethod();
		checkout.placeOrder();
	}

}
