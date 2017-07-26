package com.automation.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;

public class ProductDetailsPage extends BasePage {
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "add_to_cart_custom")
	public WebElement addToCart;
	
	@FindBy(css = ".ajax_cart_quantity.ajax_cart_middle")
	public WebElement numberOfProductsInCart;
	
	@FindBy(id = "blockcart_top_wrap")
	public WebElement cartButton;
	
	
	public void addToCart() {
		clickElement(addToCart);
		wait(4);
		assertionTrue(numberOfProductsInCart, "1");
	}
	
	public void beginCheckout() {
		clickElement(cartButton);
	}

}
