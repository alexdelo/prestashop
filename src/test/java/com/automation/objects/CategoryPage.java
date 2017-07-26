package com.automation.objects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;

public class CategoryPage extends BasePage {
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Random random = new Random();

	@FindBy(className  = "product_img_link")
	public List<WebElement> products;
	
	@FindBy(className = "zoomPad")
	public WebElement productImage;
	
	
	public void clickRandomProduct() {
		clickElement(products.get(random.nextInt(products.size())));
		waitForElementToBeDisplayed(productImage);
	}
}
