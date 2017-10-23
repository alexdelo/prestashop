package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.objects.CategoryPage;
import com.automation.objects.CheckoutPage;
import com.automation.objects.HomePage;
import com.automation.objects.ProductDetailsPage;
import com.automation.prestashop.BasePage;

public class PlaceOrderAsGuestWithMobilePayTest extends BasePage {

	HomePage home;
	CategoryPage category;
	ProductDetailsPage PDP;
	CheckoutPage checkout;
	
	@Test
	public void placeOrderAsGuestWithMobilePay() {
		home = new HomePage(driver);
		home.goToCategoryPage();
		category = new CategoryPage(driver);
		category.clickRandomProduct();
		PDP = new ProductDetailsPage(driver);
		PDP.selectSize();
		PDP.addToCart();
		PDP.beginCheckout();
		checkout = new CheckoutPage(driver);
		checkout.fillInShippingAddress();
		checkout.selectMobilePayPaymentMethod();
		checkout.checkTermsAndConditions();
		checkout.fillInPaymentInformationAndSubmit();
	}

}
