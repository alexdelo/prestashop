package com.automation.objects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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
	
	Random random = new Random();
	
	@FindBy(id = "add_to_cart")
	public WebElement addToCart;
	
	@FindBy(className = "cart_quantity")
	public WebElement numberOfProductsInCart;
	
	@FindBy(css = ".fa.fa-shopping-bag")
	public WebElement cartButton;
	
	@FindBy(id = "button_goto_cart")
	public WebElement beginCheckout;
	
	@FindBy(css = ".fa.fa-trash")
	public WebElement removeButton;
	
	@FindBy(id = "attributes")
	public WebElement sizeRow;
	
	public void selectSize() {	
		List<WebElement> sizes = sizeRow.findElements(By.tagName("a"));
		clickElement(sizes.get(random.nextInt(sizes.size())));
	}
	
	public void addToCart() {
		clickElement(addToCart);
		wait(2);
		assertionTrue(numberOfProductsInCart, "1");
	}
	
	public void beginCheckout() {
		hoverOverElement(cartButton);
		clickElement(beginCheckout);
	}
	
	public void removeProduct() {
		hoverOverElement(cartButton);
		clickElement(removeButton);
		wait(2);
		assertionTrue(numberOfProductsInCart, "0");
	}

}
